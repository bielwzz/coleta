package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Lixeira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LixeiraRepository extends JpaRepository<Lixeira, Long> {
}
