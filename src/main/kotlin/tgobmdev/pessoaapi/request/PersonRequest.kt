package tgobmdev.pessoaapi.request

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class PersonRequest(
    val id: Long?,
    val namePerson: String,
    @field:DateTimeFormat(pattern = "yyyy-MM-dd") val dateOfBirth: LocalDate,
)