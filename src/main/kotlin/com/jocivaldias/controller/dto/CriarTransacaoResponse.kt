package com.jocivaldias.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.jocivaldias.entity.Transacao
import com.jocivaldias.entity.enums.TipoTransacao
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class CriarTransacaoResponse (
    @JsonProperty("id_transacao")
    val idTransacao: UUID,
    val codigo: String,
    @JsonProperty("id_carteira")
    val idCarteira: UUID,
    @JsonProperty("tipo_transacao")
    val tipoTransacao: TipoTransacao,
    val quantidade: Int,
    val valor: BigDecimal,
    val dataTransacao: LocalDateTime
)

fun Transacao.toCriarTransacaoResponse(): CriarTransacaoResponse {
    return CriarTransacaoResponse(idTransacao, codigo, idCarteira, tipoTransacao, quantidade, valor, dataTransacao)
}
