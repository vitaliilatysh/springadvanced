package ua.epam.spring.hometask.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.epam.spring.hometask.models.Account;
import ua.epam.spring.hometask.models.Company;
import ua.epam.spring.hometask.models.Phone;
import ua.epam.spring.hometask.models.User;
import ua.epam.spring.hometask.repositories.AccountRepository;
import ua.epam.spring.hometask.repositories.CompanyRepository;
import ua.epam.spring.hometask.repositories.PhoneRepository;
import ua.epam.spring.hometask.repositories.UserRepository;

import javax.persistence.PersistenceException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static ua.epam.spring.hometask.utils.Constants.UPLOADING_DIR;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile[] files) {
        if (files == null) {
            throw new IllegalArgumentException("No files uploaded. Please, upload the file.");
        }

        List<User> usersList;
        List<Company> companyList;
        List<Phone> phonesList;
        List<Account> accounts;

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            File convertedFile = new File(UPLOADING_DIR + originalFilename);
            ObjectMapper mapper = new ObjectMapper();
            try {
                file.transferTo(convertedFile);
                if ("users.json".equals(originalFilename)) {
                    usersList = mapper.readValue(convertedFile, new TypeReference<List<User>>() {
                    });
                    userRepository.saveAll(usersList);
                } else if ("phones.json".equals(originalFilename)) {
                    phonesList = mapper.readValue(convertedFile, new TypeReference<List<Phone>>() {
                    });
                    phoneRepository.saveAll(phonesList);
                } else if ("accounts.json".equals(originalFilename)) {
                    accounts = mapper.readValue(convertedFile, new TypeReference<List<Account>>() {
                    });
                    accountRepository.saveAll(accounts);
                } else {
                    companyList = mapper.readValue(convertedFile, new TypeReference<List<Company>>() {
                    });
                    companyRepository.saveAll(companyList);
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            } catch (PersistenceException e) {
                throw new PersistenceException(e);
            }
        }
        return "redirect:/admin";
    }
}
