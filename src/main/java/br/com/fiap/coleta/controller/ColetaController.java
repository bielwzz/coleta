package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.ColetaCadastroDto;
import br.com.fiap.coleta.dto.ColetaExibicaoDto;
import br.com.fiap.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ColetaController {

    @Autowired
    private ColetaService service;

    @PostMapping("/coleta")
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaExibicaoDto gravarColeta(@RequestBody @Valid ColetaCadastroDto coletaCadastroDto){
        return service.gravarColeta(coletaCadastroDto);
    }

    @GetMapping("/coleta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ColetaExibicaoDto buscarColetaPorId(@PathVariable Long id) {
        return service.buscarColetaPorId(id);
    }

    @GetMapping("/coleta")
    @ResponseStatus(HttpStatus.OK)
    public Page<ColetaExibicaoDto> listarColeta(Pageable paginacao) {
        return service.listarColeta(paginacao);
    }

    @DeleteMapping("/coleta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirColeta(@PathVariable Long id) {
        service.excluirColeta(id);
    }


    @PutMapping("/coleta")
    @ResponseStatus(HttpStatus.OK)
    public Coleta atualizarColeta(@RequestBody Coleta coleta) {
        return service.atualizarColeta(coleta);
    }


}
