package ma.ouss.accountservice.web;


import ma.ouss.accountservice.clients.CustomerRestClient;
import ma.ouss.accountservice.entities.BankAccount;
import ma.ouss.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> accounts = bankAccountRepository.findAll();
        accounts.forEach(c->{
            c.setCustomer(customerRestClient.findCustomerById(c.getCustomerId()));
        });
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).orElse(null);
        assert bankAccount != null;
        bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
}
