package br.com.victor.repository;

import br.com.victor.model.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadaoRepository extends JpaRepository<Cidadao, String> {
}
