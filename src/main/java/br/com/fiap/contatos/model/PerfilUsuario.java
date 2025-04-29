package br.com.fiap.contatos.model;

public enum PerfilUsuario {
    ADMIN("admin"),
    USER("user");

    private final String perfil;

    PerfilUsuario(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
