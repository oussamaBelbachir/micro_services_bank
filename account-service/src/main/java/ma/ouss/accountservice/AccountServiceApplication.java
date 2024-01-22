package ma.ouss.accountservice;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import ma.ouss.accountservice.entities.BankAccount;
import ma.ouss.accountservice.enums.AccountType;
import ma.ouss.accountservice.model.Customer;
import ma.ouss.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
				bankAccountRepository.save(
				new BankAccount(UUID.randomUUID().toString(),Math.random()*99999,LocalDate.now(),	"MAD",	AccountType.SAVING_ACCOUNT,null,Long.valueOf(2))
				);

			bankAccountRepository.save(
					new BankAccount(UUID.randomUUID().toString(),Math.random()*99999,LocalDate.now(),	"MAD",	AccountType.SAVING_ACCOUNT,null,Long.valueOf(1))
			);

			bankAccountRepository.save(
					new BankAccount(UUID.randomUUID().toString(),Math.random()*99999,LocalDate.now(),	"MAD",	AccountType.SAVING_ACCOUNT,null,Long.valueOf(3))
			);
			System.out.println("Yeees");

		};
	}

}
