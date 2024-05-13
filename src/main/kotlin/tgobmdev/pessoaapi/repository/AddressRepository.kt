package tgobmdev.pessoaapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tgobmdev.pessoaapi.entity.AddressEntity
import java.util.*

@Repository
interface AddressRepository : JpaRepository<AddressEntity, Long> {
    fun findByZipcodeAndStreetNumber(zipcode: String, streetNumber: String): Optional<AddressEntity>
}