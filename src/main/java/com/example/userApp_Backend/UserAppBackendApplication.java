package com.example.userApp_Backend;

import java.util.stream.Stream;

import com.example.userApp_Backend.model.User;
import com.example.userApp_Backend.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAppBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init (UserRepository userRepository){
		return args ->{
			Stream.of("John","Julie","Jeniffer","Helan","Rachel").forEach(name->{
				User user= new User(name,name.toLowerCase()+"@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
