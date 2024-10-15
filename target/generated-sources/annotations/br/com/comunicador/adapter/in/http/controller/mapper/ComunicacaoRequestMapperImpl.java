package br.com.comunicador.adapter.in.http.controller.mapper;

import br.com.comunicador.adapter.in.http.controller.request.AgendarComunicacaoRequest;
import br.com.comunicador.adapter.in.http.controller.response.ComunicacaoResponse;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-15T14:02:11-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ComunicacaoRequestMapperImpl implements ComunicacaoRequestMapper {

    @Override
    public Comunicacao map(AgendarComunicacaoRequest source) {
        if ( source == null ) {
            return null;
        }

        LocalDateTime dataAgendamento = null;
        TipoComunicacao tipoComunicacao = null;
        String destinatario = null;
        String mensagem = null;

        dataAgendamento = source.getDataAgendamento();
        tipoComunicacao = source.getTipoComunicacao();
        destinatario = source.getDestinatario();
        mensagem = source.getMensagem();

        Long id = null;
        StatusComunicacao status = null;

        Comunicacao comunicacao = new Comunicacao( id, dataAgendamento, tipoComunicacao, destinatario, mensagem, status );

        return comunicacao;
    }

    @Override
    public ComunicacaoResponse map(Comunicacao source) {
        if ( source == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime dataAgendamento = null;
        TipoComunicacao tipoComunicacao = null;
        String destinatario = null;
        String mensagem = null;
        StatusComunicacao status = null;

        id = source.getId();
        dataAgendamento = source.getDataAgendamento();
        tipoComunicacao = source.getTipoComunicacao();
        destinatario = source.getDestinatario();
        mensagem = source.getMensagem();
        status = source.getStatus();

        ComunicacaoResponse comunicacaoResponse = new ComunicacaoResponse( id, dataAgendamento, tipoComunicacao, destinatario, mensagem, status );

        return comunicacaoResponse;
    }
}
