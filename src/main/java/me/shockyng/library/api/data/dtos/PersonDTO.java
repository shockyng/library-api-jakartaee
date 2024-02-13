package me.shockyng.library.api.data.dtos;

import java.util.Date;

public record PersonDTO(
        Long id,
        String firstName,
        String middleName,
        String lastName,
        Date birthDate,
        String username
) { }
