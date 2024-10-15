package br.com.comunicador.adapter.in.http.controller.response;

import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComunicacaoResponse {

    private Long id;
    private LocalDateTime dataAgendamento;
    private TipoComunicacao tipoComunicacao;

    private String destinatario; //todo: verificar se muda para outra classe

    private String mensagem;
    private StatusComunicacao status;
}
