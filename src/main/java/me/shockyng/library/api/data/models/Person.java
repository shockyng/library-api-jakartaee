package me.shockyng.library.api.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PEOPLE")
public class Person {

    @Id
    @Column(name = "PERSON_ID", updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PERSON_FIRST_NAME")
    private String firstName;

    @Column(name = "PERSON_MIDDLE_NAME")
    private String middleName;

    @Column(name = "PERSON_LAST_NAME")
    private String lastName;

    @Column(name = "PERSON_BIRTH_DATE")
    private Date birthDate;

    @Column(name = "PERSON_USERNAME")
    private String username;

    @OneToMany(mappedBy = "person")
    private List<Contact> contacts;

}
