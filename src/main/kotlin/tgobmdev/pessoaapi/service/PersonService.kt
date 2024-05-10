package tgobmdev.pessoaapi.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import tgobmdev.pessoaapi.parse.PersonParse
import tgobmdev.pessoaapi.repository.PersonRepository
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse

@Service
class PersonService(
    private val personRepository: PersonRepository, private val personParse: PersonParse
) {
    fun getPersons(): List<PersonResponse> {
        val persons = personRepository.findAll()
        return personParse.toResponseList(persons)
    }

    fun getPersonById(id: Long): PersonResponse {
        val person = personRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Person not Found") }
        return personParse.toResponse(person)
    }

    fun savePerson(personRequest: PersonRequest) {
        val person = personParse.fromRequest(personRequest)
        personRepository.save(person)
    }
}