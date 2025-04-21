package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Coleta;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ColetaExibicaoDto (

        Long idColeta,
        LocalDate dataHora,
        String rota,
        String status

){
    public ColetaExibicaoDto(Coleta coleta){
        this(
                coleta.getIdColeta(),
                coleta.getDataHora(),
                coleta.getRota(),
                coleta.getStatus()
        );
    }
}
