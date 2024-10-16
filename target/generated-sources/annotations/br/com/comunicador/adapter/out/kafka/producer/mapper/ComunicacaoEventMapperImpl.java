package br.com.comunicador.adapter.out.kafka.producer.mapper;

import br.com.comunicador.application.domain.Comunicacao;
import br.com.kafka.comunicador.event.ComunicacaoEvent;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-15T22:45:19-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ComunicacaoEventMapperImpl implements ComunicacaoEventMapper {

    @Override
    public ComunicacaoEvent map(Comunicacao source) {
        if ( source == null ) {
            return null;
        }

        ComunicacaoEvent.Builder comunicacaoEvent = ComunicacaoEvent.newBuilder();

        comunicacaoEvent.setDestinatario( source.getDestinatario() );
        comunicacaoEvent.setMensagem( source.getMensagem() );

        comunicacaoEvent.setId( source.getId().toString() );
        comunicacaoEvent.setDataAgendamento( source.getDataAgendamento().toString() );
        comunicacaoEvent.setTipoComunicacao( source.getTipoComunicacao().toString() );

        return comunicacaoEvent.build();
    }
}
