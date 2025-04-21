package br.com.fiap.coleta.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TBL_COLETA")
public class Coleta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COLETA_SEQ"
    )
    @SequenceGenerator(
            name = "COLETA_SEQ",
            sequenceName = "COLETA_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_coleta")
    private Long idColeta;

    @Column(name = "data_hora")
    private LocalDate dataHora;
    private String rota;
    private String status;

    public Long getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(Long idColeta) {
        this.idColeta = idColeta;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleta coleta = (Coleta) o;
        return Objects.equals(idColeta, coleta.idColeta) && Objects.equals(dataHora, coleta.dataHora) && Objects.equals(rota, coleta.rota) && Objects.equals(status, coleta.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColeta, dataHora, rota, status);
    }
}