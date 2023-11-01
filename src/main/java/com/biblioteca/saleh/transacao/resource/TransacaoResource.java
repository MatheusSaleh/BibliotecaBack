package com.biblioteca.saleh.transacao.resource;

import com.biblioteca.saleh.transacao.dto.TransacaoDTO;
import com.biblioteca.saleh.transacao.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/transacoes")
@RestController
public class TransacaoResource {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> listarTransacoes(){
        return this.transacaoService.listarTransacoes();
    }
}
