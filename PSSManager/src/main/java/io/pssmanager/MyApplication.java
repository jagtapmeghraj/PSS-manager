package io.pssmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyApplication {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	
	@GetMapping("/")
  	public String hello() {
    	return "Hello world! from Jar App";
  	}
	
	@GetMapping("/error")
  	public String error() {
    	return "There is an error in runtime";
  	}
	

}
