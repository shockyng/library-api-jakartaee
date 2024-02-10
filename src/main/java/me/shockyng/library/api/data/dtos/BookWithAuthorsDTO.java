package me.shockyng.library.api.data.dtos;

import java.util.List;
import java.util.UUID;

public record BookWithAuthorsDTO(
        Long id,
        String name,
        String description,
        Integer releaseYear,
        Integer numberOfPages,
        List<AuthorDTO> authors
) { }
