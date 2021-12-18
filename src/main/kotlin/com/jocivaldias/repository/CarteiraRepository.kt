package com.jocivaldias.repository

import com.jocivaldias.entity.Carteira
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface CarteiraRepository: JpaRepository<Carteira, UUID>
