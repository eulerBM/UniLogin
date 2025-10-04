package com.login.back_end.user.dtos;

public record CreateUserDTO(
        String nome,
        String email,
        String senha,
        String confirmarSenha
) {
}
