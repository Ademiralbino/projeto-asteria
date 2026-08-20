package com.ademiralbino.projetoasteria.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookerResponse(

        UUID id,

        String nome,

        String telefone,

        String email,

        LocalDateTime criadoEm,

        LocalDateTime atualizadoEm

) {
}