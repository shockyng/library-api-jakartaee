package me.shockyng.library.api.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import me.shockyng.library.api.daos.BooksDAO;
import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.dtos.BookWithAuthorsDTO;
import me.shockyng.library.api.data.mappers.BookMapper;
import me.shockyng.library.api.data.mappers.PeopleMapper;
import me.shockyng.library.api.data.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class BooksService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksService.class);
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Inject
    private BooksDAO dao;


    public BookDTO createBook(@Valid BookDTO bookDTO) {
        LOGGER.info("Parse BookDTO to Book");
        Book bookToSave = bookMapper.dtoToEntity(bookDTO);
        Book savedBook = dao.save(bookToSave);
        LOGGER.info("Parse Book to BookDTO");
        return bookMapper.entityToDto(savedBook);
    }

    public List<BookDTO> getAllBooks() {
        return dao.findAll().stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book foundBook = dao.findOneById(id);
        LOGGER.info("Parse BookDTO to Book");
        return bookMapper.entityToDto(foundBook);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        LOGGER.info("Create entity based on the received dto");
        Book book = Book.builder()
                .id(id)
                .name(bookDTO.name())
                .description(bookDTO.description())
                .description(bookDTO.description())
                .description(bookDTO.description())
                .build();

        Book savedBook = dao.save(book);

        LOGGER.info("Parse saved book to dto and return it");
        return bookMapper.entityToDto(savedBook);
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }

    public List<BookWithAuthorsDTO> getAllBooksWithAuthors() {
        return dao.findAllBooksWithAuthors().stream()
                .map(bookMapper::entityToDtoWithAuthors)
                .collect(Collectors.toList());
    }
}
