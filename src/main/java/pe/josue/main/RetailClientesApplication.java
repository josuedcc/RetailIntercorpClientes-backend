package pe.josue.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pe.josue.controller","pe.josue.service","pe.josue.config"})
public class RetailClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailClientesApplication.class, args);
	}

}
