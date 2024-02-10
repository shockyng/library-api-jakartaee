package me.shockyng.library.api.data.dtos;

import java.util.List;
import java.util.UUID;

public record AuthorWithBooksDTO(
        Long id,
        String name,
        List<BookDTO> books
) {
}
