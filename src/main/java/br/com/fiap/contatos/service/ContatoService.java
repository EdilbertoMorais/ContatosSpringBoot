package br.com.fiap.contatos.service;

import br.com.fiap.contatos.dto.ContatoCadastroDto;
import br.com.fiap.contatos.dto.ContatoExibicaoDto;
import br.com.fiap.contatos.exception.UsuarioNaoEncontradoException;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            throw new UsuarioNaoEncontradoException("Contato NÃO encontrado !!!");
        }
    }

    public List<ContatoExibicaoDto> listarTodos() {
        return repository.findAll().stream()
                .map(ContatoExibicaoDto::new)
                .collect(Collectors.toList());
    }

    public void exluir(Long id) {
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()) {
            repository.delete(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public Contato atualizar(Contato contato) {
        Optional<Contato> contatoOptional = repository.findById(contato.getId());
        if (contatoOptional.isPresent()) {
            return repository.save(contato);
        }else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

//    public ContatoExibicaoDto atualizar(Long id, ContatoCadastroDto contatoCadastroDto) {
//        Contato contato = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o ID: " + id));
//        BeanUtils.copyProperties(contatoCadastroDto, contato);
//        Contato contatoAtualizado = repository.save(contato);
//        return new ContatoExibicaoDto(contatoAtualizado);
//    }

    public ContatoExibicaoDto buscarContatoPeloNome(String nome){
        Optional<Contato> contatoOptional = repository.buscarContatoPeloNome(nome);
        if (contatoOptional.isPresent()) {
            return new ContatoExibicaoDto(contatoOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Contato NÃO encontrado!!!");
        }
    }

    public ContatoExibicaoDto buscarContatoPeloEmail(String email){
        Optional<Contato> contatoOptional = repository.findByEmail(email);
        if (contatoOptional.isPresent()) {
            return new ContatoExibicaoDto(contatoOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Contato NÃO encontrado!!!");
        }
    }

    public List<ContatoExibicaoDto> listarAniversariantesDoPeriodo(LocalDate dataInicio, LocalDate dataFim){
        return repository.listarAniversariantesDoPeriodo(dataInicio, dataFim)
                .stream()
                .map(ContatoExibicaoDto::new)
                .toList();
    }
}
