package tgobmdev.pessoaapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "address")
class AddressEntity(
    val publicPlace: String,
    val cep: String,
    val addressNumber: String,
    val city: String,
    val state: String,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "person_id") val personEntity: PersonEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}