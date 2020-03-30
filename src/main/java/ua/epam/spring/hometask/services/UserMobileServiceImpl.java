package ua.epam.spring.hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.exceptions.ItemNotFoundException;
import ua.epam.spring.hometask.models.Company;
import ua.epam.spring.hometask.models.Phone;
import ua.epam.spring.hometask.models.User;
import ua.epam.spring.hometask.repositories.AccountRepository;
import ua.epam.spring.hometask.repositories.CompanyRepository;
import ua.epam.spring.hometask.repositories.PhoneRepository;
import ua.epam.spring.hometask.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserMobileServiceImpl implements UserMobileService {

    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void changeMobileOperator(Long userId, String number, String companyName) {
        Optional<User> foundUser = userRepository.findById(userId);
        if (!foundUser.isPresent()) {
            throw new ItemNotFoundException("No user found.");
        }
        Optional<Phone> foundPhone = phoneRepository.findByNumber(number);
        if (!foundPhone.isPresent()) {
            throw new ItemNotFoundException("No phone found.");
        }
        Optional<Company> foundCompany = companyRepository.findByName(companyName);
        if (!foundCompany.isPresent()) {
            throw new ItemNotFoundException("No company found.");
        }
        User user = foundUser.get();
        Phone phone = foundPhone.get();
        Company company = foundCompany.get();

        phone.setCompany(company);
        phone.setUser(user);

        phoneRepository.save(phone);
    }
}
