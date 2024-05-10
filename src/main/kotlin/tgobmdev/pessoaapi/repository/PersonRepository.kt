package tgobmdev.pessoaapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tgobmdev.pessoaapi.entity.PersonEntity

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long>