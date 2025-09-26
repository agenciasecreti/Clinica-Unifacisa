package br.edu.unifacisa.clinica_api.service.consulta;

import br.edu.unifacisa.clinica_api.domain.consulta.Consulta;
import br.edu.unifacisa.clinica_api.repository.consulta.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repo;

    public ConsultaService(ConsultaRepository repo) {
        this.repo = repo;
    }

    public Consulta create(Consulta consulta) {
        return repo.save(consulta);
    }

    public List<Consulta> findAll() {
        return repo.findAll();
    }

    public Consulta findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Consulta update(Long id, Consulta body) {
        return repo.findById(id).map(db -> {

            if (body.getPaciente() != null) {
                db.setPaciente(body.getPaciente());
            } else {
                db.setPaciente(db.getPaciente());
            }

            if (body.getData_consulta() != null) {
                db.setData_consulta(body.getData_consulta());
            } else {
                db.setData_consulta(db.getData_consulta());
            }

            if (body.getMotivo() != null) {
                db.setMotivo(body.getMotivo());
            } else {
                db.setMotivo(db.getMotivo());
            }
            return repo.save(db);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
