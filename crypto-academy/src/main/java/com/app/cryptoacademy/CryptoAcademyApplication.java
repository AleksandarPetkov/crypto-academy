package com.app.cryptoacademy;
import com.app.cryptoacademy.domain.AppUser;
import com.app.cryptoacademy.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CryptoAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoAcademyApplication.class, args);
	}
}
