package com.jocivaldias.service

import com.jocivaldias.entity.Transacao
import com.jocivaldias.exception.AtivoNaoEncontradoException
import com.jocivaldias.exception.CarteiraNaoEncontradaException
import com.jocivaldias.repository.AtivoRepository
import com.jocivaldias.repository.CarteiraRepository
import com.jocivaldias.repository.TransacaoRepository
import com.orange.foundation.jvm.micronaut.rest.errors.BusinessError
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton

@Singleton
class TransacaoService(
    val transacaoRepository: TransacaoRepository,
    val carteiraRepository: CarteiraRepository,
    val ativoRepository: AtivoRepository
) {

    fun criarTransacao(transacao: Transacao): Transacao {
        if (!carteiraRepository.existsById(transacao.idCarteira))
            throw BusinessError(CarteiraNaoEncontradaException("Carteira não existe"), HttpStatus.BAD_REQUEST.code)

        if (!ativoRepository.existsById(transacao.codigo))
            throw BusinessError(AtivoNaoEncontradoException("Ativo não existe"), HttpStatus.BAD_REQUEST.code)

        return transacaoRepository.save(transacao)
    }

}
