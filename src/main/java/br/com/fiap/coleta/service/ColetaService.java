package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.ColetaCadastroDto;
import br.com.fiap.coleta.dto.ColetaExibicaoDto;
import br.com.fiap.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.coleta.exception.UsuarioNaoEncontradoException;
import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.repository.ColetaRepository;
import br.com.fiap.coleta.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    public ColetaExibicaoDto gravarColeta(ColetaCadastroDto coletaCadastroDto){
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaCadastroDto, coleta);
        return new ColetaExibicaoDto(coletaRepository.save(coleta));
    }

    public ColetaExibicaoDto buscarColetaPorId(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            return new ColetaExibicaoDto(coletaOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Contato não encontrado!");
        }
    }

    public void excluirColeta(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            coletaRepository.delete(coletaOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public Page<ColetaExibicaoDto> listarColeta(Pageable paginacao) {
        return coletaRepository
                .findAll(paginacao)
                .map(ColetaExibicaoDto::new);
    }

    public Coleta atualizarColeta(Coleta coleta) {
        Optional<Coleta> contatoOptional = coletaRepository.findById(coleta.getIdColeta());

        if (contatoOptional.isPresent()) {
            return coletaRepository.save(coleta);
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

}
