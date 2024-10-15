package br.com.comunicador.application.ports.out.persistence;

import br.com.comunicador.application.domain.Comunicacao;

public interface PersistirComunicacaoPort {

    Comunicacao salvar(Comunicacao comunicacao);

    Comunicacao consultar(Long id);


}
