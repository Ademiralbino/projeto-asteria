package com.ademiralbino.projetoasteria.entity;

import com.ademiralbino.projetoasteria.enums.StatusModelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "modelo")
public class Modelo extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "nome_artistico", length = 100)
    private String nomeArtistico;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusModelo status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booker_id", nullable = false)
    private Booker booker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scouter_id")
    private Scouter scouter;

    @Column(name = "percentual_comissao", precision = 5, scale = 2)
    private BigDecimal percentualComissao;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String foto;
}