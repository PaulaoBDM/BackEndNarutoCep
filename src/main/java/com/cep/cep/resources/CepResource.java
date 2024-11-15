package com.cep.cep.resources;

import com.cep.cep.entities.Cep;
import com.cep.cep.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/principal")
public class CepResource {

    @Autowired
    private CepService cepService;

    @GetMapping
    public List<Cep> listarTodos() {
        return cepService.findAll();
    }

    @GetMapping("/detalhes-cep/{cep}")
    public ResponseEntity<Cep> listarPorCep(@PathVariable String cep) {
        Cep cepEncontrado = cepService.findByDsCep(cep);
        if (cepEncontrado != null) {
            return ResponseEntity.ok(cepEncontrado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> gravarCep(@RequestBody Cep cep) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cep novoCep = cepService.gravarCep(cep);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(novoCep.getId()).toUri();
            response.put("status", "success");
            response.put("message", "CEP cadastrado com sucesso!");
            response.put("cep", novoCep);
            return ResponseEntity.created(uri).body(response);
        } catch (RuntimeException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping(value = "/{cep}")
    public ResponseEntity<Void> deletar(@PathVariable String cep) {
        cepService.deletarPorCep(cep);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/alterar-cep/{dsCep}")
    public ResponseEntity<Cep> atualizar(@PathVariable String dsCep,
                                         @RequestBody Cep cep) {
        Cep alterado = cepService.update(dsCep, cep);
        if (alterado != null) {
            return ResponseEntity.ok().body(alterado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
