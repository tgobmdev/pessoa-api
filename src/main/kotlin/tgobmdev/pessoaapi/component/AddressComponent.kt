package tgobmdev.pessoaapi.component

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.repository.AddressRepository
import java.util.*

@Component
class AddressComponent(private val addressRepository: AddressRepository) {

    fun findAllAddresses(): List<AddressEntity> {
        return addressRepository.findAll()
    }

    fun findAddressById(id: Long): Optional<AddressEntity> {
        return addressRepository.findById(id)
    }

    fun saveAddress(addressEntity: AddressEntity) {
        addressRepository.save(addressEntity)
    }
}