package me.shockyng.library.api.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.library.api.data.dtos.PersonDTO;
import me.shockyng.library.api.data.dtos.PersonWithContactsDTO;
import me.shockyng.library.api.services.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/v1/people")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PeopleResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleResource.class);

    @Inject
    private PeopleService service;

    @POST
    public PersonDTO createPerson(PersonDTO personDto) {
        LOGGER.info("Create person request received with payload {}: ", personDto);
        return service.createPerson(personDto);
    }

    @GET
    public List<PersonDTO> getAllPeople() {
        LOGGER.info("Get all people request received");
        return service.getAllPeople();
    }

    @GET
    @Path("/contacts")
    public List<PersonWithContactsDTO> getAllPeopleWithContacts() {
        LOGGER.info("Get all people with contacts request received");
        return service.getAllPeopleWithContacts();
    }

    @GET
    @Path("/{id}")
    public PersonDTO getPersonById(@PathParam("id") Long id) {
        LOGGER.info("Get person by id request received with given id: {}", id);
        return service.getPersonById(id);
    }

    @PUT
    @Path("/{id}")
    public PersonDTO updatePerson(@PathParam("id") Long id, PersonDTO personDTO) {
        LOGGER.info("Update person request received with given id: {} and payload: {}", id, personDTO);
        return service.updatePerson(id, personDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deletePerson(@PathParam("id") Long id) {
        LOGGER.info("Delete person request received with given id: {}", id);
        service.deletePerson(id);
    }
}
