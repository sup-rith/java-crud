package com.person.model.dto;

import com.person.model.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Integer personID;

    private String name;

    private String address;

    private String postCode;

    private Integer age;

    private String job;

    private String email;

    private String phone;

    public PersonDTO(Person person) {
        this.personID = person.getPersonID();
        this.name = person.getName();
        this.address = person.getAddress();
        this.postCode = person.getPostCode();
        this.age = person.getAge();
        this.job = person.getJob();
        this.email = person.getEmail();
        this.phone = person.getPhone();
    }

}
