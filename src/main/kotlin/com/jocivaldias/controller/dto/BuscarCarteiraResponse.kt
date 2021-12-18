package com.jocivaldias.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.jocivaldias.entity.Carteira
import java.math.BigDecimal
import java.util.*


class BuscarCarteiraResponse (
    @JsonProperty("id_carteira")
    val idCarteira: UUID,
    val rendimento: Double,
    val ativos: List<BuscarCarteiraAtivoResponse>
) {
    class BuscarCarteiraAtivoResponse(
        val codigo: String,
        val quantidade: Int,
        val precoMedio: BigDecimal
    )
}

fun Carteira.toBuscarCarteiraResponse(): BuscarCarteiraResponse{
    return BuscarCarteiraResponse(
        idCarteira = idCarteira,
        rendimento = rendimento,
        ativos = ativos.map { BuscarCarteiraResponse.BuscarCarteiraAtivoResponse(
            codigo = it.carteiraAtivoPK.codigo,
            quantidade = it.quantidade,
            precoMedio = it.precoMedio
        ) }
    )
}

