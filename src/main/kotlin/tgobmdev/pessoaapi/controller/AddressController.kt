package tgobmdev.pessoaapi.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tgobmdev.pessoaapi.request.AddressRequest
import tgobmdev.pessoaapi.service.AddressService

@RestController
@RequestMapping(value = ["address"])
class AddressController(private val addressService: AddressService) {

    @PostMapping
    fun createAddress(@RequestBody addressRequest: AddressRequest) {
        addressService.createAddress(addressRequest)
    }
}