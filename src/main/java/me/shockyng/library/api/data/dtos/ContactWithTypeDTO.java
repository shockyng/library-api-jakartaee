package me.shockyng.library.api.data.dtos;

public record ContactWithTypeDTO(
        Long id,
        String content,
        ContactTypeDTO type
) {
}
