package com.jocivaldias.repository

import com.jocivaldias.entity.Ativo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AtivoRepository: JpaRepository<Ativo, String>
