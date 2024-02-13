package me.shockyng.library.api.data.mappers;

import me.shockyng.library.api.data.dtos.PersonDTO;
import me.shockyng.library.api.data.dtos.PersonWithContactsDTO;
import me.shockyng.library.api.data.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "username", source = "username")
    Person dtoToEntity(PersonDTO personDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "username", source = "username")
    PersonDTO entityToDto(Person person);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "contacts", source = "contacts")
    PersonWithContactsDTO entityToDtoWithContacts(Person person);
}
