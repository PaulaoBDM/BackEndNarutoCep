package com.cep.cep;
import com.cep.cep.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CepApplication {//implements CommandLineRunner {
	@Autowired
	private CepRepository cepRepository;

	public static void main(String[] args) {
		SpringApplication.run(CepApplication.class, args);
	}
}
