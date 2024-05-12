package tgobmdev.pessoaapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.request.AddressRequest
import tgobmdev.pessoaapi.response.AddressDetailsResponse
import tgobmdev.pessoaapi.response.AddressInfoWithPeopleResponse
import tgobmdev.pessoaapi.service.AddressService

@RestController
@RequestMapping(value = ["address"])
class AddressController(private val addressService: AddressService) {

    @GetMapping
    fun fetchAllAddresses(): List<AddressDetailsResponse> {
        return addressService.fetchAllAddresses()
    }

    @GetMapping("/{addressId}")
    fun fetchAddress(@PathVariable addressId: Long): AddressDetailsResponse {
        return addressService.fetchAddress(addressId)
    }

    @GetMapping("/{addressId}/persons")
    fun fetchAllPersonsByAddressId(@PathVariable addressId: Long): AddressInfoWithPeopleResponse {
        return addressService.fetchAllPersonsByAddressId(addressId)
    }

    @PostMapping
    fun createAddress(@RequestBody addressRequest: AddressRequest) {
        addressService.createAddress(addressRequest)
    }
}