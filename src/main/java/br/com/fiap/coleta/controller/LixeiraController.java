package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.LixeiraCadastroDto;
import br.com.fiap.coleta.dto.LixeiraExibicaoDto;
import br.com.fiap.coleta.model.Lixeira;
import br.com.fiap.coleta.service.LixeiraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class LixeiraController {

    @Autowired
    private LixeiraService service;

    @PostMapping("/lixeira")
    @ResponseStatus(HttpStatus.CREATED)
    public LixeiraExibicaoDto gravarLixeira(@RequestBody @Valid LixeiraCadastroDto lixeiraCadastroDto){
        return service.gravarlixeira(lixeiraCadastroDto);
    }

    @GetMapping("/lixeira/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LixeiraExibicaoDto buscarLixeiraPorId(@PathVariable Long id) {
        return service.buscarLixeiraPorId(id);
    }

    @GetMapping("/lixeira")
    @ResponseStatus(HttpStatus.OK)
    public Page<LixeiraExibicaoDto> listarLixeira(Pageable paginacao) {
        return service.listarLixeira(paginacao);
    }

    @DeleteMapping("/lixeira/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirLixeira(@PathVariable Long id) {
        service.excluirLixeira(id);
    }


    @PutMapping("/lixeira")
    @ResponseStatus(HttpStatus.OK)
    public Lixeira atualizarLixeira(@RequestBody Lixeira lixeira) {
        return service.atualizarLixeira(lixeira);
    }

}
