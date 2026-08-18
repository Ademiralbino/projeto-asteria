package com.ademiralbino.projetoasteria.dto;

import com.ademiralbino.projetoasteria.enums.StatusModelo;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ModeloRequest(

        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 100, message = "Nome deve possuir no máximo 100 caracteres.")
        String nome,


        @Size(max = 100, message = "Nome artístico deve possuir no máximo 100 caracteres.")
        String nomeArtistico,


        @NotNull(message = "Data de cadastro é obrigatória.")
        LocalDate dataCadastro,


        @NotNull(message = "Status é obrigatório.")
        StatusModelo status,


        @NotNull(message = "Booker é obrigatório.")
        UUID bookerId,


        UUID scouterId,


        @DecimalMin(value = "0.0", message = "Comissão não pode ser negativa.")
        @DecimalMax(value = "100.0", message = "Comissão não pode ser maior que 100%.")
        BigDecimal percentualComissao,


        @Size(max = 20, message = "Telefone deve possuir no máximo 20 caracteres.")
        String telefone,


        @Email(message = "Email deve possuir formato válido.")
        @Size(max = 100, message = "Email deve possuir no máximo 100 caracteres.")
        String email,


        @Size(max = 255, message = "Foto deve possuir no máximo 255 caracteres.")
        String foto

) {}