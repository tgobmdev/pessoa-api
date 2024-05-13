package tgobmdev.pessoaapi.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import tgobmdev.pessoaapi.entity.PersonEntity
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonDetailsResponse

@Mapper(componentModel = "spring")
interface PersonMapper {

    @Mapping(target = "addressEntity", ignore = true)
    fun toEntity(personRequest: PersonRequest): PersonEntity

    fun toPersonDetailsResponse(personEntity: PersonEntity): PersonDetailsResponse

    fun toPersonDetailsResponseList(personEntities: List<PersonEntity>): List<PersonDetailsResponse>
}