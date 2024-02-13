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
@Table(name = "CONTACT_TYPES")
public class ContactType {

    @Id
    @Column(name = "CONTACT_TYPE_ID", updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTACT_TYPE_NAME")
    private String name;

    @OneToMany(mappedBy = "contactType")
    private List<Contact> contacts;

}
