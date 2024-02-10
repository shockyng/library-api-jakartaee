package me.shockyng.library.api.data.dtos;

import java.util.UUID;

public record BookDTO(
        Long id,
        String name,
        String description,
        Integer releaseYear,
        Integer numberOfPages
) {
}
