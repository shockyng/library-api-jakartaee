package me.shockyng.library.api.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import me.shockyng.library.api.daos.BooksDAO;
import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.dtos.BookWithAuthorsDTO;
import me.shockyng.library.api.data.mappers.BookMapper;
import me.shockyng.library.api.data.models.Book;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class BooksService {

    @Inject
    private BooksDAO dao;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookDTO createBook(@Valid BookDTO bookDTO) {
        Book bookToSave = bookMapper.dtoToEntity(bookDTO);
        return bookMapper.entityToDto(dao.save(bookToSave));
    }

    public List<BookDTO> getAllBooks() {
        return dao.findAll().stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookMapper.entityToDto(dao.findOneById(id));
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = Book.builder()
                .id(id)
                .name(bookDTO.name())
                .description(bookDTO.description())
                .description(bookDTO.description())
                .description(bookDTO.description())
                .build();

        return bookMapper.entityToDto(dao.save(book));
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
