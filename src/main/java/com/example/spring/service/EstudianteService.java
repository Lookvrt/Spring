package com.example.spring.service;

import com.example.spring.model.EstudianteModel;
import org.springframework.stereotype.Service;
import com.example.spring.repository.EstudianteRepository;
import java.util.List;

@Service
public class EstudianteService {
    private EstudianteRepository repository;
    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public EstudianteModel guardarEstudiantes(EstudianteModel estudiantes){
        repository.guardarEstudiante(estudiantes);
        return estudiantes;
    }

    public List<EstudianteModel> listarEstudiantes(){
        return repository.obtenerEstudiantes();
    }

    public int autoID(){
        List<EstudianteModel> estudiantes = listarEstudiantes();
        if(estudiantes.isEmpty()){
            return 1;
        }

        int id = 0;
        for(EstudianteModel e : estudiantes){
            if(e.getId() > id){
                id = e.getId();
            }
        }
        return id + 1;
    }
}

