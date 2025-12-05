package com.example.ExamenOscarMendoza.controller;

import com.example.ExamenOscarMendoza.dto.OrdenDTO;
import com.example.ExamenOscarMendoza.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ordenCompra")
@CrossOrigin(origins = "*")
public class OrdenController {
    private final OrdenService ordenService;


    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }


    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody OrdenDTO dto){
        Map<String, Object> respuesta = OrdenService.OrdenController(dto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        return new ResponseEntity<>(OrdenService.(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Map<String, Object> respuesta = OrdenService.(id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
