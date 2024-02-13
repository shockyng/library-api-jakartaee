package me.shockyng.library.api.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTACTS")
public class Contact {

    @Id
    @Column(name = "CONTACT_ID", updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTACT_CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "PERSON_FK")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "CONTACT_TYPE_FK")
    private ContactType contactType;

}
