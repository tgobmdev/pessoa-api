package tgobmdev.pessoaapi.component

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.api.zipcode.component.ZipcodeComponent
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.enumeration.ErrorEnum
import tgobmdev.pessoaapi.exception.ApiException
import tgobmdev.pessoaapi.mapper.AddressMapper
import tgobmdev.pessoaapi.request.AddressRequest
import tgobmdev.pessoaapi.response.AddressPeopleResponse
import tgobmdev.pessoaapi.response.AddressResponse

@Component
class AddressZipcodeComponent(
    private val addressMapper: AddressMapper,
    private val addressComponent: AddressComponent,
    private val zipcodeComponent: ZipcodeComponent
) {
    private fun loadAddressEntityById(addressId: Long): AddressEntity {
        return addressComponent.findAddressById(addressId)
            .orElseThrow { throw ApiException.of(404, ErrorEnum.CODE_2) }
    }

    fun getOrCreateAddressFromExternalApi(addressRequest: AddressRequest): AddressEntity {
        val addressEntity = addressComponent.findByZipcodeAndStreetNumber(
            addressRequest.zipcode, addressRequest.streetNumber
        ).orElseGet { createAddress(addressRequest).second }
        return addressEntity
    }

    fun getAllAddresses(): List<AddressResponse> {
        val addressEntities = addressComponent.findAllAddresses()
        return addressMapper.toAddressResponseList(addressEntities)
    }

    fun getAddress(addressId: Long): AddressResponse {
        val addressEntity = loadAddressEntityById(addressId)
        return addressMapper.toAddressResponse(addressEntity)
    }

    fun getAddressInfoWithPeople(addressId: Long): AddressPeopleResponse {
        val addressEntity = loadAddressEntityById(addressId)
        return addressMapper.toAddressPeopleResponse(addressEntity)
    }

    fun createAddress(addressRequest: AddressRequest): Pair<Unit, AddressEntity> {
        val addressInfo = zipcodeComponent.fetchAddressInfoByZipcode(addressRequest.zipcode)
        val addressEntity = addressMapper.toEntity(addressInfo, addressRequest)
        addressComponent.saveAddress(addressEntity)
        return Pair(Unit, addressEntity)
    }
}