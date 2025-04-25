package br.com.fiap.contatos.service;

import br.com.fiap.contatos.dto.ContatoCadastroDto;
import br.com.fiap.contatos.dto.ContatoExibicaoDto;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public ContatoExibicaoDto gravar(ContatoCadastroDto contatoCadastroDto) {
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoCadastroDto, contato);
        return new ContatoExibicaoDto(repository.save(contato));
    }

    public ContatoExibicaoDto buscarPeloId(Long id) {
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()) {
         return new ContatoExibicaoDto(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato NÃO encontrado !!!");
        }
    }

    public List<Contato> listarTodos(){
        return repository.findAll();
    }

    public void exluir(Long id) {
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()) {
            repository.delete(contatoOptional.get());
        }else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public List<Contato> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal) {
        return repository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    public Contato atualizar(Contato contato) {
        Optional<Contato> contatoOptional = repository.findById(contato.getId());
        if (contatoOptional.isPresent()) {
            return repository.save(contato);
        }else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public ContatoExibicaoDto buscarPorNome(String nome) {
        Optional<Contato> contatoOptional = repository.findByNome(nome);
        if (contatoOptional.isPresent()) {
            return new ContatoExibicaoDto(contatoOptional.get());
        }else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }
}
