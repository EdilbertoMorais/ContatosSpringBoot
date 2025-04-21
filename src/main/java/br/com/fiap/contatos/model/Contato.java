package br.com.fiap.contatos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity //indica que a classe será uma entidade no banco de dados
@Table(name = "tbl_contatos") // define o nome da tabela no banco de dados mantendo as boas práticas de nomenclatura
public class Contato {

    @Id // define que o Id será a chave primária da entidade na tabela do banco de dados
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATOS_SEQ")
    @SequenceGenerator(name = "CONTATOS_SEQ", sequenceName = "CONTATOS_SEQ", allocationSize = 1)
    private Long id;

    private String nome;
    private String email;
    @Column(name = "data_nascimento") // define o nome da coluna no banco de dados mantendo o padrão de nomenclatura
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id)
                && Objects.equals(nome, contato.nome)
                && Objects.equals(email, contato.email)
                && Objects.equals(dataNascimento, contato.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, dataNascimento);
    }

}
