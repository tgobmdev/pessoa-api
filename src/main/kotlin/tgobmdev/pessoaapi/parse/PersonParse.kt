package tgobmdev.pessoaapi.parse

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.entity.PersonEntity
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse

@Component
class PersonParse {
    fun fromRequest(personRequest: PersonRequest): PersonEntity {
        return PersonEntity(
            personRequest.namePerson, personRequest.dateOfBirth
        )
    }

    fun toResponse(personEntity: PersonEntity): PersonResponse {
        return PersonResponse(
            personEntity.id, personEntity.namePerson, personEntity.dateOfBirth
        )
    }

    fun toResponseList(personEntities: List<PersonEntity>): List<PersonResponse> {
        return personEntities.map(::toResponse)
    }
}