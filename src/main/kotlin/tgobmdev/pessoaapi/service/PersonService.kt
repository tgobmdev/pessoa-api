package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import tgobmdev.pessoaapi.component.PersonComponent
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.PersonMapper
import tgobmdev.pessoaapi.message.MessageEnum
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse

@Service
class PersonService(
    private val personComponent: PersonComponent, private val personMapper: PersonMapper
) {

    fun fetchAllPersons(): List<PersonResponse> {
        val persons = personComponent.findAllPersons()
        return personMapper.toResponseList(persons)
    }

    fun fetchPerson(id: Long): PersonResponse {
        val person = personComponent.findPersonById(id)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_1) }
        return personMapper.toResponse(person)
    }

    fun createPerson(personRequest: PersonRequest) {
        val personEntity = personMapper.toEntity(personRequest)
        personComponent.savePerson(personEntity)
    }
}