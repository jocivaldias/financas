package com.jocivaldias.controller.dto

import com.jocivaldias.entity.Ativo
import com.jocivaldias.entity.enums.TipoAtivo
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Introspected
data class CriarAtivoRequest (
    @field:NotBlank
    val codigo: String,
    @field:NotBlank
    val nome: String,
    @field:NotNull
    val tipo: TipoAtivo,
    @field:NotNull
    @field:PositiveOrZero
    val ultimoValor: BigDecimal
) {

    fun toDomain(): Ativo {
        return Ativo(
            codigo = codigo.toLowerCase(),
            nome = nome,
            tipo = tipo,
            ultimoValor = ultimoValor
        )
    }
}