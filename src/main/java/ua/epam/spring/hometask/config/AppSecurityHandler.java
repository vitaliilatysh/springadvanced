package ua.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.models.Role;
import ua.epam.spring.hometask.models.User;
import ua.epam.spring.hometask.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Component
public class AppSecurityHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains(Role.BOOKING_MANAGER.name())) {
            response.sendRedirect("/admin");
            return;
        }
        if (roles.contains(Role.REGISTERED_USER.name())) {
            Optional<User> found = userRepository.findByUserName(authentication.getName());

            if (!found.isPresent()) {
                throw new UsernameNotFoundException("User not found.");
            }
            response.sendRedirect("/users/" + found.get().getId());
        }
    }

}
