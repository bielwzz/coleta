package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Lixeira;

public record LixeiraExibicaoDto(

        Long idLixeira,
        String localizacao,
        String tipoColeta,
        Long capacidade

) {
    public LixeiraExibicaoDto(Lixeira lixeira){
        this (
                lixeira.getIdLixeira(),
                lixeira.getLocalizacao(),
                lixeira.getTipoColeta(),
                lixeira.getCapacidade()
        );
    }
}
