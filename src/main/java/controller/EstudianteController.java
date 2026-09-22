package controller;

import model.EstudianteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import service.EstudianteService;

import java.util.List;

@RestController
public class EstudianteController {
    private EstudianteService service;
    public EstudianteController(EstudianteService estudianteService) {
        this.service = service;
    }

    @GetMapping("/inicio")
    public String VerEstudiante(@RequestAttribute EstudianteModel estudiante){
        List<EstudianteModel> e = service.listarEstudiantes();
        return "Estudiantes registrados: " + e;
    }

    @GetMapping("/inicio")
    public String validarEdad(@RequestAttribute EstudianteModel estudiante){
        String edad = service.validarEdad(estudiante.getId());
        return "La edad del estudiante: " + edad;
    }
}
