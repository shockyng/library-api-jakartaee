package me.shockyng.library.api.daos;

import jakarta.ejb.Stateless;
import me.shockyng.library.api.data.models.Author;
import me.shockyng.library.api.data.models.Person;

@Stateless
public class PeopleDAO extends BaseDAO<Person, Long> {

    public PeopleDAO() {
        super(Person.class);
    }

}
