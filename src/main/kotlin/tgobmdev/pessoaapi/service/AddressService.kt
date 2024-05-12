package tgobmdev.pessoaapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tgobmdev.pessoaapi.api.zipcode.client.ZipcodeClient
import tgobmdev.pessoaapi.component.AddressComponent
import tgobmdev.pessoaapi.mapper.AddressMapper
import tgobmdev.pessoaapi.request.AddressRequest

@Service
class AddressService(
    private val zipCodeClient: ZipcodeClient,
    private val addressMapper: AddressMapper,
    private val addressComponent: AddressComponent

) {
    @Transactional
    fun createAddress(addressRequest: AddressRequest) {
        val addressInfo = zipCodeClient.fetchAddressInfoByZipcode(addressRequest.zipcode)
        val addressEntity = addressMapper.toEntity(addressInfo, addressRequest)
        addressComponent.saveAddress(addressEntity)
    }
}