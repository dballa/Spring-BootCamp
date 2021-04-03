package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class AuthenticationController {

    private final JwtService jwtProvider;

    private final AuthenticationManager authenticationManager;
    @Autowired
    public AuthenticationController(JwtService jwtProvider, AuthenticationManager authenticationManager) {
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/api/login")
    public ResponseEntity authenticate(@RequestBody LoginRequest request) {
        Authentication authenticationRequest = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());
        Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);
        LoginResponse response = createResponse(authenticationResult);
        return ResponseEntity.ok(response);
    }

    private LoginResponse createResponse(Authentication authentication) {
    	UserPrincipal agilityUserDetail = (UserPrincipal) authentication.getPrincipal();
        LoginResponse response = new LoginResponse();
        response.setUsername(agilityUserDetail.getUsername());
        String rolesAsStringList = agilityUserDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()).get(0);
        response.setRole(rolesAsStringList);
        String generatedToken = jwtProvider.issueToken(agilityUserDetail);
        response.setToken(generatedToken);
        return response;
    }
}
