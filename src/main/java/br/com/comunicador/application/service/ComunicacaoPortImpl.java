package br.com.comunicador.application.service;

import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.ports.in.ComunicacaoPort;
import org.springframework.stereotype.Service;

@Service
public class ComunicacaoPortImpl implements ComunicacaoPort {

    @Override
    public void comunicar(Comunicacao comunicacao) {
        //todo: regra de negocio
        //salvar na base de dados
        // postar na fila

        System.out.println(comunicacao);
    }
}
