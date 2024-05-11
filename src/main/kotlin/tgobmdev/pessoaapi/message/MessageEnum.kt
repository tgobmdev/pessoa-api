package tgobmdev.pessoaapi.message

enum class MessageEnum(val code: Int, val message: String) {
    CODE_1(1, "person.not.found"), //
    CODE_2(2, "address.not.found")
}