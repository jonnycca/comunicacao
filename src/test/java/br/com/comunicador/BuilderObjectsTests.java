package br.com.comunicador;

import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;

import java.time.LocalDateTime;

public class BuilderObjectsTests {

    public static Comunicacao buildComunicacao() {
        return new Comunicacao(1L,
                LocalDateTime.now(),
                TipoComunicacao.WHATSAPP,
                "destinatarioTestBuilder",
                "mensagemTestBuilder",
                StatusComunicacao.AGENDADA);
    }
}
