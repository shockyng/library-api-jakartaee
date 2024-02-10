package me.shockyng.library.api.data.mappers;

import me.shockyng.library.api.data.dtos.AuthorDTO;
import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.models.Author;
import me.shockyng.library.api.data.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "name", source = "name")
    Author dtoToEntity(AuthorDTO authorDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "name", source = "name")
    AuthorDTO entityToDto(Author author);
}
