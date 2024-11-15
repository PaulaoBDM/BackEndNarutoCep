package com.cep.cep.services;

import com.cep.cep.entities.Login;
import com.cep.cep.repositories.LoginRepository;
import com.cep.cep.utils.CPFUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login cadastrarUsuario(Login login) {
        if (!CPFUtils.validarCPF(login.getDsCpf())) {
            throw new RuntimeException("CPF inválido!");
        }
        Login usuarioExistente = loginRepository.findByDsCpf(login.getDsCpf());
        if (usuarioExistente != null) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        return loginRepository.save(login);
    }

    public String autenticar(Login login) {

        if (!CPFUtils.validarCPF(login.getDsCpf())) {
            throw new RuntimeException("CPF inválido!");
        }
        Login usuario = loginRepository.findByDsCpf(login.getDsCpf());
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        if (!usuario.getDsSenha().equals(login.getDsSenha())) {
            throw new RuntimeException("Senha incorreta!");
        }

        return "Login bem-sucedido!";
    }
}
