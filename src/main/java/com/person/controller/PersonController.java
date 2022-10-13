package com.person.controller;

import com.person.model.common.ResponseDTO;
import com.person.model.dto.PersonDTO;
import com.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/savePerson", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<PersonDTO>> savePerson(@RequestBody PersonDTO updatePersonDTO) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            PersonDTO personDTO = this.personService.savePerson(updatePersonDTO);

            response.setResult(personDTO);
            response.setStatus("SUCCESS");
            httpStatus = HttpStatus.CREATED;

        } catch (Exception e) {
            response.setStatus("FAILED");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/getAllPerson", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<PersonDTO>>> getAllPerson() {
        ResponseDTO<List<PersonDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<PersonDTO> allPersons = this.personService.getAllPerson();

            response.setResult(allPersons);
            response.setStatus("SUCCESS");
            httpStatus = HttpStatus.OK;

        } catch (Exception e) {
            response.setStatus("FAILED");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/getPerson/{personID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<PersonDTO>> getPerson(@PathVariable Integer personID) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            PersonDTO personDTO = this.personService.getPerson(personID);

            response.setResult(personDTO);
            response.setStatus("SUCCESS");
            httpStatus = HttpStatus.OK;

        } catch (Exception e) {
            response.setStatus("FAILED");
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/updatePerson/{personID}")
    public ResponseEntity<ResponseDTO<PersonDTO>> updatePerson(@PathVariable Integer personID, @RequestBody PersonDTO updatePersonDTO) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            PersonDTO personDTO = this.personService.updatePerson(personID, updatePersonDTO);

            response.setResult(personDTO);
            response.setResult(personDTO);
            response.setStatus("SUCCESS");
            httpStatus = HttpStatus.CREATED;

        } catch (Exception e) {
            response.setStatus("FAILED");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/deletePerson/{personID}")
    public ResponseEntity<ResponseDTO<Boolean>> deletePerson(@PathVariable Integer personID) {
        ResponseDTO<Boolean> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            personService.deletePerson(personID);
            response.setResult(true);
            response.setStatus("SUCCESS");
            httpStatus = HttpStatus.NO_CONTENT;
        } catch (Exception e) {
            response.setResult(false);
            response.setStatus("FAILED");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
