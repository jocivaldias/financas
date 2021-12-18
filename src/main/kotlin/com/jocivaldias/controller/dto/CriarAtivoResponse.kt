package com.jocivaldias.controller.dto

import com.jocivaldias.entity.Ativo
import com.jocivaldias.entity.enums.TipoAtivo
import java.math.BigDecimal
import java.time.LocalDateTime

data class CriarAtivoResponse(
    val codigo: String,
    val nome: String,
    val tipo: TipoAtivo,
    val ultimoValor: BigDecimal,
    val dataUltimaAtualizacao: LocalDateTime?
)

fun Ativo.toCriarAtivoResponse() = CriarAtivoResponse(
    codigo = codigo,
    nome = nome,
    tipo = tipo,
    ultimoValor = ultimoValor,
    dataUltimaAtualizacao = dataUltimaAtualizacao
)