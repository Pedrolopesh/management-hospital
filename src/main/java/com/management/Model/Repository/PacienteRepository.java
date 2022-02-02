package com.management.Model.Repository;

import com.management.Model.Entities.PacienteEntitie;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<PacienteEntitie, Integer> {
}
