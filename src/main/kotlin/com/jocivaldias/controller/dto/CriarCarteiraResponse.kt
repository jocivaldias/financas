package com.jocivaldias.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.jocivaldias.entity.Carteira
import java.util.*

class CriarCarteiraResponse (
    @JsonProperty("id_carteira")
    val idCarteira: UUID,
    val rendimento: Double
)

fun Carteira.toCriarTransacaoResponse(): CriarCarteiraResponse{
    return CriarCarteiraResponse(
        idCarteira = idCarteira,
        rendimento = rendimento
    )
}
