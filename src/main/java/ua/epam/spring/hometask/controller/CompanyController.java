package ua.epam.spring.hometask.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.epam.spring.hometask.models.Company;
import ua.epam.spring.hometask.repositories.CompanyRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@Controller
public class CompanyController {
    public static final String uploadingDir = System.getProperty("user.dir") + "/";

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/companies")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        File convertedFile = new File(uploadingDir + file.getOriginalFilename());
        ObjectMapper mapper = new ObjectMapper();
        try {
            file.transferTo(convertedFile);
            List<Company> companies = mapper.readValue(convertedFile, new TypeReference<List<Company>>() {
            });
            companyRepository.saveAll(companies);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
