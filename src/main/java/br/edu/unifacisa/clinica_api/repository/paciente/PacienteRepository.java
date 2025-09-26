package br.edu.unifacisa.clinica_api.repository.paciente;

import br.edu.unifacisa.clinica_api.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}
