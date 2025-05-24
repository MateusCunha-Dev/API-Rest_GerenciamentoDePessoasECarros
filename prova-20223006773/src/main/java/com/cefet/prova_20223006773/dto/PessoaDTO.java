package com.cefet.prova_20223006773.dto;

import com.cefet.prova_20223006773.entities.Pessoa;

public class PessoaDTO {
    private Long id;
    private String nome;
    private String cpf;
    
    public PessoaDTO(){
    };

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
