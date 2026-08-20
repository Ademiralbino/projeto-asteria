package com.ademiralbino.projetoasteria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ScouterRequest(

        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres.")
        String nome,

        @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres.")
        String telefone,

        @Email(message = "E-mail inválido.")
        @Size(max = 100, message = "E-mail deve ter no máximo 100 caracteres.")
        String email

) {
}