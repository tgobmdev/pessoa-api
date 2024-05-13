package tgobmdev.pessoaapi.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "person")
data class PersonEntity(
    @Id //
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator = "person_seq"
    ) @SequenceGenerator(
        name = "person_seq", sequenceName = "sq_person", allocationSize = 1
    ) val id: Long?,
    val namePerson: String,
    val dateOfBirth: LocalDate,
) {
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL]) //
    @JoinColumn(name = "address_id") //
    lateinit var addressEntity: AddressEntity
}