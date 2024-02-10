package me.shockyng.library.api.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTHORS")
public class Author implements Serializable {

    @Id
    @Column(name = "AUTHOR_ID", updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AUTHOR_NAME")
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
