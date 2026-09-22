package com.example.spring.repository;

import com.example.spring.model.EstudianteModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EstudianteRepository {
    private List<EstudianteModel> estudiantes = new ArrayList<>(List.of(
            new EstudianteModel(1, "Juan", "Perez", 15),
            new EstudianteModel(2, "Pablo", "Castro", 20),
            new EstudianteModel(3, "Kross", "Lara", 18)
    ));

    public void guardarEstudiante(EstudianteModel estudiante) {
        estudiantes.add(estudiante);
    }

    public List<EstudianteModel> obtenerEstudiantes() {
        return estudiantes;
    }

    public Optional<EstudianteModel> buscarPorId(int id){
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst();
    }
}
