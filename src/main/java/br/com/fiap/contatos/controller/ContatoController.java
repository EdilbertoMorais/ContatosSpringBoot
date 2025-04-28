package br.com.fiap.contatos.controller;

import br.com.fiap.contatos.dto.ContatoCadastroDto;
import br.com.fiap.contatos.dto.ContatoExibicaoDto;
import br.com.fiap.contatos.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    //a annotation @Valid deve ser inserida para que as validações do CadastroDto sejam aplicadas
    public ContatoExibicaoDto gravar(@RequestBody @Valid ContatoCadastroDto contatoCadastroDto) {
        return service.gravar(contatoCadastroDto);
    }

    @GetMapping("/contatos/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoExibicaoDto> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.exluir(id);
    }

    @PutMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto atualizar(@PathVariable Long id, @RequestBody @Valid ContatoCadastroDto contatoCadastroDto) {
        return service.atualizar(id, contatoCadastroDto);
    }

    @GetMapping("/contatos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoExibicaoDto> mostrarAniversariantes(@PathVariable LocalDate dataInicial,
                                                           @PathVariable LocalDate dataFinal) {
        return service.mostrarAniversariantes(dataInicial, dataFinal);
    }
}
