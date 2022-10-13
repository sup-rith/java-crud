package com.person.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "PERSON_ID")
    private Integer personID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POST_CODE")
    private String postCode;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "JOB")
    private String job;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;
}
