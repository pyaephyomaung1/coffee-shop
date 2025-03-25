package com.example.coffee_shop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.coffee_shop.dao.CustomerDao;
import com.example.coffee_shop.model.Customer;
import com.example.coffee_shop.model.Role;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeShopApplication {
	private final CustomerDao customerDao;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}

	@Bean
	@Transactional
	// @Profile("dev")
	public ApplicationRunner init(){
		return args -> {
			// Add some customers
			Customer admin = new Customer("John Doe","admin", passwordEncoder.encode("12345"), "admin@gmail.com");
			Customer user = new Customer("Bob", "bob", passwordEncoder.encode("12345"), "bob@gmail.com");

			Role adminRole = new Role("ROLE_ADMIN");
			Role userRole = new Role("ROLE_USER");

			admin.addRole(adminRole);
			user.addRole(userRole);

			customerDao.save(admin);
			customerDao.save(user);

	};
}

}
