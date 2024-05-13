package tgobmdev.pessoaapi.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import tgobmdev.pessoaapi.api.zipcode.exception.ExternalApiException

@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(ApiException::class)
    fun handleApiException(ex: ApiException): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(
            status = ex.status, codeMessage = ex.codeMessage, message = ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.valueOf(errorMessage.status))
    }

    @ExceptionHandler(ExternalApiException::class)
    fun handleExternalApiException(ex: ExternalApiException): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(
            status = ex.status, codeMessage = ex.codeMessage, message = ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.valueOf(errorMessage.status))
    }
}