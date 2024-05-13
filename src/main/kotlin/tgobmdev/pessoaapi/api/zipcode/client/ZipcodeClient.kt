package tgobmdev.pessoaapi.api.zipcode.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import tgobmdev.pessoaapi.api.zipcode.config.ZipcodeConfig
import tgobmdev.pessoaapi.api.zipcode.decoder.ZipcodeErrorDecoder
import tgobmdev.pessoaapi.api.zipcode.response.AddressInfo

@FeignClient(
    name = "zipcode-client",
    url = "https://api.brasilaberto.com/v1",
    configuration = [ZipcodeConfig::class, ZipcodeErrorDecoder::class]
)
fun interface ZipcodeClient {
    @GetMapping("/zipcode/{zipcode}")
    fun fetchAddressInfoByZipcode(@PathVariable zipcode: String): AddressInfo
}