package service;

import model.EstudianteModel;
import org.springframework.stereotype.Service;
import repository.EstudianteRepository;
import java.util.List;

@Service
public class EstudianteService {
    private EstudianteRepository repository;
    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public EstudianteModel guardarEstudiantes(EstudianteModel estudiantes){
        repository.guardarEstudiante(estudiantes);
        return estudiantes; /* Como no agregamos estudiantes no es necesario el metodo*/
    }

    public List<EstudianteModel> listarEstudiantes(){
        return repository.obtenerEstudiantes();
    }

    public String validarEdad(int id){
        return repository.buscarPorId(id)
             .map(estudiante -> estudiante.getEdad()<18 ? "Eres mayor de edad" : "Eres menor de edad")
             .orElse("Id de estudiante no existe");
    }
}

