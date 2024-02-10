package me.shockyng.library.api.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import me.shockyng.library.api.daos.AuthorDAO;
import me.shockyng.library.api.data.dtos.AuthorDTO;
import me.shockyng.library.api.data.mappers.AuthorMapper;
import me.shockyng.library.api.data.models.Author;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class AuthorsService {

    @Inject
    private AuthorDAO dao;

    private final AuthorMapper mapper = AuthorMapper.INSTANCE;

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author authorToSave = mapper.dtoToEntity(authorDTO);
        return mapper.entityToDto(authorToSave);
    }

    public List<AuthorDTO> getAllAuthors() {
        return dao.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        return mapper.entityToDto(dao.findOneById(id));
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = Author.builder()
                .id(id)
                .name(authorDTO.name())
                .build();

        return mapper.entityToDto(dao.save(author));
    }

    public void deleteAuthor(Long id) {
        dao.delete(id);
    }
}
