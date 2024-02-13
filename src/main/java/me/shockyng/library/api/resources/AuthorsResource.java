package me.shockyng.library.api.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.library.api.data.dtos.AuthorDTO;
import me.shockyng.library.api.services.AuthorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/v1/authors")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class AuthorsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorsResource.class);

    @Inject
    private AuthorsService service;

    @POST
    public AuthorDTO createAuthor(AuthorDTO authorDto) {
        LOGGER.info("Create author request received with payload: {}", authorDto);
        return service.createAuthor(authorDto);
    }

    @GET
    public List<AuthorDTO> getAllAuthors() {
        LOGGER.info("Get all authors request received");
        return service.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    public AuthorDTO getAuthorById(@PathParam("id") Long id) {
        LOGGER.info("Get author request received with id: {}", id);
        return service.getAuthorById(id);
    }

    @PUT
    @Path("/{id}")
    public AuthorDTO updateAuthor(@PathParam("id") Long id, AuthorDTO authorDTO) {
        LOGGER.info("Update author request received with id: {} and payload: {}", id, authorDTO);
        return service.updateAuthor(id, authorDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") Long id) {
        LOGGER.info("Delete author request received with id: {}", id);
        service.deleteAuthor(id);
    }
}
