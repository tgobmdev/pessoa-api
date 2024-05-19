package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.component.AddressZipcodeComponent
import tgobmdev.pessoaapi.response.AddressPeopleResponse
import tgobmdev.pessoaapi.response.AddressResponse

@Service
class AddressService(
    private val addressZipcodeComponent: AddressZipcodeComponent
) {
    fun getAllAddresses(): List<AddressResponse> {
        return addressZipcodeComponent.getAllAddresses()
    }

    fun getAddress(addressId: Long): AddressResponse {
        return addressZipcodeComponent.getAddress(addressId)
    }

    @Transactional(readOnly = true)
    fun getAddressInfoWithPeople(addressId: Long): AddressPeopleResponse {
        return addressZipcodeComponent.getAddressInfoWithPeople(addressId)
    }
}