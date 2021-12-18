package com.jocivaldias.entity

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "carteira_ativo")
data class CarteiraAtivo (

    @EmbeddedId
    val carteiraAtivoPK: CarteiraAtivoPK,

    @NotNull
    @Column(name = "precoMedio", nullable = false)
    var precoMedio: BigDecimal,

    @NotNull
    @Column(name = "quantidade", nullable = false)
    var quantidade: Int,
)


