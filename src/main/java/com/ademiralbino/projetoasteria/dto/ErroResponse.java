package com.ademiralbino.projetoasteria.dto;

import java.time.LocalDateTime;

public record ErroResponse(

        LocalDateTime timestamp,

        Integer status,

        String erro,

        String mensagem,

        String caminho

) {
}