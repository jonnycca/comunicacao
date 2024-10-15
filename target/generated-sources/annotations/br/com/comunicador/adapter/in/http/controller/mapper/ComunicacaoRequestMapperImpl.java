package br.com.comunicador.adapter.in.http.controller.mapper;

import br.com.comunicador.adapter.in.http.controller.request.AgendarComunicacaoRequest;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-14T22:45:58-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ComunicacaoRequestMapperImpl implements ComunicacaoRequestMapper {

    @Override
    public Comunicacao map(AgendarComunicacaoRequest request) {
        if ( request == null ) {
            return null;
        }

        LocalDateTime dataAgendamento = null;
        TipoComunicacao tipoComunicacao = null;
        String destinatario = null;
        String mensagem = null;

        dataAgendamento = request.getDataAgendamento();
        tipoComunicacao = request.getTipoComunicacao();
        destinatario = request.getDestinatario();
        mensagem = request.getMensagem();

        Long id = null;

        Comunicacao comunicacao = new Comunicacao( id, dataAgendamento, tipoComunicacao, destinatario, mensagem );

        return comunicacao;
    }
}
