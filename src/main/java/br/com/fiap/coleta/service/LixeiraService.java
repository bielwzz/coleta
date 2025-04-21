package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.LixeiraExibicaoDto;
import br.com.fiap.coleta.dto.LixeiraCadastroDto;
import br.com.fiap.coleta.dto.LixeiraExibicaoDto;
import br.com.fiap.coleta.exception.UsuarioNaoEncontradoException;
import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.model.Lixeira;
import br.com.fiap.coleta.repository.LixeiraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LixeiraService {

    @Autowired
    private LixeiraRepository lixeiraRepository;

    public LixeiraExibicaoDto gravarlixeira(LixeiraCadastroDto lixeiraCadastroDto){
        Lixeira lixeira = new Lixeira();
        BeanUtils.copyProperties(lixeiraCadastroDto, lixeira);
        return new LixeiraExibicaoDto(lixeiraRepository.save(lixeira));
    }

    public LixeiraExibicaoDto buscarLixeiraPorId(Long id) {
        Optional<Lixeira> lixeiraOptional = lixeiraRepository.findById(id);
        if (lixeiraOptional.isPresent()) {
            return new LixeiraExibicaoDto(lixeiraOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Contato não encontrado!");
        }
    }

    public void excluirLixeira(Long id) {
        Optional<Lixeira> lixeiraOptional = lixeiraRepository.findById(id);
        if (lixeiraOptional.isPresent()) {
            lixeiraRepository.delete(lixeiraOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public Page<LixeiraExibicaoDto> listarLixeira(Pageable paginacao
    ) {
        return lixeiraRepository
                .findAll(paginacao)
                .map(LixeiraExibicaoDto::new);
    }

    public Lixeira atualizarLixeira(Lixeira lixeira) {
        Optional<Lixeira> lixeiraOptional = lixeiraRepository.findById(lixeira.getIdLixeira());

        if (lixeiraOptional.isPresent()) {
            return lixeiraRepository.save(lixeira);
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }


}
