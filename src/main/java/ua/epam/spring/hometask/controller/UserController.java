package ua.epam.spring.hometask.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.epam.spring.hometask.models.User;
import ua.epam.spring.hometask.repositories.UserRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@Controller
public class UserController {
    public static final String uploadingDir = System.getProperty("user.dir") + "/";

    @Autowired
    private UserRepository userRepository;

    public static Document createPdfResponseFile(Iterable<User> users) throws Exception {
        Document document = new Document();
        File newFile = new File(uploadingDir + "users.pdf");
        newFile.createNewFile();
        PdfWriter.getInstance(document, new FileOutputStream(uploadingDir + "/users.pdf"));
        document.open();
        document.add(new Paragraph("Users"));
        PdfPTable table = new PdfPTable(3);
        List<String[]> row = new ArrayList<>();

        for (User user : users) {
            String[] data = new String[3];
            data[0] = user.getId().toString();
            data[1] = user.getFirstName();
            data[2] = user.getLastName();
            row.add(data);
        }

        for (String[] cols : row) {
            for (String col : cols) {
                table.addCell(col);
            }
        }

        document.add(table);
        document.close();

        return document;
    }

    @PostMapping("/users")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        File convertedFile = new File(uploadingDir + file.getOriginalFilename());
        ObjectMapper mapper = new ObjectMapper();
        try {
            file.transferTo(convertedFile);
            List<User> usersList = mapper.readValue(convertedFile, new TypeReference<List<User>>() {
            });
            userRepository.saveAll(usersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getUsers() throws Exception {
        createPdfResponseFile(userRepository.findAll());

        byte[] contents = Files.readAllBytes(Paths.get(uploadingDir + "/users.pdf"));

        HttpHeaders headers = new HttpHeaders();

        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
}
