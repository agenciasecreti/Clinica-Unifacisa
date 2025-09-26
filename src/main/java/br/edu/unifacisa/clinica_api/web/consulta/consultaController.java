package br.edu.unifacisa.clinica_api.web.consulta;

import br.edu.unifacisa.clinica_api.domain.consulta.Consulta;
import br.edu.unifacisa.clinica_api.service.consulta.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class consultaController {

    private final ConsultaService service;

    public consultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consulta> create(@RequestBody Consulta body){
        var saved = service.create(body);
        return ResponseEntity.created(URI.create("/api/consultas" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Consulta> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> get(@PathVariable Long id){
        var found = service.findById(id);
        return (found != null) ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta body){
        var updated = service.update(id, body);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consulta> delete(@PathVariable Long id){
        return service.delete(id) ?  ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
