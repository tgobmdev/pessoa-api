package tgobmdev.pessoaapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.response.AddressDetailsResponse
import tgobmdev.pessoaapi.response.AddressInfoWithPeopleResponse
import tgobmdev.pessoaapi.service.AddressService

@RestController
@RequestMapping(value = ["address"])
class AddressController(private val addressService: AddressService) {
    @GetMapping
    fun getAllAddresses(): List<AddressDetailsResponse> {
        return addressService.getAllAddresses()
    }

    @GetMapping("/{addressId}")
    fun getAddress(@PathVariable addressId: Long): AddressDetailsResponse {
        return addressService.getAddress(addressId)
    }

    @GetMapping("/{addressId}/persons")
    fun getAddressInfoWithPeople(@PathVariable addressId: Long): AddressInfoWithPeopleResponse {
        return addressService.getAddressInfoWithPeople(addressId)
    }
}