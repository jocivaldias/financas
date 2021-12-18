package com.jocivaldias.repository

import com.jocivaldias.entity.Transacao
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface TransacaoRepository: JpaRepository<Transacao, UUID>
