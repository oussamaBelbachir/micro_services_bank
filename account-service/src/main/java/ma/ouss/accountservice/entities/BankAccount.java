package ma.ouss.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ouss.accountservice.enums.AccountType;
import ma.ouss.accountservice.model.Customer;

import java.time.LocalDate;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
