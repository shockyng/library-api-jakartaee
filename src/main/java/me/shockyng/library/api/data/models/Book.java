package me.shockyng.library.api.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Table(name = "BOOKS")
public class Book implements Serializable {

    @Id
    @Column(name = "BOOK_ID", updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Book name can not be null or blank")
    @Column(name = "BOOK_NAME")
    private String name;

    @NotNull(message = "Book description can not be null or blank")
    @Column(name = "BOOK_DESCRIPTION")
    private String description;

    @Column(name = "BOOK_RELEASE_YEAR")
    private Integer releaseYear;

    @Positive(message = "Book number of pages can not be null nor less then zero")
    @Column(name = "BOOK_NUMBER_OF_PAGES")
    private Integer numberOfPages;

    @ManyToMany
    @JoinTable(
            name = "BOOKS_AUTHORS",
            joinColumns = {@JoinColumn(name = "BOOK_FK")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHOR_FK")}
    )
    private List<Author> authors;

}
