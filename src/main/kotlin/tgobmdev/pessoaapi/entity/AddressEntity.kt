package tgobmdev.pessoaapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "address")
data class AddressEntity(
    @Id //
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator = "address_seq"
    ) @SequenceGenerator(
        name = "address_seq", sequenceName = "sq_address", allocationSize = 1
    ) val id: Long?,
    val street: String,
    val zipcode: String,
    val streetNumber: String,
    val city: String,
    val state: String,
    val stateShortname: String,
) {
    @OneToMany(mappedBy = "addressEntity")
    val personEntities: MutableList<PersonEntity> = mutableListOf()
}