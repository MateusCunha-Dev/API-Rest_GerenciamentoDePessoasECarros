package com.cefet.prova_20223006773.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.prova_20223006773.dto.CarroDTO;
import com.cefet.prova_20223006773.dto.PessoaDTO;
import com.cefet.prova_20223006773.services.PessoaService;



@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
    List<PessoaDTO> pessoaDTOs = pessoaService.findAll();
    return ResponseEntity.ok(pessoaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
    PessoaDTO pessoaDTO = pessoaService.findById(id);
    return ResponseEntity.ok(pessoaDTO);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
    PessoaDTO novaPessoa = pessoaService.insert(pessoaDTO);
    return ResponseEntity.status(201).body(novaPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
    PessoaDTO pessoaAtualizado = pessoaService.update(id, pessoaDTO);
    return ResponseEntity.ok(pessoaAtualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    pessoaService.delete(id);
    return ResponseEntity.noContent().build(); // Retorna HTTP 204 (No Content)
}

    @GetMapping("/{id}/carros")
    public ResponseEntity<List<CarroDTO>> listarCarrosPorPessoa(@PathVariable Long id) {
    List<CarroDTO> carros = pessoaService.findCarrosByPessoaId(id);
    return ResponseEntity.ok(carros);
}
}
