package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.component.AddressZipcodeComponent
import tgobmdev.pessoaapi.response.AddressDetailsResponse
import tgobmdev.pessoaapi.response.AddressInfoWithPeopleResponse

@Service
class AddressService(
    private val addressZipcodeComponent: AddressZipcodeComponent
) {
    fun getAllAddresses(): List<AddressDetailsResponse> {
        return addressZipcodeComponent.getAllAddresses()
    }

    fun getAddress(addressId: Long): AddressDetailsResponse {
        return addressZipcodeComponent.getAddress(addressId)
    }

    @Transactional(readOnly = true)
    fun getAddressInfoWithPeople(addressId: Long): AddressInfoWithPeopleResponse {
        return addressZipcodeComponent.getAddressInfoWithPeople(addressId)
    }
}