package me.shockyng.library.api.daos;

import jakarta.ejb.Stateless;
import me.shockyng.library.api.data.models.Author;

import java.util.UUID;

@Stateless
public class AuthorDAO extends BaseDAO<Author, Long> {

    public AuthorDAO() {
        super(Author.class);
    }

}
