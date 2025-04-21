package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Usuario;
import br.com.fiap.coleta.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role

) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }
}