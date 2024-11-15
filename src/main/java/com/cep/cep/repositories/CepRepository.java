package com.cep.cep.repositories;

import com.cep.cep.entities.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepository extends JpaRepository<Cep, Integer> {
    Optional<Cep> findByDsCep(String dsCep);
}
