package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.epam.spring.hometask.exceptions.ItemNotFoundException;
import ua.epam.spring.hometask.models.Account;
import ua.epam.spring.hometask.repositories.AccountRepository;

import java.util.Optional;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public Iterable<Account> showAllAccounts() {
        Iterable<Account> accounts = accountRepository.findAll();
        if (!accounts.iterator().hasNext()) {
            throw new ItemNotFoundException("No accounts found.");
        }
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public Account showAllAccounts(@PathVariable("id") Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new ItemNotFoundException("No account found.");
        }
        return account.get();
    }
}
