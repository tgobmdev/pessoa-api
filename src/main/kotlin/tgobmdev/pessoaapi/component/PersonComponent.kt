package tgobmdev.pessoaapi.component

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.entity.PersonEntity
import tgobmdev.pessoaapi.repository.PersonRepository
import java.util.*

@Component
class PersonComponent(private val personRepository: PersonRepository) {

    fun findAllPersons(): List<PersonEntity> {
        return personRepository.findAll()
    }

    fun findPersonById(id: Long): Optional<PersonEntity> {
        return personRepository.findById(id)
    }

    fun savePerson(personEntity: PersonEntity) {
        personRepository.save(personEntity)
    }
}