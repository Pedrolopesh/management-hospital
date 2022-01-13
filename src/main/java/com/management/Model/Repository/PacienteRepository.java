package com.management.Model.Repository;

import com.management.Model.Entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}
