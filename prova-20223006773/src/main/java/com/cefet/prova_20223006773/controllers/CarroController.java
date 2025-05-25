package com.cefet.prova_20223006773.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.cefet.prova_20223006773.services.CarroService;


@RestController
@RequestMapping(value = "/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;
    
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
    List<CarroDTO> carroDTOs = carroService.findAll();
    return ResponseEntity.ok(carroDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
    CarroDTO carroDTO = carroService.findById(id);
    return ResponseEntity.ok(carroDTO);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> create(@RequestBody CarroDTO carroDTO) {
    CarroDTO novoCarro = carroService.insert(carroDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> update(
    @PathVariable Long id,
    @RequestBody CarroDTO carroDTO
    ) {
    CarroDTO carroAtualizado = carroService.update(id, carroDTO);
    return ResponseEntity.ok(carroAtualizado);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    carroService.delete(id);
    return ResponseEntity.noContent().build(); 
}
    

}
