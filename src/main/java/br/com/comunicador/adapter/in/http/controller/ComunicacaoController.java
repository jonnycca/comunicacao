package br.com.comunicador.adapter.in.http.controller;

import br.com.comunicador.adapter.in.http.controller.mapper.ComunicacaoRequestMapper;
import br.com.comunicador.adapter.in.http.controller.request.AgendarComunicacaoRequest;
import br.com.comunicador.adapter.in.http.controller.response.ComunicacaoResponse;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.ports.in.ComunicacaoPort;
//import jakarta.validation.Valid;
import jdk.javadoc.doclet.Taglet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/comunicacao")
@Validated
public class ComunicacaoController {

    private final ComunicacaoPort comunicacaoPort;
    private final ComunicacaoRequestMapper mapper;

    @Autowired
    public ComunicacaoController(ComunicacaoPort comunicacaoPort, ComunicacaoRequestMapper mapper) {
        this.comunicacaoPort = comunicacaoPort;
        this.mapper = mapper;
    }


    @PostMapping("/agendar")
    public ResponseEntity<ComunicacaoResponse> agendarComunicacao(@Valid @RequestBody AgendarComunicacaoRequest agendarComunicacao) {

        Comunicacao comunicacaoSava = comunicacaoPort.comunicar(mapper.map(agendarComunicacao));

        return ResponseEntity.created(URI.create("/comunicacao/agendar")).body(mapper.map(comunicacaoSava));
    }

    @GetMapping("/{idComunicacao}")
    public ResponseEntity<ComunicacaoResponse> consultarComunicacao(@PathVariable Long idComunicacao){

        Comunicacao comunicacaoConsultada = comunicacaoPort.consultar(idComunicacao);

        return ResponseEntity.ok().body(mapper.map(comunicacaoConsultada));
    }

    @PatchMapping("/cancelar/{idComunicacao}")
    public ResponseEntity<ComunicacaoResponse> cancelarComunicacao(@PathVariable Long idComunicacao){
        Comunicacao comunicacaoCancelada = comunicacaoPort.cancelar(idComunicacao);

        return ResponseEntity.ok().body(mapper.map(comunicacaoCancelada));
    }
}
