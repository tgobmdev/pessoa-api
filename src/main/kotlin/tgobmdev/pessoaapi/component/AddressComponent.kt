package tgobmdev.pessoaapi.component

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.repository.AddressRepository
import java.util.*

@Component
class AddressComponent(
    private val addressRepository: AddressRepository
) {
    fun findAllAddresses(): List<AddressEntity> {
        return addressRepository.findAll()
    }

    fun findAddressById(addressId: Long): Optional<AddressEntity> {
        return addressRepository.findById(addressId)
    }

    fun findByZipcodeAndStreetNumber(
        zipcode: String, streetNumber: String
    ): Optional<AddressEntity> {
        return addressRepository.findByZipcodeAndStreetNumber(zipcode, streetNumber)
    }

    fun saveAddress(addressEntity: AddressEntity) {
        addressRepository.save(addressEntity)
    }
}