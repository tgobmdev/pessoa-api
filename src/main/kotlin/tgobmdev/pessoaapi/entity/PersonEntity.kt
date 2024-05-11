package tgobmdev.pessoaapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "PERSON")
data class PersonEntity(
    @Id @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ"
    ) @SequenceGenerator(
        name = "PERSON_SEQ", sequenceName = "SQ_PERSON", allocationSize = 1
    ) val id: Long?,
    val namePerson: String,
    val dateOfBirth: LocalDate,
    @OneToMany(mappedBy = "personEntity") val addressEntities: List<AddressEntity> = mutableListOf()
)