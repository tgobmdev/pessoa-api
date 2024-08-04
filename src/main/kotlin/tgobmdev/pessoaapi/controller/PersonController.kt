package tgobmdev.pessoaapi.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse
import tgobmdev.pessoaapi.service.PersonService

@RestController
@RequestMapping(value = ["persons"])
class PersonController(
    private val personService: PersonService
) {
    @GetMapping
    fun fetchAllPersons(): List<PersonResponse> {
        return personService.fetchAllPersons()
    }

    @GetMapping("/{personId}")
    fun fetchPerson(@PathVariable personId: Long): PersonResponse {
        return personService.fetchPerson(personId)
    }

    @PostMapping
    fun createPerson(@Validated @RequestBody personRequest: PersonRequest) {
        personService.createPerson(personRequest)
    }
}