package com.jocivaldias.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "carteira")
data class Carteira (
    @Id
    @Column(name = "id_carteira", nullable = false)
    val idCarteira: UUID,

    @NotNull
    @Column(name = "rendimento", nullable = false)
    val rendimento: Double,

    @OneToMany(mappedBy = "carteiraAtivoPK.idCarteira", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val ativos: MutableList<CarteiraAtivo>
)
