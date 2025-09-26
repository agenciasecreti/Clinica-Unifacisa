package br.edu.unifacisa.clinica_api.repository.consulta;

import br.edu.unifacisa.clinica_api.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}
