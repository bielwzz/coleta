package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;

public record LixeiraCadastroDto(

        Long idLixeira,

        @NotBlank(message = "A localização é obrigatória!")
        String localizacao,

        @NotBlank(message = "O tipo de coleta é obrigatório!")
        String tipoColeta,

        @NotBlank(message = "A capacidade da lixeira é obrigatória!")
        Long capacidade
) {
}
