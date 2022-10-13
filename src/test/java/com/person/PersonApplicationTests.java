package com.person;

import com.person.model.dto.PersonDTO;
import com.person.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    public void savePerson() throws Exception {

        PersonDTO personDTO = PersonDTO.builder()
                .name("Viraj M")
                .address("Colombo")
                .postCode("7100")
                .age(27)
                .job("BA")
                .email("g@gmail.com")
                .phone("119")
                .build();

        PersonDTO result = this.personService.savePerson(personDTO);
        assertNotNull(result.getPersonID());
    }

    @Test
    @Order(2)
    public void getPerson() throws Exception {
        Integer personID = 7;

        PersonDTO result = this.personService.getPerson(personID);

        assertNotNull(result);
    }

    @Test
    @Order(3)
    public void getAllPerson() throws Exception {
        List<PersonDTO> results = this.personService.getAllPerson();

        assertNotNull(results);
    }

    @Test
    @Order(4)
    public void updatePerson() throws Exception {
        Integer personID = 7;

        PersonDTO personDTO = new PersonDTO();

        personDTO.setName("Viraj M");
        personDTO.setAddress("Colombo - 5");
        personDTO.setPostCode("7100");
        personDTO.setAge(25);
        personDTO.setJob("BA");
        personDTO.setEmail("g@gmail.com");
        personDTO.setPhone("+94778444");

        PersonDTO result = this.personService.updatePerson(personID, personDTO);
        assertNotNull(result);
    }

    @Test
    @Order(5)
    public void deletePerson() throws Exception {
        Integer personID = 7;

        Boolean result = this.personService.deletePerson(personID);

        assertNotNull(result);
    }
}
