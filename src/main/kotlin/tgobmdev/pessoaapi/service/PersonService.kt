package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.component.AddressComponent
import tgobmdev.pessoaapi.component.PersonComponent
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.PersonMapper
import tgobmdev.pessoaapi.message.MessageEnum
import tgobmdev.pessoaapi.request.PersonRequest
import tgobmdev.pessoaapi.response.PersonDetailsResponse

@Service
class PersonService(
    private val personMapper: PersonMapper,
    private val personComponent: PersonComponent,
    private val addressComponent: AddressComponent
) {
    fun fetchAllPersons(): List<PersonDetailsResponse> {
        val personEntities = personComponent.findAllPersons()
        return personMapper.toPersonDetailsResponseList(personEntities)
    }

    fun fetchPerson(personId: Long): PersonDetailsResponse {
        val personEntity = personComponent.findPersonById(personId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_1) }
        return personMapper.toPersonDetailsResponse(personEntity)
    }

    @Transactional
    fun createPerson(personRequest: PersonRequest) {
        val personEntity = personMapper.toEntity(personRequest)
        personComponent.savePerson(personEntity)
    }

    @Transactional
    fun linkPersonWithAddress(personId: Long, addressId: Long) {
        val personEntity = personComponent.findPersonById(personId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_1) }

        val addressEntity = addressComponent.findAddressById(addressId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_2) }

        personEntity.addressEntities.add(addressEntity)
        personComponent.savePerson(personEntity)
    }
}