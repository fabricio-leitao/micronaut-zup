package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest){

        //request => domínio

        println("Requisicao => $request")

        val autor = request.toModel()
        autorRepository.save(autor)

        println("Autor => ${autor.nome}")

    }

    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") email:String): HttpResponse<Any> {

        if(email.isBlank()) {
            val autores = autorRepository.findAll()

            val resposta = autores.map { autor -> DetalhesDoAutorResponse(autor) }

            return HttpResponse.ok(resposta)
        }

        //val possivelAutor = autorRepository.findByEmail(email)
        val possivelAutor2 = autorRepository.buscaPorEmail(email)

        if(possivelAutor2.isEmpty){
            return HttpResponse.notFound()
        }

        val autor = possivelAutor2.get()
        return HttpResponse.ok(DetalhesDoAutorResponse(autor))
    }
}