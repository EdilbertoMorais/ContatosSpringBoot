package br.com.fiap.contatos.repository;

import br.com.fiap.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

// A ‘interface’ JpaRepository implementa todos os métodos de persistência de dados no DB
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE c.nome = :nome")
    Optional<Contato> buscarContatoPeloNome(@Param("nome") String nome);

}
