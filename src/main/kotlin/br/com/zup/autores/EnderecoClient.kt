package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/cep/")
interface EnderecoClient {

    // GET http://localhost:8081/cep/{cep}
    //@Get("{cep}")
    @Get(consumes = [ MediaType.APPLICATION_XML])
    @Consumes(MediaType.APPLICATION_XML)
    fun consulta(@QueryValue cep: String): HttpResponse<EnderecoResponse>
}