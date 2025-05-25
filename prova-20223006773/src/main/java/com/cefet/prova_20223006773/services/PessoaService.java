package com.cefet.prova_20223006773.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223006773.dto.CarroDTO;
import com.cefet.prova_20223006773.dto.PessoaDTO;
import com.cefet.prova_20223006773.entities.Carro;
import com.cefet.prova_20223006773.entities.Pessoa;
import com.cefet.prova_20223006773.repositories.CarroRepository;
import com.cefet.prova_20223006773.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CarroRepository carroRepository;

    //buscar pessoa
    public List<PessoaDTO> findAll(){
        List<Pessoa> listaPessoa = pessoaRepository.findAll();
        return listaPessoa.stream().map(PessoaDTO::new).toList();   
    }

    // Buscar por ID
    public PessoaDTO findById(Long id) {
    Pessoa pessoa = pessoaRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado com ID: " + id));
    return new PessoaDTO(pessoa);
    }


    // Inserir Pessoa
    public PessoaDTO insert(PessoaDTO pessoaDTO) {
    Pessoa pessoa = new Pessoa();
    pessoa.setNome(pessoaDTO.getNome());
    pessoa.setCpf(pessoaDTO.getCpf());
    Pessoa pessoaSalvo = pessoaRepository.save(pessoa);
    return new PessoaDTO(pessoaSalvo);
    }


    // Atualizar Dados de Pessoa
    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
    Pessoa pessoa = pessoaRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado com ID: " + id));
    pessoa.setNome(pessoaDTO.getNome());
    pessoa.setCpf(pessoaDTO.getCpf());
    Pessoa pessoaAtualizado = pessoaRepository.save(pessoa);
    return new PessoaDTO(pessoaAtualizado);
    }


    // remove Pessoa pelo seu id
    public void delete(Long id) {
    System.out.println("Tentando deletar pessoa com ID: " + id); // Log adicional
    if (!pessoaRepository.existsById(id)) {
        throw new EntityNotFoundException("Pessoa não encontrado com ID: " + id);
    }
    pessoaRepository.deleteById(id);
    System.out.println("Pessoa deletada com sucesso"); 
    }


    //lista os carros associados a Pessoa pelo seu id, ou seja, todos os carros que uma determinada pessoa tem
    public List<CarroDTO> findCarrosByPessoaId(Long pessoaId) {
    Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + pessoaId));
    
    List<Carro> carros = carroRepository.findByPessoaId(pessoaId);
    return carros.stream().map(CarroDTO::new).toList();
}

}
