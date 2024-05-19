package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.component.AddressZipcodeComponent
import tgobmdev.pessoaapi.component.PersonComponent
import tgobmdev.pessoaapi.entity.PersonEntity
import tgobmdev.pessoaapi.enumeration.ErrorEnum
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.PersonMapper
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonResponse

@Service
class PersonService(
    private val personMapper: PersonMapper,
    private val personComponent: PersonComponent,
    private val addressZipcodeComponent: AddressZipcodeComponent
) {
    private fun loadPersonEntityById(personId: Long): PersonEntity {
        return personComponent.findPersonById(personId)
            .orElseThrow { throw ApiException.of(404, ErrorEnum.CODE_1) }
    }

    fun fetchAllPersons(): List<PersonResponse> {
        val personEntities = personComponent.findAllPersons()
        return personMapper.toPersonResponseList(personEntities)
    }

    fun fetchPerson(personId: Long): PersonResponse {
        val personEntity = loadPersonEntityById(personId)
        return personMapper.toPersonResponse(personEntity)
    }

    @Transactional
    fun createPerson(personRequest: PersonRequest) {
        val personEntity: PersonEntity = personMapper.toEntity(personRequest)
        val addressRequest = personRequest.addressRequest

        val addressEntity = addressZipcodeComponent //
            .getOrCreateAddressFromExternalApi(addressRequest)

        personEntity.addressEntity = addressEntity
        personComponent.savePerson(personEntity)
    }
}