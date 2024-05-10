package tgobmdev.pessoaapi.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse
import tgobmdev.pessoaapi.service.PersonService

@RestController
@RequestMapping(value = ["persons"])
class PersonController(
    private val personService: PersonService
) {
    @GetMapping
    fun getPersons(): List<PersonResponse> {
        return personService.getPersons()
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: Long): PersonResponse {
        return personService.getPersonById(id)
    }

    @PostMapping
    fun savePerson(@Validated @RequestBody personRequest: PersonRequest) {
        personService.savePerson(personRequest)
    }
}