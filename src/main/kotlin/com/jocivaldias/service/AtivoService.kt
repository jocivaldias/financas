package com.jocivaldias.service

import com.jocivaldias.entity.Ativo
import com.jocivaldias.exception.AtivoNaoEncontradoException
import com.jocivaldias.exception.CodigoAtivoJaCadastradoException
import com.jocivaldias.repository.AtivoRepository
import com.orange.foundation.jvm.micronaut.rest.errors.BusinessError
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton

@Singleton
class AtivoService(
    private val ativoRepository: AtivoRepository
) {

    fun criarAtivo(ativo: Ativo): Ativo {
        if (ativoRepository.existsById(ativo.codigo)) {
            throw BusinessError(CodigoAtivoJaCadastradoException("Código já cadastrado"), HttpStatus.UNPROCESSABLE_ENTITY.code)
        }
        return ativoRepository.save(ativo)
    }

    fun buscarAtivos(): List<Ativo> {
        return ativoRepository.findAll()
    }

    fun buscarAtivo(codigo: String): Ativo {
        val ativo = ativoRepository.findById(codigo)
        return if (ativo.isPresent) ativo.get() else throw BusinessError(AtivoNaoEncontradoException("Ativo não encontrado"), HttpStatus.NOT_FOUND.code)
    }

    fun deleteAtivo(codigo: String) {
        if (ativoRepository.existsById(codigo)) {
            ativoRepository.deleteById(codigo)
        } else {
            throw BusinessError(AtivoNaoEncontradoException("Ativo não encontrado"), HttpStatus.NOT_FOUND.code)
        }
    }

}
