package br.com.crud;

import br.com.crud.model.entity.Cliente;
import br.com.crud.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ClientesApplication {

//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository repository){
//		return args -> {
//			Cliente cliente = new Cliente();
//			cliente.setNome("Diego");
//			cliente.setCpf("01899685596");
//			repository.save(cliente);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
