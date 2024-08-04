package tgobmdev.pessoaapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.response.AddressPeopleResponse
import tgobmdev.pessoaapi.response.AddressResponse
import tgobmdev.pessoaapi.service.AddressService

@RestController
@RequestMapping(value = ["addresses"])
class AddressController(private val addressService: AddressService) {
    @GetMapping
    fun getAllAddresses(): List<AddressResponse> {
        return addressService.getAllAddresses()
    }

    @GetMapping("/{addressId}")
    fun getAddress(@PathVariable addressId: Long): AddressResponse {
        return addressService.getAddress(addressId)
    }

    @GetMapping("/{addressId}/persons")
    fun getAddressInfoWithPeople(@PathVariable addressId: Long): AddressPeopleResponse {
        return addressService.getAddressInfoWithPeople(addressId)
    }
}