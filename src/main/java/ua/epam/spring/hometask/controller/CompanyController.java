package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.epam.spring.hometask.exceptions.ItemNotFoundException;
import ua.epam.spring.hometask.models.Company;
import ua.epam.spring.hometask.repositories.CompanyRepository;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public Iterable<Company> showAllCompanies() {
        Iterable<Company> companies = companyRepository.findAll();
        if (!companies.iterator().hasNext()) {
            throw new ItemNotFoundException("No companies were found.");
        }
        return companies;
    }
}
