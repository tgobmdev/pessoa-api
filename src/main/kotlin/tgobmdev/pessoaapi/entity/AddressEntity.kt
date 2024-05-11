package tgobmdev.pessoaapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "ADDRESS")
data class AddressEntity(
    @Id @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ"
    ) @SequenceGenerator(
        name = "ADDRESS_SEQ", sequenceName = "SQ_ADDRESS", allocationSize = 1
    ) val id: Long?,
    val street: String,
    val zipcode: String,
    val streetNumber: String,
    val city: String,
    val state: String,
    val stateShortname: String,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "person_id") var personEntity: PersonEntity
)