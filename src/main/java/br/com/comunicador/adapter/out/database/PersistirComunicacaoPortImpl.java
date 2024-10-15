package br.com.comunicador.adapter.out.database;

import br.com.comunicador.adapter.out.database.entity.ComunicacaoEntity;
import br.com.comunicador.adapter.out.database.mapper.ComunicacaoEntityMapper;
import br.com.comunicador.adapter.out.database.repository.ComunicacaoRepository;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.ports.out.persistence.PersistirComunicacaoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PersistirComunicacaoPortImpl implements PersistirComunicacaoPort {

    private final ComunicacaoEntityMapper mapper;

    private final ComunicacaoRepository repository;

    @Autowired
    public PersistirComunicacaoPortImpl(ComunicacaoEntityMapper mapper, ComunicacaoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Comunicacao salvar(Comunicacao comunicacao) {
        ComunicacaoEntity comunicacaoEntity = mapper.map(comunicacao);

        return mapper.map(repository.save(comunicacaoEntity));
    }

    @Override
    public Comunicacao consultar(Long id) {
        return repository.findById(id).map(mapper::map).orElseThrow(()-> new RuntimeException(""));//todo: criar exception propria
    }

    @Override
    public List<Comunicacao> buscarTodasComunicacoesParaExecucao() {
        List<ComunicacaoEntity> comunicacoesASeremExecutadas = repository.findByDataAgendamentoBeforeAndStatus(LocalDateTime.now(), StatusComunicacao.AGENDADA);

        return mapper.mapComunicacaoList(comunicacoesASeremExecutadas);
    }

    @Override
    public void salvarTodasComunicacoes(List<Comunicacao> comunicacaoList) {
        repository.saveAll(mapper.mapComunicacaoEntityList(comunicacaoList));
    }
}
