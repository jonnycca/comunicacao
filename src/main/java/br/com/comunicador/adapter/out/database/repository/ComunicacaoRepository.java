package br.com.comunicador.adapter.out.database.repository;

import br.com.comunicador.adapter.out.database.entity.ComunicacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunicacaoRepository extends JpaRepository<ComunicacaoEntity, Long> {
}
