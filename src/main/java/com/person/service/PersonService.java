package com.person.service;

import com.person.dao.PersonDao;
import com.person.model.domain.Person;
import com.person.model.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonDTO savePerson(PersonDTO personDTO) throws Exception {
        Person person = Person.builder()
                .name(personDTO.getName())
                .address(personDTO.getAddress())
                .postCode(personDTO.getPostCode())
                .age(personDTO.getAge())
                .job(personDTO.getJob())
                .email(personDTO.getEmail())
                .phone(personDTO.getPhone())
                .build();

        person = this.personDao.saveAndFlush(person);

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonDTO getPerson(Integer personID) throws Exception {
        Person person = this.personDao.getById(personID);

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PersonDTO> getAllPerson() throws Exception {
        List<PersonDTO> personDTOS = new ArrayList<>();
        List<Person> persons = this.personDao.findAll();

        for (Person person : persons) {

            PersonDTO personDTO = PersonDTO.builder()
                    .personID(person.getPersonID())
                    .address(person.getAddress())
                    .job(person.getJob())
                    .email(person.getEmail())
                    .age(person.getAge())
                    .phone(person.getPhone())
                    .postCode(person.getPostCode())
                    .name(person.getName())
                    .build();

            personDTOS.add(personDTO);
        }

        return personDTOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonDTO updatePerson(Integer personID, PersonDTO personDTO) throws Exception {
        Person person = this.personDao.getById(personID);

        person.setName(personDTO.getName());
        person.setAddress(personDTO.getAddress());
        person.setPostCode(personDTO.getPostCode());
        person.setAge(personDTO.getAge());
        person.setJob(personDTO.getJob());
        person.setEmail(personDTO.getEmail());
        person.setPhone(personDTO.getPhone());

        person = this.personDao.saveAndFlush(person);

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean deletePerson(Integer personID) throws Exception {
        Person person = this.personDao.getById(personID);

        this.personDao.delete(person);

        return true;
    }
}
