package br.com.comunicador.adapter.in.scheduler;

import br.com.comunicador.application.ports.in.ExecutarComunicacaoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class AgendadorComunicacoes {

    private final ExecutarComunicacaoPort executarComunicacaoPort;

    @Autowired
    public AgendadorComunicacoes(ExecutarComunicacaoPort executarComunicacaoPort) {
        this.executarComunicacaoPort = executarComunicacaoPort;
    }

    @Scheduled(fixedDelay = 60000)
    public void agendarComunicacaoTask() {
        executarComunicacaoPort.executar();
    }
}
