package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.api.zipcode.client.ZipcodeClient
import tgobmdev.pessoaapi.component.AddressComponent
import tgobmdev.pessoaapi.component.PersonComponent
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.AddressMapper
import tgobmdev.pessoaapi.message.MessageEnum
import tgobmdev.pessoaapi.request.AddressRequest

@Service
class AddressService(
    private val zipCodeClient: ZipcodeClient,
    private val addressMapper: AddressMapper,
    private val addressComponent: AddressComponent,
    private val personComponent: PersonComponent

) {

    fun createAddress(addressRequest: AddressRequest) {
        val addressInfo = zipCodeClient.fetchAddressInfoByZipcode(addressRequest.zipcode)
        val addressEntity = addressMapper.toEntity(addressInfo, addressRequest)
        addressComponent.saveAddress(addressEntity)
    }

    @Transactional
    fun linkAddressToPerson(addressId: Long, personId: Long) {
        val addressEntity = addressComponent.findAddressById(addressId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_2) }

        val personEntity = personComponent.findPersonById(personId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_1) }

        addressEntity.personEntity = personEntity
        addressComponent.saveAddress(addressEntity)
    }
}