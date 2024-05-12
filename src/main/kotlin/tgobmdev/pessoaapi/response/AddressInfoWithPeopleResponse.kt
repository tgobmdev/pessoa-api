package tgobmdev.pessoaapi.response

data class AddressInfoWithPeopleResponse(
    val addressDetailsResponse: AddressDetailsResponse,
    val personDetailsResponseList: List<PersonDetailsResponse>
)