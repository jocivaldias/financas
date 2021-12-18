package com.jocivaldias.service

import com.jocivaldias.entity.Carteira
import com.jocivaldias.entity.CarteiraAtivo
import com.jocivaldias.entity.CarteiraAtivoPK
import com.jocivaldias.entity.Transacao
import com.jocivaldias.entity.enums.TipoTransacao
import com.jocivaldias.exception.CarteiraNaoEncontradaException
import com.jocivaldias.repository.CarteiraRepository
import com.orange.foundation.jvm.micronaut.rest.errors.BusinessError
import jakarta.inject.Singleton
import java.math.BigDecimal
import java.util.*

@Singleton
class CarteiraService(
    val carteiraRepository: CarteiraRepository
) {

    fun criarCarteira(): Carteira {
        return carteiraRepository.save(Carteira(
            UUID.randomUUID(),
            BigDecimal.valueOf(0.00).toDouble(),
            mutableListOf()
        ))
    }

    fun buscarCarteira(idCarteira: UUID): Carteira {
        val carteiraOptional = carteiraRepository.findById(idCarteira)

        return if (carteiraOptional.isPresent) carteiraOptional.get() else throw BusinessError(
            CarteiraNaoEncontradaException("Carteira não encontrada"), 404)
    }
}
