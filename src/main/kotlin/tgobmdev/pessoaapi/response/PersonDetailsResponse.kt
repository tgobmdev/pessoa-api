package tgobmdev.pessoaapi.response

import java.time.LocalDate

data class PersonDetailsResponse(
    val id: Long, val namePerson: String, val dateOfBirth: LocalDate
)