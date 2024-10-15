package br.com.comunicador.adapter.in.http.controller.mapper;

import br.com.comunicador.adapter.in.http.controller.request.AgendarComunicacaoRequest;
import br.com.comunicador.application.domain.Comunicacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComunicacaoRequestMapper {

    Comunicacao map(AgendarComunicacaoRequest request);
}
