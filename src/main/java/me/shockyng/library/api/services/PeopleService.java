package me.shockyng.library.api.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import me.shockyng.library.api.daos.PeopleDAO;
import me.shockyng.library.api.data.dtos.PersonDTO;
import me.shockyng.library.api.data.dtos.PersonWithContactsDTO;
import me.shockyng.library.api.data.mappers.PeopleMapper;
import me.shockyng.library.api.data.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);
    private final PeopleMapper mapper = PeopleMapper.INSTANCE;

    @Inject
    private PeopleDAO dao;


    public PersonDTO createPerson(PersonDTO personDTO) {
        LOGGER.info("Parse PersonDTO to Person");
        Person personToSave = mapper.dtoToEntity(personDTO);
        return mapper.entityToDto(dao.save(personToSave));
    }

    public List<PersonDTO> getAllPeople() {
        LOGGER.info("Fetch all people and parse to dto");
        return dao.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
    }

    public List<PersonWithContactsDTO> getAllPeopleWithContacts() {
        return dao.findAll().stream().map(mapper::entityToDtoWithContacts).collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        return mapper.entityToDto(dao.findOneById(id));
    }

    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        LOGGER.info("Create entity based on the received dto");
        Person person = Person.builder()
                .id(id)
                .firstName(personDTO.firstName())
                .middleName(personDTO.middleName())
                .lastName(personDTO.lastName())
                .birthDate(personDTO.birthDate())
                .username(personDTO.username())
                .build();

        Person savedPerson = dao.save(person);

        LOGGER.info("Parse saved person to dto and return it");
        return mapper.entityToDto(savedPerson);
    }

    public void deletePerson(Long id) {
        dao.delete(id);
    }
}

