package com.cefet.prova_20223006773.dto;

import com.cefet.prova_20223006773.entities.Carro;

public class CarroDTO {
    private Long id;
    private String placa;
    private String nomePessoa;
    private String cpfPessoa;

    public CarroDTO(){
    }

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.nomePessoa = carro.getPessoa().getNome();
        this.cpfPessoa = carro.getPessoa().getCpf();
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }
}
