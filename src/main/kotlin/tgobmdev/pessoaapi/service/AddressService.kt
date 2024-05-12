package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.api.zipcode.client.ZipcodeClient
import tgobmdev.pessoaapi.component.AddressComponent
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.AddressMapper
import tgobmdev.pessoaapi.message.MessageEnum
import tgobmdev.pessoaapi.request.AddressRequest
import tgobmdev.pessoaapi.response.AddressDetailsResponse
import tgobmdev.pessoaapi.response.AddressInfoWithPeopleResponse

@Service
class AddressService(
    private val zipCodeClient: ZipcodeClient,
    private val addressMapper: AddressMapper,
    private val addressComponent: AddressComponent
) {
    private fun loadAddressEntityById(addressId: Long): AddressEntity {
        return addressComponent.findAddressById(addressId)
            .orElseThrow { throw ApiException.of(404, MessageEnum.CODE_2) }
    }

    fun fetchAllAddresses(): List<AddressDetailsResponse> {
        val addressEntities = addressComponent.findAllAddresses()
        return addressMapper.toAddressDetailsResponseList(addressEntities)
    }

    fun fetchAddress(addressId: Long): AddressDetailsResponse {
        val addressEntity = loadAddressEntityById(addressId)
        return addressMapper.toAddressDetailsResponse(addressEntity)
    }

    @Transactional(readOnly = true)
    fun fetchAllPersonsByAddressId(addressId: Long): AddressInfoWithPeopleResponse {
        val addressEntity = loadAddressEntityById(addressId)
        return addressMapper.toAddressInfoWithPeopleResponse(addressEntity)
    }

    @Transactional
    fun createAddress(addressRequest: AddressRequest) {
        val addressInfo = zipCodeClient.fetchAddressInfoByZipcode(addressRequest.zipcode)
        val addressEntity = addressMapper.toEntity(addressInfo, addressRequest)
        addressComponent.saveAddress(addressEntity)
    }
}