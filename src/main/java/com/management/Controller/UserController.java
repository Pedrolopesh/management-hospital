package com.management.Controller;

import com.management.Model.Entities.PacienteEntitie;
import com.management.Model.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Object registrarPaciente(PacienteEntitie pacienteEntitieParam){
        return this.pacienteRepository.save(pacienteEntitieParam);
    }
}
