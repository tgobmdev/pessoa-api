package tgobmdev.pessoaapi.request

data class AddressRequest(
    val publicPlace: String,
    val cep: String,
    val addressNumber: String,
    val city: String,
    val state: String
)