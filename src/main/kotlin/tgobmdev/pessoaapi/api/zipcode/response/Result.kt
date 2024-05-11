package tgobmdev.pessoaapi.api.zipcode.response

data class Result(
    val street: String,
    val complement: String,
    val district: String,
    val city: String,
    val state: String,
    val stateShortname: String,
    val zipcode: String,
)