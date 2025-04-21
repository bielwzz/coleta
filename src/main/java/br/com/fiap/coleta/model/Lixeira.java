package br.com.fiap.coleta.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TBL_LIXEIRA")
public class Lixeira {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "LIXEIRA_SEQ"
    )
    @SequenceGenerator(
            name = "LIXEIRA_SEQ",
            sequenceName = "LIXEIRA_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_lixeira")
    private Long idLixeira;

    private String localizacao;

    @Column(name = "tipo_coleta")
    private String tipoColeta;

    private Long capacidade;

    public Long getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(Long idLixeira) {
        this.idLixeira = idLixeira;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoColeta() {
        return tipoColeta;
    }

    public void setTipoColeta(String tipoColeta) {
        this.tipoColeta = tipoColeta;
    }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lixeira lixeira = (Lixeira) o;
        return Objects.equals(idLixeira, lixeira.idLixeira) && Objects.equals(localizacao, lixeira.localizacao) && Objects.equals(tipoColeta, lixeira.tipoColeta) && Objects.equals(capacidade, lixeira.capacidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLixeira, localizacao, tipoColeta, capacidade);
    }
}

