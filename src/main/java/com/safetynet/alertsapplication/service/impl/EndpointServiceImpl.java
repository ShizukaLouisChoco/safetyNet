package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.dao.impl.DataStorageImpl;
import com.safetynet.alertsapplication.dto.*;
import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.repository.FireStationRepository;
import com.safetynet.alertsapplication.repository.PersonRepository;
import com.safetynet.alertsapplication.repository.impl.FireStationRepositoryImpl;
import com.safetynet.alertsapplication.repository.impl.PersonRepositoryImpl;
import com.safetynet.alertsapplication.service.EndpointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Log4j2
@Service
    public class EndpointServiceImpl implements EndpointService {

    //log.info("EndpointServiceImpl");

    private final DataStorage dataStorage;
    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    public EndpointServiceImpl(DataStorage dataStorage, FireStationRepository fireStationRepository, PersonRepository personRepository){
        this.dataStorage = dataStorage;
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
    }

    /**
     * @return The list of person's information
     * (full name + address + phone number)+number of adults+number of child.
     * <p>
     * http://localhost:8080/firestation?stationNumber=<station_number>
     * Cette url doit retourner une liste des personnes couvertes par la caserne de pompiers correspondante. Donc, si le numéro de station = 1, elle doit renvoyer les habitants couverts par la station numéro 1. La liste doit inclure les informations spécifiques suivantes :
     * prénom, nom, adresse, numéro de téléphone.
     * De plus elle doit fournir un décompte du nombre d'enfants (tout individu âgé de 18 ans ou moins) dans la zone desservie.
     */
    @Override
    public PersonsInformationWithChildNumberDTO01 getPersonsInformationWithAdultAndChildNumberByStationNumber(String fireStationNumber) {

        var fireStationAddress = fireStationRepository
                .getAllFireStationByStationNumber(fireStationNumber)
                .findFirst()
                .orElseThrow(FireStationNotFoundException::new)
                .getAddress();

        var person = personRepository
                .getAllByAddress(fireStationAddress)
                .map(p -> new PersonInformationWithMedicalRecordsForAllDTO(p, findMedicalRecordByPerson(p)))
                .toList();

        return new PersonsInformationWithChildNumberDTO01(person);
    }

    /**
     * @return The list of children's information
     * (full name + age + family member).
     * if there's no child, return String empty
     * <p>
     * http://localhost:8080/childAlert?address=<address>
     * Cette url doit retourner une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette adresse. La liste doit comprendre
     * le prénom et le nom de famille de chaque enfant, son âge et une liste des autres membres du foyer. S'il n'y a pas d'enfant, cette url peut renvoyer une chaîne vide.
     */
    @Override
    public ChildInformationWithFamilyDTO02 getChildInformationByAddress(String address) {
        var personList = personRepository
                .getAllByAddress(address)
                .map(p -> new PersonInformationWithMedicalRecordsForAllDTO(p, findMedicalRecordByPerson(p)))
                .toList();

        return new ChildInformationWithFamilyDTO02(personList);
    }

    /**
     * @return The list of phone number
     *
     * http://localhost:8080/phoneAlert?firestation=<firestation_number>
     * Cette url doit retourner une liste des numéros de téléphone des résidents desservis par la caserne de pompiers. Nous l'utiliserons pour envoyer des messages texte d'urgence à des foyers spécifiques.
     */
    @Override
    public List<String> getPhoneNumberListByFireStationNumber(String fireStationNumber) {

        var fireStationAddress = fireStationRepository
                .getAllFireStationByStationNumber(fireStationNumber)
                .findFirst()
                .orElseThrow(() -> new FireStationNotFoundException())
                .getAddress();

        return personRepository
                .getAllByAddress(fireStationAddress)
                .map(p -> p.getPhone())
                .collect(Collectors.toList());
    }

    /**
     * @return The list of person info
     * (lastName, phone number, age, medical record(medications+allergies+pastMedicalHistories))
     * & fire station number
     * <p>
     * http://localhost:8080/fire?address=<address>
     * Cette url doit retourner la liste des habitants vivant à l’adresse donnée ainsi que le numéro de la caserne de pompiers la desservant. La liste doit inclure le nom, le numéro de téléphone, l'âge et les antécédents médicaux (médicaments, posologie et allergies) de chaque personne.
     */
    @Override
    public PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05 getPersonsInformationWithMedicalRecordsByAddress(String address) {

        var fireStation = fireStationRepository
                .getAllFireStationByAddress(address)
                .findFirst()
                .orElseThrow(FireStationNotFoundException::new);

        var person =   personRepository
                .getAllByAddress(fireStation.getAddress())
                .map(p -> new PersonInformationWithMedicalRecordsForAllDTO(p, findMedicalRecordByPerson(p)))
                .toList();


               return new PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05(person,fireStation.getStation());

    }


    /**
     * http://localhost:8080/flood/stations?stations=<a list of station_numbers>
     * Cette url doit retourner une liste de tous les foyers desservis par la caserne. Cette liste doit regrouper les personnes par adresse. Elle doit aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et faire figurer leurs antécédents médicaux (médicaments, posologie et allergies) à côté de chaque nom.
     */
    @Override
    public List<PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04> getPersonsInformationWithMedicalRecordsByListOfStationNumber(List<String> fireStationNumbers) {
        //get Address list from station numbers list
        List<String> fireStationAddressList = fireStationRepository
                .getAllFireStationByStationNumberList(fireStationNumbers)
                .map(f -> f.getAddress())
                .toList();

        //get person from fireStationAddressList
       var personList = personRepository
               .getPersonByAddressList(fireStationAddressList)
                .map( p -> new PersonInformationWithMedicalRecordsForAllDTO(p, findMedicalRecordByPerson(p)))
               .toList();


        return  personList
                .stream()
                .map(p -> new PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04(personList, fireStationAddressList))
                .toList();
    }


    /**
     * @return The list of person info
     * ( family name + address + age + mail address + medical record)
     * <p>
     * http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
     * Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les antécédents médicaux (médicaments, posologie, allergies) de chaque habitant.
     * Si plusieurs personnes portent le même nom, elles doivent toutes apparaître.
     */
    @Override
    public PersonInformationWithMedicalRecordByNameDTO06 getPersonInformationWithMedicalRecordsByFirstNameAndLastName(String firstName, String lastName) {
                Person person = dataStorage
                .getPersons()
                .stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(PersonNotFoundException::new);
       return new PersonInformationWithMedicalRecordByNameDTO06(person, findMedicalRecordByPerson(person));
    }

    /**
     * @return The list of email
     *
     * http://localhost:8080/communityEmail?city=<city>
     * Cette url doit retourner les adresses mail de tous les habitants de la ville.
     */
    @Override
    public List<String> getEmailListByCity(String city) {
        //get Person list by City
        var personByCity = personRepository
                .getPersonByCity(city)
                .toList();

        List<String> emailList = (List<String>) personByCity.stream().map(p -> p.getEmail());
        return emailList;
    }

    @Override
    public PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05 getPersonsInformationWithMedicalRecordsAndFirestationNumberByAddress(String address){

        // number de la firestation
        // trouver les personnes a cette adresse
        // trouver les infos medicals pour ces personnes

        var stationNumber = dataStorage
                .getFireStations().stream().filter(f -> f.getAddress().equals(address))
                .findFirst()
                .orElseThrow(FireStationNotFoundException::new)
                .getStation();

        var personInfoWithMedicalRecordsDTOs = dataStorage
                .getPersons()
                .stream()
                .filter(p -> p.getAddress().equals(address))
                .map( p -> new PersonInformationWithMedicalRecordsForAllDTO(p, findMedicalRecordByPerson(p)))
                .toList();

        return new PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05(personInfoWithMedicalRecordsDTOs, stationNumber);


    }

    private MedicalRecord findMedicalRecordByPerson(Person p){
        return dataStorage
                .getMedicalRecords()
                .stream()
                .filter(m -> m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName()))
                .findFirst()
                .orElseThrow(MedicalRecordNotFoundException::new);
    }

    private boolean isChild (MedicalRecord medicalRecord){
        if(medicalRecord.getAge()<18){
            return true;
        }else {
            return false;
        }
    }

    private Person findPersonsByFireStation(FireStation f){
        return dataStorage
                .getPersons()
                .stream()
                .filter(p -> p.getAddress().equals(f.getAddress()))
                .findFirst()
                .orElseThrow(FireStationNotFoundException::new);

    }

    private FireStation findAddressByFireStationNumber(String fireStationNumber){
        return dataStorage
                .getFireStations()
                .stream()
                .filter(f -> f.getStation().equals(fireStationNumber))
                .findFirst()
                .orElseThrow(FireStationNotFoundException::new);
    }

    /**private int getAgeByBirthdate(LocalDate birthdate){
        LocalDate now = LocalDate.now();
        if ((birthdate != null) && (now != null)) {
                Integer age = Period.between(birthdate, now).getYears();
                return age;
            } else {
                return -1;
            }
    }*/


}
