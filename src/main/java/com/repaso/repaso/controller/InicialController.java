package com.repaso.repaso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.repaso.repaso.dto.AuthenticationRequest;
import com.repaso.repaso.dto.AuthenticationResponse;
import com.repaso.repaso.dto.UserDto;
import com.repaso.repaso.entity.UserEntity;
import com.repaso.repaso.repository.IUserRepository;
import com.repaso.repaso.service.JwtUtil;
import com.repaso.repaso.service.UsuarioService;

@RestController
public class InicialController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        UserEntity userEntity = new UserEntity(userDto.getUsername(), userDto.getPassword());
        userRepository.save(userEntity);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}