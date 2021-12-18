package com.jocivaldias.entity

import com.jocivaldias.entity.enums.TipoAtivo
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "ativo")
data class Ativo (
    @Id
    val codigo: String,

    @NotNull
    @Column(name = "name", nullable = false)
    val nome: String,

    @NotNull
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    val tipo: TipoAtivo,

    @NotNull
    @Column(name = "ultimo_valor", nullable = false)
    val ultimoValor: BigDecimal,
) {
    @UpdateTimestamp
    @Column(name = "data_ultima_atualizacao", nullable = true)
    var dataUltimaAtualizacao: LocalDateTime? = null
}