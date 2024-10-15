package br.com.comunicador.application.ports.out.persistence;

import br.com.comunicador.application.domain.Comunicacao;

import java.util.List;

public interface PersistirComunicacaoPort {

    Comunicacao salvar(Comunicacao comunicacao);

    Comunicacao consultar(Long id);

    List<Comunicacao> buscarTodasComunicacoesParaExecucao();

    void salvarTodasComunicacoes(List<Comunicacao> comunicacaoList);
}
