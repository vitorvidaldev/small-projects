package dev.vitorvidal.threads.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthService {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(JwtTokenUtil jwtTokenUtil, UserService userService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userService.loadUserByUsername(username);

        if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtTokenUtil.generateToken(userDetails);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}