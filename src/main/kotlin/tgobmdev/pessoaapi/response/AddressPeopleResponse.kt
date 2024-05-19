package tgobmdev.pessoaapi.response

data class AddressPeopleResponse(
    val address: AddressResponse, val persons: List<PersonResponse>
)