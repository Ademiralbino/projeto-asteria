package com.ademiralbino.projetoasteria.dto;

import com.ademiralbino.projetoasteria.enums.StatusModelo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ModeloRequest(

        @NotBlank
        @Size(max = 100)
        String nome,

        @Size(max = 100)
        String nomeArtistico,

        @NotNull
        LocalDate dataCadastro,

        @NotNull
        StatusModelo status,

        @NotNull
        UUID bookerId,

        UUID scouterId,

        BigDecimal percentualComissao,

        @Size(max = 20)
        String telefone,

        @Email
        @Size(max = 100)
        String email,

        @Size(max = 255)
        String foto

) {
}