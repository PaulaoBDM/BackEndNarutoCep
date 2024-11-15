package com.cep.cep.services;

import com.cep.cep.entities.Cep;
import com.cep.cep.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CepService {
    @Autowired
    private CepRepository cepRepository;

    public Cep findByDsCep(String cep) {
        Optional<Cep> cepOptional = cepRepository.findByDsCep(cep);
        return cepOptional.orElse(null);
    }

    public List<Cep> findAll() {
        return cepRepository.findAll();
    }

    public Cep gravarCep(Cep cep) {
        if (cepRepository.findByDsCep(cep.getDsCep()).isPresent()) {
            throw new RuntimeException("O CEP já está cadastrado!");
        }
        return cepRepository.save(cep);
    }

    public void deletarPorCep(String cep) {
        Optional<Cep> cepExistente = cepRepository.findByDsCep(cep);
        if (cepExistente.isPresent()) {
            cepRepository.delete(cepExistente.get());
        } else {
            System.out.println("CEP não encontrado");
        }
    }
    public Cep update(String dsCep, Cep cep) {
        Optional<Cep> existente = cepRepository.findByDsCep(dsCep);
        if (existente.isPresent()) {
            Cep cepAtualizado = existente.get();
            cepAtualizado.setDsLogradouro(cep.getDsLogradouro());
            cepAtualizado.setDsBairro(cep.getDsBairro());
            cepAtualizado.setDsEstado(cep.getDsEstado());
            cepAtualizado.setNrDdd(cep.getNrDdd());

            return cepRepository.save(cepAtualizado);
        }
        return null;
    }
    public boolean isCepAlreadyRegistered(String dsCep) {
        return cepRepository.findByDsCep(dsCep).isPresent();
    }
}
