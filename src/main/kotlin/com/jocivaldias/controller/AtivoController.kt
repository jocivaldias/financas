package com.jocivaldias.controller

import com.jocivaldias.controller.dto.*
import com.jocivaldias.service.AtivoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller("financas/v1/ativos")
@Validated
class AtivoController(
    private val ativoService: AtivoService
) {

    @Post
    fun criarAtivo(@Body @Valid criarAtivoRequest: CriarAtivoRequest): HttpResponse<CriarAtivoResponse> {
        return HttpResponse.created(ativoService.criarAtivo(criarAtivoRequest.toDomain()).toCriarAtivoResponse())
    }

    @Get("/")
    fun buscarAtivo(): HttpResponse<List<BuscarAtivoResponse>> {
        return HttpResponse.ok(ativoService.buscarAtivos().map { it.toBuscarAtivoResponse() })
    }

    @Get("/{codigo}")
    fun buscarAtivo(@PathVariable codigo: String): HttpResponse<BuscarAtivoResponse> {
        return HttpResponse.ok(ativoService.buscarAtivo(codigo).toBuscarAtivoResponse())
    }

    @Delete("/{codigo}")
    fun deleteAtivo(@PathVariable codigo: String): HttpResponse<Void> {
        ativoService.deleteAtivo(codigo)
        return HttpResponse.noContent()
    }

}