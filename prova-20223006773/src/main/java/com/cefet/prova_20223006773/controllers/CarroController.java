package com.cefet.prova_20223006773.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    

}
