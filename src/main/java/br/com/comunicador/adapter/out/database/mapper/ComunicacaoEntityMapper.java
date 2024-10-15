package br.com.comunicador.adapter.out.database.mapper;

import br.com.comunicador.adapter.out.database.entity.ComunicacaoEntity;
import br.com.comunicador.application.domain.Comunicacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComunicacaoEntityMapper {

    ComunicacaoEntity map(Comunicacao source);

    Comunicacao map(ComunicacaoEntity source);

    List<Comunicacao> mapComunicacaoList(List<ComunicacaoEntity> source);

    List<ComunicacaoEntity> mapComunicacaoEntityList(List<Comunicacao> source);

}
