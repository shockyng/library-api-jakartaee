package me.shockyng.library.api.daos;

import jakarta.ejb.Stateless;
import me.shockyng.library.api.data.models.Book;

import java.util.List;
import java.util.UUID;

@Stateless
public class BooksDAO extends BaseDAO<Book, Long> {

    public BooksDAO() {
        super(Book.class);
    }

    public List<Book> findAllBooksWithAuthors() {
        return this.entityManager
                .createQuery("SELECT b FROM Book b JOIN FETCH b.authors", Book.class)
                .getResultList();
    }
}
