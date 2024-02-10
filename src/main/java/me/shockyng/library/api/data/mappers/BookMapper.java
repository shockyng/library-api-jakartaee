package me.shockyng.library.api.data.mappers;

import me.shockyng.library.api.data.dtos.BookDTO;
import me.shockyng.library.api.data.dtos.BookWithAuthorsDTO;
import me.shockyng.library.api.data.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "numberOfPages", source = "numberOfPages")
    @Mapping(target = "releaseYear", source = "releaseYear")
    Book dtoToEntity(BookDTO bookDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "numberOfPages", source = "numberOfPages")
    @Mapping(target = "releaseYear", source = "releaseYear")
    BookDTO entityToDto(Book book);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "numberOfPages", source = "numberOfPages")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "authors")
    BookWithAuthorsDTO entityToDtoWithAuthors(Book book);
}
