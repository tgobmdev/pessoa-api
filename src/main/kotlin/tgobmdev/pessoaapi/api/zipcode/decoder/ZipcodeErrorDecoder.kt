package tgobmdev.pessoaapi.api.zipcode.decoder

import com.google.gson.JsonParser
import feign.Response
import feign.codec.ErrorDecoder
import tgobmdev.pessoaapi.api.zipcode.enumeration.ApiMethodEnum
import tgobmdev.pessoaapi.api.zipcode.exception.ExternalApiException
import tgobmdev.pessoaapi.enumeration.ErrorEnum
import java.io.BufferedReader

class ZipcodeErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String?, response: Response?): Exception {
        val apiMethodEnum = ApiMethodEnum.entries.find { it.method == methodKey }

        return when (apiMethodEnum) {
            ApiMethodEnum.FETCH_ADDRESS_INFO_BY_ZIPCODE -> handleAddressInfoResponse(response)
            else -> handleDefaultResponse()
        }
    }

    private fun handleAddressInfoResponse(response: Response?): Exception {
        return when (response?.status()) {
            404 -> {
                val message = extractErrorMessageFromResponse(response)
                ExternalApiException.of(404, 10, message)
            }

            else -> handleDefaultResponse()
        }
    }

    private fun extractErrorMessageFromResponse(response: Response?): String {
        val body =
            response?.body()?.asInputStream()?.bufferedReader()?.use(BufferedReader::readText)
        val jsonResponse = JsonParser.parseString(body).asJsonObject
        val result = jsonResponse.getAsJsonObject("result")
        return result["message"].asString
    }

    private fun handleDefaultResponse(): Exception {
        return ExternalApiException.of(500, ErrorEnum.INTEGRATION_ERROR, "Open Brazil")
    }
}