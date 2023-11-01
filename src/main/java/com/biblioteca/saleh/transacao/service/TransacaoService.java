package com.biblioteca.saleh.transacao.service;

import com.biblioteca.saleh.transacao.dto.TransacaoDTO;
import com.biblioteca.saleh.transacao.model.Transacao;
import com.biblioteca.saleh.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public ResponseEntity<List<TransacaoDTO>> listarTransacoes(){
        List<Transacao> transacoes = transacaoRepository.findAll();
        return ResponseEntity.ok(TransacaoDTO.converter(transacoes));
    }
}
