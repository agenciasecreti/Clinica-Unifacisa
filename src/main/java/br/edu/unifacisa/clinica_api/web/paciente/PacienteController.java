package br.edu.unifacisa.clinica_api.web.paciente;

import br.edu.unifacisa.clinica_api.domain.paciente.Paciente;
import br.edu.unifacisa.clinica_api.service.paciente.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente body){
        var saved = service.create(body);
        return ResponseEntity.created(URI.create("/api/pacientes" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Paciente> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> get(@PathVariable Long id){
        var found = service.findById(id);
        return (found != null) ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente body){
        var updated = service.update(id, body);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> delete(@PathVariable Long id){
        return service.delete(id) ?  ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
