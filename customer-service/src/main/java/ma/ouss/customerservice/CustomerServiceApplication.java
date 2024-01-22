package ma.ouss.customerservice;

import ma.ouss.customerservice.entities.Customer;
import ma.ouss.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {

			customerRepository.save(new Customer(null,"oussman","blbachar","ouss@gmail.com"));
			customerRepository.save(new Customer(null,"yassin","manat","yass@gmail.com"));
			customerRepository.save(new Customer(null,"ali","nakati","ali@gmail.com"));
			System.out.println("helloooo");
		};
	}

}
