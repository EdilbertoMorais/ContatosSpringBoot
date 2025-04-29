package br.com.fiap.contatos.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIOS")
    @SequenceGenerator(name = "SEQ_USUARIOS", sequenceName = "SEQ_USUARIOS", allocationSize = 1)
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioRole role;


    //o método getAuthorities() retorna uma lista de permissões atribuídas ao usuário autenticado (as roles)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsuarioRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    // o método getPassword() retorna a senha do usuário autenticado
    @Override
    public String getPassword() {
        return this.senha;
    }

    // o método getUserName() retorna o userName do usuário autenticado
    @Override
    public String getUsername() {
        return this.email;
    }

    // o método isAccountNonExpired() retorna a informação se a conta do usuário esta vencida ou não
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // o método isAccountNonLocked() retorna a informação se a conta do usuário esta Bloqueada ou não
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // o método isCredentialsNonExpired() retorna a informação se as credenciais do usuário esta bloqueadas ou não
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // o método isEnabled() retorna a informação se a conta do usuário esta ativa ou não
    @Override
    public boolean isEnabled() {
        return true;
    }
}
