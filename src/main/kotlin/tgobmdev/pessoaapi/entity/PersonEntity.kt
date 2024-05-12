package tgobmdev.pessoaapi.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "person")
data class PersonEntity(
    @Id @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator = "person_seq"
    ) @SequenceGenerator(
        name = "person_seq", sequenceName = "sq_person", allocationSize = 1
    ) val id: Long?,
    val namePerson: String,
    val dateOfBirth: LocalDate,

    ) {
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "person_address",
        joinColumns = [JoinColumn(name = "person_id")],
        inverseJoinColumns = [JoinColumn(name = "address_id")]
    )
    val addressEntities: MutableList<AddressEntity> = mutableListOf()
}