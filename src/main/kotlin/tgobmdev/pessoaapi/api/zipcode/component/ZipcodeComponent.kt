package tgobmdev.pessoaapi.api.zipcode.component

import org.springframework.stereotype.Component
import tgobmdev.pessoaapi.api.zipcode.client.ZipcodeClient
import tgobmdev.pessoaapi.api.zipcode.response.AddressInfo

@Component
class ZipcodeComponent(private val zipcodeClient: ZipcodeClient) {
    fun fetchAddressInfoByZipcode(zipcode: String): AddressInfo {
        return zipcodeClient.fetchAddressInfoByZipcode(zipcode)
    }
}