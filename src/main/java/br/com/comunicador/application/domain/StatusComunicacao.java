package br.com.comunicador.application.domain;

public enum StatusComunicacao {

    AGENDADA, CANCELADA, ENVIADA;

    public boolean isAgendada(){
        return equals(AGENDADA);
    }
}
