package br.com.fiap.contatos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity //indica que a classe será uma entidade no banco de dados
@Table(name = "tbl_contatos") // define o nome da tabela no banco de dados mantendo as boas práticas de nomenclatura
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contato {

    @Id // define que o Id será a chave primária da entidade na tabela do banco de dados
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATOS")
    @SequenceGenerator(name = "SEQ_CONTATOS", sequenceName = "SEQ_CONTATOS", allocationSize = 1)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Column(name = "data_nascimento") // define o nome da coluna no banco de dados mantendo o padrão de nomenclatura
    private LocalDate dataNascimento;

}
