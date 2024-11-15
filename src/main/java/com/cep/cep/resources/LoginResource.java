package com.cep.cep.resources;

import com.cep.cep.entities.Login;
import com.cep.cep.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrarUsuario(@RequestBody Login login) {
        Map<String, Object> response = new HashMap<>();
        try {
            Login novoUsuario = loginService.cadastrarUsuario(login);
            response.put("status", "success");
            response.put("message", "Usuário cadastrado com sucesso!");
            response.put("user", novoUsuario);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity<Map<String, String>> autenticar(@RequestBody Login login) {
        Map<String, String> response = new HashMap<>();
        try {
            String mensagem = loginService.autenticar(login);
            response.put("status", "success");
            response.put("message", mensagem);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
