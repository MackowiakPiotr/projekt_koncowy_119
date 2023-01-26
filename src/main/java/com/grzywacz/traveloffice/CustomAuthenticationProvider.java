package com.grzywacz.traveloffice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.grzywacz.traveloffice.user.Authority;
import com.grzywacz.traveloffice.user.User;
import com.grzywacz.traveloffice.user.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw new IllegalArgumentException("Details not found");
        }
        if (encoder.matches(password, byUsername.getPassword())) {
            System.out.println("Successfully Authenticated the user");
            Set<Authority> authorities = byUsername.getAuthorities();
            List<String> collect = authorities.stream().map(Authority::getAuthority).toList();
            return new UsernamePasswordAuthenticationToken(username, password, getUserAuthorities(collect));
        } else {
            throw new IllegalArgumentException("Password mismatch");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getUserAuthorities(List<String> authorities) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (String authority : authorities) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(authority.replaceAll("\\s+", "")));
        }

        return grantedAuthorityList;
    }

}
