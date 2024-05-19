package tgobmdev.pessoaapi.response

data class AddressResponse(
    val id: Long,
    val street: String,
    val zipcode: String,
    val streetNumber: String,
    val city: String,
    val state: String,
    val stateShortname: String
)