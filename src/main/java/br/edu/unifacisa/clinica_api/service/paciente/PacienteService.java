package br.edu.unifacisa.clinica_api.service.paciente;

import br.edu.unifacisa.clinica_api.domain.paciente.Paciente;
import br.edu.unifacisa.clinica_api.repository.paciente.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repo;

    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    public Paciente create(Paciente paciente) {
        return repo.save(paciente);
    }

    public List<Paciente> findAll() {
        return repo.findAll();
    }

    public Paciente findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Paciente update(Long id, Paciente body) {
        return repo.findById(id).map(db -> {
            if (body.getNome() != null) {
                db.setNome(body.getNome());
            } else {
                db.setNome(db.getNome());
            }

            if (body.getCpf() != null) {
                db.setCpf(body.getCpf());
            } else {
                db.setCpf(db.getCpf());
            }

            if (body.getTelefone() != null) {
                db.setEmail(body.getEmail());
            } else {
                db.setEmail(db.getEmail());
            }

            if (body.getTelefone() != null) {
                db.setTelefone(body.getTelefone());
            } else {
                db.setTelefone(db.getTelefone());
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
