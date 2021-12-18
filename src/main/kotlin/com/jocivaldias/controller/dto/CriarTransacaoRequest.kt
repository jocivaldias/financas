package com.jocivaldias.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.jocivaldias.entity.Ativo
import com.jocivaldias.entity.Transacao
import com.jocivaldias.entity.enums.TipoAtivo
import com.jocivaldias.entity.enums.TipoTransacao
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Introspected
data class CriarTransacaoRequest (
    @field:NotBlank
    val codigo: String,
    @field:NotBlank
    @JsonProperty("id_carteira")
    val idCarteira: UUID,
    @field:NotNull
    @JsonProperty("tipo_transacao")
    val tipoTransacao: TipoTransacao,
    @field:NotNull
    @field:PositiveOrZero
    val quantidade: Int,
    @field:NotNull
    @field:PositiveOrZero
    val valor: BigDecimal,
) {
    fun toDomain(): Transacao {
        return Transacao(
            codigo = codigo,
            idCarteira =  idCarteira,
            tipoTransacao = tipoTransacao,
            quantidade = quantidade,
            valor = valor
        )
    }
}