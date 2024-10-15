package br.com.comunicador.application.ports.in;

import br.com.comunicador.application.domain.Comunicacao;

public interface ComunicacaoPort {

    Comunicacao comunicar(Comunicacao comunicacao);
}
