package com.cognizant.jwt_authentication.Controller;

import com.cognizant.jwt_authentication.Util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String[] credentials = decodeBasicAuth(header);
        if (credentials == null || credentials.length != 2) {
            return ResponseEntity.status(400).body("Invalid credentials format");
        }

        String username = credentials[0];
        String password = credentials[1];

        if (!username.equals("user") || !password.equals("pwd")) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok().body(new TokenResponse(token));
    }

    private String[] decodeBasicAuth(String header) {
        String base64Credentials = header.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        return new String(decoded).split(":", 2);
    }

    static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}