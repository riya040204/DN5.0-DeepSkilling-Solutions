package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Authentication Controller
 * POST /authenticate - returns JWT token
 */
@RestController
public class AuthController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    // POST /authenticate
    // Body: {"username":"user","password":"password"}
    // Returns: {"token":"eyJhbGci..."}
    @PostMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestBody Map<String, String> request) throws Exception {

        String username = request.get("username");
        String password = request.get("password");

        LOGGER.debug("Authentication request for user: {}", username);

        // Authenticate username and password
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password));

        // Generate JWT token
        final UserDetails userDetails =
            userDetailsService.loadUserByUsername(username);
        final String token = jwtUtil.generateToken(userDetails.getUsername());

        LOGGER.debug("JWT token generated for user: {}", username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
