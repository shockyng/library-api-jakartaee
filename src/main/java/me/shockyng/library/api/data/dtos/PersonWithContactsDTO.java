package me.shockyng.library.api.data.dtos;

import java.util.Date;
import java.util.List;

public record PersonWithContactsDTO(
        Long id,
        String firstName,
        String middleName,
        String lastName,
        Date birthDate,
        String username,
        List<ContactWithTypeDTO> contacts
) { }
