package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ua.epam.spring.hometask.exceptions.ItemNotFoundException;
import ua.epam.spring.hometask.models.Role;
import ua.epam.spring.hometask.models.User;
import ua.epam.spring.hometask.repositories.UserRepository;
import ua.epam.spring.hometask.utils.PdfUtil;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Optional;

import static ua.epam.spring.hometask.utils.Constants.UPLOADING_DIR;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> showAllUsers() throws Exception {
        Iterable<User> users = userRepository.findAll();

        if (!users.iterator().hasNext()) {
            throw new ItemNotFoundException("No users found.");
        }

        PdfUtil.createPdfResponseFile(users);

        byte[] contents = Files.readAllBytes(Paths.get(UPLOADING_DIR + "/users.pdf"));

        HttpHeaders headers = new HttpHeaders();

        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ModelAndView getUserInfo(@PathVariable("id") Long userId, Principal principal) {
        boolean isAdmin = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals(Role.BOOKING_MANAGER.name()));

        Optional<User> found = userRepository.findById(userId);
        if (!found.isPresent()) {
            throw new ItemNotFoundException("No user found.");
        }
        if (!isAdmin && !found.get().getUserName().equals(principal.getName())) {
            throw new PermissionDeniedDataAccessException("Not allowed.", null);
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("user_details");
        model.addObject("user", found.get());
        return model;
    }
}
