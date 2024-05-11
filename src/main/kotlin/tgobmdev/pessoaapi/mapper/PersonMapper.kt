package tgobmdev.pessoaapi.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import tgobmdev.pessoaapi.entity.PersonEntity
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse

@Mapper(componentModel = "spring")
interface PersonMapper {

    @Mapping(target = "addressEntities", ignore = true)
    fun toEntity(personRequest: PersonRequest): PersonEntity

    fun toResponse(personEntity: PersonEntity): PersonResponse

    fun toResponseList(personEntities: List<PersonEntity>): List<PersonResponse>
}