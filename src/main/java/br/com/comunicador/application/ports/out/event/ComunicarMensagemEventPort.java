package br.com.comunicador.application.ports.out.event;

import br.com.comunicador.application.domain.Comunicacao;

public interface ComunicarMensagemEventPort {

    void enviar(Comunicacao comunicacao);
}
