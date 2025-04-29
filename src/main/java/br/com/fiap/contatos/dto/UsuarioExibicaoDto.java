package br.com.fiap.contatos.dto;

import br.com.fiap.contatos.model.UsuarioRole;
import br.com.fiap.contatos.model.Usuario;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole usuarioRole
) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }
}
