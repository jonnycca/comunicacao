package br.com.comunicador.adapter.out.database.mapper;

import br.com.comunicador.adapter.out.database.entity.ComunicacaoEntity;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-15T13:57:31-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ComunicacaoEntityMapperImpl implements ComunicacaoEntityMapper {

    @Override
    public ComunicacaoEntity map(Comunicacao source) {
        if ( source == null ) {
            return null;
        }

        ComunicacaoEntity comunicacaoEntity = new ComunicacaoEntity();

        comunicacaoEntity.setId( source.getId() );
        comunicacaoEntity.setDataAgendamento( source.getDataAgendamento() );
        comunicacaoEntity.setTipoComunicacao( source.getTipoComunicacao() );
        comunicacaoEntity.setDestinatario( source.getDestinatario() );
        comunicacaoEntity.setStatus( source.getStatus() );
        comunicacaoEntity.setMensagem( source.getMensagem() );

        return comunicacaoEntity;
    }

    @Override
    public Comunicacao map(ComunicacaoEntity source) {
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

        Comunicacao comunicacao = new Comunicacao( id, dataAgendamento, tipoComunicacao, destinatario, mensagem, status );

        return comunicacao;
    }
}
