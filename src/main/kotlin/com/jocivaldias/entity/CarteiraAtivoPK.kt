package com.jocivaldias.entity

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class CarteiraAtivoPK(
    @Column(name = "id_carteira", nullable = false)
    val idCarteira: UUID,
    @Column(name = "codigo", nullable = false)
    val codigo: String
): Serializable