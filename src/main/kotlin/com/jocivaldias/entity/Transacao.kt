package com.jocivaldias.entity

import com.jocivaldias.entity.enums.TipoTransacao
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "transacao")
data class Transacao(
    @NotNull
    @Column(name = "codigo", nullable = false)
    val codigo: String,

    @NotNull
    @Column(name = "id_carteira", nullable = false)
    val idCarteira: UUID,

    @NotNull
    @Column(name = "tipo_transacao", nullable = false)
    @Enumerated(EnumType.STRING)
    val tipoTransacao: TipoTransacao,

    @PositiveOrZero
    @Column(name = "quantidade", nullable = false)
    val quantidade: Int,

    @PositiveOrZero
    @Column(name = "valor", nullable = false)
    val valor: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transacao", nullable = false)
    lateinit var idTransacao: UUID

    @CreationTimestamp
    @Column(name = "data_transacao", nullable = false)
    lateinit var dataTransacao: LocalDateTime
}
