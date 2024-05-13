package tgobmdev.pessoaapi.api.zipcode.exception

import tgobmdev.pessoaapi.enumeration.ErrorEnum
import tgobmdev.pessoaapi.message.MessageManager

data class ExternalApiException(
    val status: Int, val codeMessage: Int, override val message: String
) : RuntimeException(message) {

    constructor(status: Int, errorEnum: ErrorEnum, vararg args: Any) : this(
        status, errorEnum.code, MessageManager.getMessage(errorEnum.message, args)
    )

    companion object {
        fun of(status: Int, codeMessage: Int, message: String): ExternalApiException {
            return ExternalApiException(status, codeMessage, message)
        }

        fun of(status: Int, errorEnum: ErrorEnum, vararg args: Any): ExternalApiException {
            return ExternalApiException(status, errorEnum, args)
        }
    }
}