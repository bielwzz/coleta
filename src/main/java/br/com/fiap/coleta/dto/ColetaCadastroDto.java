package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ColetaCadastroDto(

        Long idColeta,

        @NotNull(message = "A data é obrigatória!")
        LocalDate dataHora,
        @NotBlank(message = "A rota é obrigatória!")
        String rota,
        @NotBlank(message = "O status é obrigatório!")
        String status


) {
}
