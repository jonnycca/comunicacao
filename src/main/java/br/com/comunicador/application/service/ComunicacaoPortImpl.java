package br.com.comunicador.application.service;

import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.ports.in.ComunicacaoPort;
import br.com.comunicador.application.ports.out.persistence.PersistirComunicacaoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunicacaoPortImpl implements ComunicacaoPort {

    private final PersistirComunicacaoPort persistirComunicacao;

    @Autowired
    public ComunicacaoPortImpl(PersistirComunicacaoPort persistirComunicacao) {
        this.persistirComunicacao = persistirComunicacao;
    }

    @Override
    public Comunicacao comunicar(Comunicacao comunicacao) {
        comunicacao.setStatusAgendada();
        return persistirComunicacao.salvar(comunicacao);
    }
}
