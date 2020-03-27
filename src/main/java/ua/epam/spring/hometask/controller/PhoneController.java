package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.epam.spring.hometask.exceptions.ItemNotFoundException;
import ua.epam.spring.hometask.models.Phone;
import ua.epam.spring.hometask.repositories.PhoneRepository;

import java.util.Optional;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@RestController
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/phones")
    public Iterable<Phone> showAllPhones() {
        Iterable<Phone> phones = phoneRepository.findAll();
        if (!phones.iterator().hasNext()) {
            throw new ItemNotFoundException("No phones found.");
        }
        return phones;
    }

    @GetMapping("/phones/{id}")
    public Phone showAllAccounts(@PathVariable("id") Long accountId) {
        Optional<Phone> phone = phoneRepository.findById(accountId);
        if (!phone.isPresent()) {
            throw new ItemNotFoundException("No phone found.");
        }
        return phone.get();
    }
}
