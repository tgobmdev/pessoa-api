package tgobmdev.pessoaapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class PessoaApiApplication

fun main(args: Array<String>) {
    runApplication<PessoaApiApplication>(*args)
}