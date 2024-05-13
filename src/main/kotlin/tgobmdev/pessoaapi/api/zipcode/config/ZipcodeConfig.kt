package tgobmdev.pessoaapi.api.zipcode.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tgobmdev.pessoaapi.api.zipcode.decoder.ZipcodeErrorDecoder

@Configuration
class ZipcodeConfig {
    @Bean
    fun zipcodeErrorDecoder(): ZipcodeErrorDecoder {
        return ZipcodeErrorDecoder()
    }
}