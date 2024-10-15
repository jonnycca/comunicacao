package br.com.comunicador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ComunicadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunicadorApplication.class, args);
	}

}
