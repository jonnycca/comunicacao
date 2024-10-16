package br.com.comunicador.application.service;

import br.com.comunicador.BuilderObjectsTests;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.exception.ComunicacaoStatusInvalidoException;
import br.com.comunicador.application.ports.out.persistence.PersistirComunicacaoPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ComunicacaoPortImplTest {


    @Mock
    private PersistirComunicacaoPort persistirComunicacao;

    @InjectMocks
    private ComunicacaoPortImpl comunicacaoPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveComunicarComSucesso() {
        Comunicacao comunicacao = BuilderObjectsTests.buildComunicacao();
        when(persistirComunicacao.salvar(comunicacao)).thenReturn(comunicacao);

        Comunicacao resultado = comunicacaoPort.comunicar(comunicacao);

        assertEquals(comunicacao, resultado);
        verify(persistirComunicacao, times(1)).salvar(comunicacao);
    }

    @Test
    void deveConsultarComSucesso() {
        Long id = 1L;
        Comunicacao comunicacao = BuilderObjectsTests.buildComunicacao();
        when(persistirComunicacao.consultar(id)).thenReturn(comunicacao);

        Comunicacao resultado = comunicacaoPort.consultar(id);

        assertEquals(comunicacao, resultado);
        verify(persistirComunicacao, times(1)).consultar(id);
    }

    @Test
    void deveCancelarComSucesso() {
        Long id = 1L;
        Comunicacao comunicacao = BuilderObjectsTests.buildComunicacao();
        comunicacao.setStatusAgendada();
        when(persistirComunicacao.consultar(id)).thenReturn(comunicacao);
        when(persistirComunicacao.salvar(comunicacao)).thenReturn(comunicacao);

        Comunicacao resultado = comunicacaoPort.cancelar(id);

        assertEquals(comunicacao, resultado);
        verify(persistirComunicacao, times(1)).consultar(id);
        verify(persistirComunicacao, times(1)).salvar(comunicacao);
    }

    @Test
    void deveLancarExcecaoAoCancelarComunicacaoNaoAgendada() {
        Long id = 1L;
        Comunicacao comunicacao = BuilderObjectsTests.buildComunicacao();
        comunicacao.setStatusCancelada();
        when(persistirComunicacao.consultar(id)).thenReturn(comunicacao);

        assertThrows(ComunicacaoStatusInvalidoException.class, () -> {
            comunicacaoPort.cancelar(id);
        });
        verify(persistirComunicacao, times(1)).consultar(id);
        verify(persistirComunicacao, never()).salvar(any());
    }
}