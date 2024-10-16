package br.com.comunicador.application.service;

import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.ports.in.ExecutarComunicacaoPort;
import br.com.comunicador.application.ports.out.event.ComunicarMensagemEventPort;
import br.com.comunicador.application.ports.out.persistence.PersistirComunicacaoPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ExecutarComunicacaoPortImpl implements ExecutarComunicacaoPort {

    private final PersistirComunicacaoPort persistirComunicacao;

    private final ComunicarMensagemEventPort comunicarMensagemEventPort;

    @Autowired
    public ExecutarComunicacaoPortImpl(PersistirComunicacaoPort persistirComunicacao, ComunicarMensagemEventPort comunicarMensagemEventPort) {
        this.persistirComunicacao = persistirComunicacao;
        this.comunicarMensagemEventPort = comunicarMensagemEventPort;
    }

    @Override
    public void executar() {
        List<Comunicacao> comunicacoesASeremExecutadas = persistirComunicacao.buscarTodasComunicacoesParaExecucao();

        log.info("Comunicacoes a serem processadas:" + comunicacoesASeremExecutadas.toString());
        for(Comunicacao comunicacao: comunicacoesASeremExecutadas){
            comunicarMensagemEventPort.enviar(comunicacao);
            comunicacao.setStatusEnviada();
        }
        persistirComunicacao.salvarTodasComunicacoes(comunicacoesASeremExecutadas);
        log.info("Fim do processamento das comunicacoes");
    }
}
