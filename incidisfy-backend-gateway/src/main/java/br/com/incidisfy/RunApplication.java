package br.com.incidisfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RunApplication {
	
	/**
	 * Bootstrap
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}

}
