package com.biblioteca.saleh.livro.service;

import com.biblioteca.saleh.exception.handler.ObjetoNaoEncontradoException;
import com.biblioteca.saleh.livro.dto.LivroCountDTO;
import com.biblioteca.saleh.livro.dto.LivroDTO;
import com.biblioteca.saleh.livro.form.EmprestaDevolveLivroForm;
import com.biblioteca.saleh.livro.form.LivroForm;
import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.livro.repository.LivroRepository;
import com.biblioteca.saleh.transacao.enums.TipoTransacao;
import com.biblioteca.saleh.transacao.model.Transacao;
import com.biblioteca.saleh.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    public ResponseEntity<List<LivroDTO>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }

    public ResponseEntity<LivroDTO> listarLivro(Long idLivro){
        Livro livro = this.buscarLivro(idLivro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<LivroDTO> cadastrarLivro(LivroForm formulario){
        Livro livro = new Livro();
        livro.setNome(formulario.getNome());
        livro.setEditora(formulario.getEditora());
        livro.setGenero(formulario.getGenero());
        livro.setAutor(formulario.getAutor());
        livro.setPessoaEmprestado(formulario.getPessoaEmprestado());
        livro.setQuantidadeEmprestada(formulario.getQuantidadeEmprestada());
        livro.setDataDoUltimoEmprestimo(formulario.getDataDoUltimoEmprestimo());
        livro.setDisponivel(formulario.isDisponivel());
        livro = livroRepository.save(livro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public List<LivroCountDTO> consultarLivrosPorAutorEGenero(){
        return livroRepository.consultaAgrupamento();
    }

    public ResponseEntity<List<LivroDTO>> consultaLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = livroRepository.findByDisponivelTrue();
        return ResponseEntity.ok(LivroDTO.converter(livrosDisponiveis));
    }

    public ResponseEntity<LivroDTO> emprestarLivro(Long livroId, EmprestaDevolveLivroForm formulario){
        Livro livro = this.buscarLivro(livroId);
        livro.setDisponivel(false);
        livro.setPessoaEmprestado(formulario.getPessoaEmprestado());
        livro.setQuantidadeEmprestada(livro.getQuantidadeEmprestada() + 1);
        livroRepository.save(livro);

        Transacao transacao = new Transacao();
        transacao.setData(LocalDate.now());
        transacao.setTipo(TipoTransacao.EMPRESTIMO);
        transacao.setLivro(livro);
        transacaoRepository.save(transacao);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<LivroDTO> devolverLivro(Long livroId){
        Livro livro = this.buscarLivro(livroId);
        livro.setDisponivel(true);
        livroRepository.save(livro);

        Transacao transacao = new Transacao();
        transacao.setData(LocalDate.now());
        transacao.setTipo(TipoTransacao.DEVOLUCAO);
        transacao.setLivro(livro);
        transacaoRepository.save(transacao);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<LivroDTO> atualizarLivro(Long idLivro, LivroForm formulario){
        Livro livro = this.buscarLivro(idLivro);
        livro.setNome(formulario.getNome());
        livro.setEditora(formulario.getEditora());
        livro.setGenero(formulario.getGenero());
        livro.setAutor(formulario.getAutor());
        livro.setPessoaEmprestado(formulario.getPessoaEmprestado());
        livro.setQuantidadeEmprestada(formulario.getQuantidadeEmprestada());
        livro.setDataDoUltimoEmprestimo(formulario.getDataDoUltimoEmprestimo());
        livro = livroRepository.save(livro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<Void> deleteLivro(Long idLivro){
        Livro livro = this.buscarLivro(idLivro);
        this.livroRepository.deleteById(livro.getId());
        return ResponseEntity.ok().build();
    }

    public Livro buscarLivro(Long idLivro){
        Optional<Livro> optionalLivro = this.livroRepository.findById(idLivro);
        if(optionalLivro.isEmpty()){
            throw new ObjetoNaoEncontradoException("Livro com o id"+idLivro+" não encontrado");
        }
        return optionalLivro.get();
    }
}
