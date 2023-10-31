package com.biblioteca.saleh.pessoa.service;

import com.biblioteca.saleh.pessoa.dto.PessoaDTO;
import com.biblioteca.saleh.pessoa.form.PessoaForm;
import com.biblioteca.saleh.pessoa.model.Pessoa;
import com.biblioteca.saleh.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public ResponseEntity<List<PessoaDTO>> listarPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<PessoaDTO> listarPessoa(Long idPessoa){
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        return ResponseEntity.ok(PessoaDTO.fromPessoa(pessoa));
    }

    public ResponseEntity<PessoaDTO> cadastrarPessoa(PessoaForm formulario){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(formulario.getNome());
        pessoa.setEndereco(formulario.getEndereco());
        pessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(PessoaDTO.fromPessoa(pessoa));
    }

    public ResponseEntity<PessoaDTO> atualizarPessoa(Long idPessoa, PessoaForm formulario){
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        pessoa.setNome(formulario.getNome());
        pessoa.setEndereco(formulario.getEndereco());
        pessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(PessoaDTO.fromPessoa(pessoa));
    }

    public ResponseEntity<Void> deletePessoa(Long idPessoa){
        Pessoa pessoa = this.buscarPessoa(idPessoa);
        this.pessoaRepository.deleteById(pessoa.getId());
        return ResponseEntity.ok().build();
    }

    public Pessoa buscarPessoa(Long idPessoa){
        Optional<Pessoa> optionalPessoa = this.pessoaRepository.findById(idPessoa);
        return optionalPessoa.get();
    }
}
