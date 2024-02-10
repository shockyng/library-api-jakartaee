package me.shockyng.library.api.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.dtos.BookWithAuthorsDTO;
import me.shockyng.library.api.services.BooksService;

import java.util.List;
import java.util.UUID;

@Path("/v1/books")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BooksResource {

    @Inject
    private BooksService service;

    @POST
    public BookDTO createBook(BookDTO bookDTO) {
        return service.createBook(bookDTO);
    }

    @GET
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @GET
    @Path("/authors")
    public List<BookWithAuthorsDTO> getAllBooksWithAuthors() {
        return service.getAllBooksWithAuthors();
    }

    @GET
    @Path("/{id}")
    public BookDTO getBookById(@PathParam("id") Long id) {
        return service.getBookById(id);
    }

    @PUT
    @Path("/{id}")
    public BookDTO updateBook(@PathParam("id") Long id, BookDTO bookDTO) {
        return service.updateBook(id, bookDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") Long id) {
        service.deleteBook(id);
    }
}
