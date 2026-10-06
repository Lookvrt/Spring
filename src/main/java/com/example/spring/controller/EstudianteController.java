package com.example.spring.controller;

import com.example.spring.model.EstudianteModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import com.example.spring.service.EstudianteService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteController {

    private final EstudianteService service;
    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("estudiantes", service.listarEstudiantes());
        return "listaEstudiantes";
    }
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("nuevoEstudiante", new EstudianteModel());
        return "estudianteForm";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute("nuevoEstudiante") EstudianteModel estudiante){
        service.guardarEstudiantes(estudiante);
        return "redirect:/";
    }
}
