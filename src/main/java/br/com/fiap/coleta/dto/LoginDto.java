package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usuário é não é válido!")
        String email,

        @NotBlank(message = "A senha do usuário é obrigatória!")
        @Size(min = 6, max = 20, message = "A senha do deve conter entre 6 e 20 caracteres!")
        String senha

) {
}
