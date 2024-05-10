package tgobmdev.pessoaapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "person")
class PersonEntity(
    val namePerson: String,
    val dateOfBirth: LocalDate,
    @OneToMany(mappedBy = "personEntity") val addressEntities: List<AddressEntity>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    constructor(namePerson: String, dateOfBirth: LocalDate) : this(
        namePerson, dateOfBirth, listOf()
    )
}