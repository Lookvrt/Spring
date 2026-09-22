package com.example.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.service.EstudianteService;

@RestController
public class EstudianteController {

    private EstudianteService service;
    public EstudianteController(EstudianteService estudianteService) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio(){
        return "Inicio";
    }
}
