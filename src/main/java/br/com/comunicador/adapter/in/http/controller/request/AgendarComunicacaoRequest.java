package br.com.comunicador.adapter.in.http.controller.request;

import br.com.comunicador.application.domain.TipoComunicacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
public class AgendarComunicacaoRequest {

    private LocalDateTime dataAgendamento;
    private TipoComunicacao tipoComunicacao;

    @NotBlank
    private String destinatario;
    @NotBlank
    private String mensagem;

}
