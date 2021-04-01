package br.com.zup.autores

import io.micronaut.core.annotation.Introspected

@Introspected
class DetalhesDoAutorResponse(autor: Autor) {

    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao
}
