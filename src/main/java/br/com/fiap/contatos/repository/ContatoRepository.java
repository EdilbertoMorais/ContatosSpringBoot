package br.com.fiap.contatos.repository;

import br.com.fiap.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// A ‘interface’ JpaRepository implementa todos os métodos de persistência de dados no DB
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE c.nome = :nome")
    Optional<Contato> buscarContatoPeloNome(@Param("nome") String nome);

    Optional<Contato> findByEmail(String email);

    @Query("SELECT c FROM Contato c WHERE c.dataNascimento BETWEEN :dataInicio AND :dataFim")
    List<Contato> listarAniversariantesDoPeriodo(@Param("dataInicio")LocalDate  dataInicio,
                                                 @Param("dataFim")LocalDate dataFim);

}
