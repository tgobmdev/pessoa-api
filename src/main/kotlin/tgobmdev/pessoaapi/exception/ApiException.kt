package tgobmdev.pessoaapi.exception

import tgobmdev.pessoaapi.enumeration.ErrorEnum
import tgobmdev.pessoaapi.message.MessageManager

data class ApiException(val status: Int, val codeMessage: Int, override val message: String) :
    RuntimeException(message) {

    constructor(status: Int, errorEnum: ErrorEnum) : this(
        status, errorEnum.code, MessageManager.getMessage(errorEnum.message)
    )

    companion object {
        fun of(status: Int, errorEnum: ErrorEnum): ApiException {
            return ApiException(status, errorEnum)
        }
    }
}