package br.com.comunicador.adapter.in.http.controller.request;

import br.com.comunicador.application.domain.TipoComunicacao;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
