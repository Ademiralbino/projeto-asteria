package com.ademiralbino.projetoasteria.dto;

import com.ademiralbino.projetoasteria.enums.StatusModelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ModeloResponse(

        UUID id,

        String nome,

        String nomeArtistico,

        LocalDate dataCadastro,

        StatusModelo status,

        UUID bookerId,

        UUID scouterId,

        BigDecimal percentualComissao,

        String telefone,

        String email,

        String foto,

        LocalDateTime criadoEm,

        LocalDateTime atualizadoEm

) {
}