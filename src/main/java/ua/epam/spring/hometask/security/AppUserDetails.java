package ua.epam.spring.hometask.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.epam.spring.hometask.models.Role;
import ua.epam.spring.hometask.models.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserDetails implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorityList;

    public AppUserDetails(User user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.authorityList = user.getRoles().stream()
                .map(Role::toString)
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
