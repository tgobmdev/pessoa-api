package tgobmdev.pessoaapi.exception

import tgobmdev.pessoaapi.message.MessageManager
import tgobmdev.pessoaapi.message.MessageEnum

class ApiException(val status: Int, val codeMessage: Int, override val message: String) :
    RuntimeException(message) {

    constructor(status: Int, messageEnum: MessageEnum) : this(
        status, messageEnum.code, MessageManager.getMessage(messageEnum.message)
    )

    companion object {
        fun of(status: Int, messageEnum: MessageEnum): ApiException {
            return ApiException(status, messageEnum)
        }
    }
}