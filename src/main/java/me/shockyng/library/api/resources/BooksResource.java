package me.shockyng.library.api.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.dtos.BookWithAuthorsDTO;
import me.shockyng.library.api.services.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@Path("/v1/books")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BooksResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksResource.class);

    @Inject
    private BooksService service;

    @POST
    public BookDTO createBook(BookDTO bookDTO) {
        LOGGER.info("Create book request received with payload: {}", bookDTO);
        return service.createBook(bookDTO);
    }

    @GET
    public List<BookDTO> getAllBooks() {
        LOGGER.info("Get all books request received");
        return service.getAllBooks();
    }

    @GET
    @Path("/authors")
    public List<BookWithAuthorsDTO> getAllBooksWithAuthors() {
        LOGGER.info("Get all books with authors request received");
        return service.getAllBooksWithAuthors();
    }

    @GET
    @Path("/{id}")
    public BookDTO getBookById(@PathParam("id") Long id) {
        LOGGER.info("Get book request received with id: {}", id);
        return service.getBookById(id);
    }

    @PUT
    @Path("/{id}")
    public BookDTO updateBook(@PathParam("id") Long id, BookDTO bookDTO) {
        LOGGER.info("Update book request received with id {} and payload: {}", id, bookDTO);
        return service.updateBook(id, bookDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") Long id) {
        LOGGER.info("Delete book request received with id: {}", id);
        service.deleteBook(id);
    }
}
