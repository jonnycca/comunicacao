package br.com.comunicador.adapter.in.http.controller;

import br.com.comunicador.adapter.in.http.controller.mapper.ComunicacaoRequestMapper;
import br.com.comunicador.adapter.in.http.controller.request.AgendarComunicacaoRequest;
import br.com.comunicador.application.ports.in.ComunicacaoPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comunicacao")
@Validated
public class ComunicacaoController {

    private ComunicacaoPort comunicacaoPort;
    private ComunicacaoRequestMapper mapper;

    @Autowired
    public ComunicacaoController(ComunicacaoPort comunicacaoPort, ComunicacaoRequestMapper mapper) {
        this.comunicacaoPort = comunicacaoPort;
        this.mapper = mapper;
    }


    @PostMapping("/agendar")
    public void agendarComunicacao(@Valid @RequestBody AgendarComunicacaoRequest agendarComunicacao) {
        comunicacaoPort.comunicar(mapper.map(agendarComunicacao));
    }
}
