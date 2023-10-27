package com.biblioteca.saleh.pessoa.resource;

import com.biblioteca.saleh.pessoa.dto.PessoaDTO;
import com.biblioteca.saleh.pessoa.form.PessoaForm;
import com.biblioteca.saleh.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@RestController
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas(){
        return this.pessoaService.listarPessoas();
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> listarPessoa(@PathVariable Long idPessoa){
        return this.pessoaService.listarPessoa(idPessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaForm formulario){
        return this.pessoaService.cadastrarPessoa(formulario);
    }
}
