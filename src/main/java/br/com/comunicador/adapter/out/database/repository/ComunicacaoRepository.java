package br.com.comunicador.adapter.out.database.repository;

import br.com.comunicador.adapter.out.database.entity.ComunicacaoEntity;
import br.com.comunicador.application.domain.StatusComunicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ComunicacaoRepository extends JpaRepository<ComunicacaoEntity, Long> {

    List<ComunicacaoEntity> findByDataAgendamentoLessThanEqualAndStatus(LocalDateTime data, StatusComunicacao status);
}
