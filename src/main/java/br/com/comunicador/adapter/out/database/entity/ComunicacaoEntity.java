package br.com.comunicador.adapter.out.database.entity;


import br.com.comunicador.application.domain.StatusComunicacao;
import br.com.comunicador.application.domain.TipoComunicacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comunicacao")
public class ComunicacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDateTime dataAgendamento;
    @Enumerated(EnumType.STRING)
    private TipoComunicacao tipoComunicacao;

    private String destinatario;
    @Enumerated(EnumType.STRING)
    private StatusComunicacao status;

    private String mensagem;


    @Override
    public String toString() {
        return "ComunicacaoEntity{" +
                "id=" + id +
                ", dataAgendamento=" + dataAgendamento +
                ", tipoComunicacao=" + tipoComunicacao +
                ", destinatario='" + destinatario + '\'' +
                ", status=" + status +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
