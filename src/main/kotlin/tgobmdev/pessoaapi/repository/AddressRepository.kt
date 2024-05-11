package tgobmdev.pessoaapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tgobmdev.pessoaapi.entity.AddressEntity

@Repository
interface AddressRepository : JpaRepository<AddressEntity, Long>