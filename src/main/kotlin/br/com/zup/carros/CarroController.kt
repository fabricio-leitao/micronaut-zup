package br.com.zup.carros

import br.com.zup.carros.Carro
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller
class CarroController {

    @Post("/api/carros")
    fun criar(@Body @Valid carro: Carro): HttpResponse<Any> {
        return HttpResponse.ok()
    }
}