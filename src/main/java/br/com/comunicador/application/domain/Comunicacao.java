package br.com.comunicador.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
public class Comunicacao {

    private Long id;
    private LocalDateTime dataAgendamento;
    private TipoComunicacao tipoComunicacao;

    private String destinatario; //todo: verificar se muda para outra classe

    private String mensagem;
    private StatusComunicacao status;

    public void setStatusAgendada(){
        this.status = StatusComunicacao.AGENDADA;
    }

    public void setStatusCancelada(){
        this.status = StatusComunicacao.CANCELADA;
    }

    public void setStatusEnviada(){
        this.status = StatusComunicacao.ENVIADA;
    }

    @Override
    public String toString() {
        return "Comunicacao{" +
                "id=" + id +
                ", dataAgendamento=" + dataAgendamento +
                ", tipoComunicacao=" + tipoComunicacao +
                ", destinatario='" + destinatario + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", status=" + status +
                '}';
    }
}
