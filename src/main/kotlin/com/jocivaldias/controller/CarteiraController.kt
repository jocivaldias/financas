package com.jocivaldias.controller

import com.jocivaldias.controller.dto.BuscarCarteiraResponse
import com.jocivaldias.controller.dto.CriarCarteiraResponse
import com.jocivaldias.controller.dto.toBuscarCarteiraResponse
import com.jocivaldias.controller.dto.toCriarTransacaoResponse
import com.jocivaldias.service.CarteiraService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.util.*

@Controller("financas/v1/carteiras")
@Validated
class CarteiraController(
    private val carteiraService: CarteiraService
) {

    @Post
    fun criarCarteira(): HttpResponse<CriarCarteiraResponse> {
        return HttpResponse.created(carteiraService.criarCarteira().toCriarTransacaoResponse())
    }

    @Get("/{id_carteira}")
    fun buscarCarteira(@PathVariable("id_carteira") idCarteira: UUID): HttpResponse<BuscarCarteiraResponse> {
        return HttpResponse.ok(carteiraService.buscarCarteira(idCarteira).toBuscarCarteiraResponse())
    }

}
