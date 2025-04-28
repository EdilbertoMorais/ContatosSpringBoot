package br.com.fiap.contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContatoCadastroDto(
        Long id,

        @NotBlank(message = "O nome do contato é obrigatório!")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório!")
        @Email(message = "O e-mail esta com o formato inválido!")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres.")
        String senha,

        @NotNull(message = "A data de nascimento é obrigatória!") //no LocalDate não pode ser usado o @NotBlank
        LocalDate dataNascimento
) {
}
