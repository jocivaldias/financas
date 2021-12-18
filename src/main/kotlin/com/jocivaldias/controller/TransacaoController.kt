package com.jocivaldias.controller

import com.jocivaldias.controller.dto.*
import com.jocivaldias.service.TransacaoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller("financas/v1/transacoes")
@Validated
class TransacaoController(
    private val transacaoService: TransacaoService
) {

    @Post
    fun criarTransacao(@Body @Valid criarTransacaoRequest: CriarTransacaoRequest): HttpResponse<CriarTransacaoResponse> {
        return HttpResponse.created(transacaoService.criarTransacao(criarTransacaoRequest.toDomain()).toCriarTransacaoResponse())
    }

}
