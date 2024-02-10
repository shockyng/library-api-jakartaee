package me.shockyng.library.api.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.library.api.data.dtos.AuthorDTO;
import me.shockyng.library.api.services.AuthorsService;

import java.util.List;
import java.util.UUID;

@Path("/v1/authors")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class AuthorsResource {

    @Inject
    private AuthorsService service;

    @POST
    public AuthorDTO createAuthor(AuthorDTO authorDto) {
        return service.createAuthor(authorDto);
    }

    @GET
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    public AuthorDTO getAuthorById(@PathParam("id") Long id) {
        return service.getAuthorById(id);
    }

    @PUT
    @Path("/{id}")
    public AuthorDTO updateAuthor(@PathParam("id") Long id, AuthorDTO bookDTO) {
        return service.updateAuthor(id, bookDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") Long id) {
        service.deleteAuthor(id);
    }
}
