package br.com.fiap.contatos.dto;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email
) {
}
