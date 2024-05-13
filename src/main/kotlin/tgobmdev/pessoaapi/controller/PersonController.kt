package tgobmdev.pessoaapi.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonDetailsResponse
import tgobmdev.pessoaapi.service.PersonService

@RestController
@RequestMapping(value = ["person"])
class PersonController(
    private val personService: PersonService
) {
    @GetMapping
    fun fetchAllPersons(): List<PersonDetailsResponse> {
        return personService.fetchAllPersons()
    }

    @GetMapping("/{personId}")
    fun fetchPerson(@PathVariable personId: Long): PersonDetailsResponse {
        return personService.fetchPerson(personId)
    }

    @PostMapping
    fun createPerson(@Validated @RequestBody personRequest: PersonRequest) {
        personService.createPerson(personRequest)
    }
}