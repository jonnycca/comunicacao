package br.com.comunicador.adapter.out.kafka.producer.mapper;

import br.com.comunicador.application.domain.Comunicacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComunicacaoEventMapper {

        @Mapping(expression = "java(source.getId().toString())", target = "id")
        @Mapping(expression = "java(source.getDataAgendamento().toString())", target = "dataAgendamento")
        @Mapping(expression = "java(source.getTipoComunicacao().toString())", target = "tipoComunicacao")
        br.com.kafka.comunicador.event.ComunicacaoEvent map(Comunicacao source);
}
