package tgobmdev.pessoaapi.enumeration

enum class ErrorEnum(val code: Int, val message: String) {

    INTEGRATION_ERROR(1, "integration.error"),

    CODE_1(1, "person.not.found"), //
    CODE_2(2, "address.not.found")
}