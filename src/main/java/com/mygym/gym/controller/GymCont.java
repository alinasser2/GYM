package com.mygym.gym.controller;

import com.mygym.gym.Enum.TokenType;
import com.mygym.gym.dto.*;
import com.mygym.gym.entity.Token;
import com.mygym.gym.entity.User;
import com.mygym.gym.repository.TokenRepository;
import com.mygym.gym.service.*;
import com.mygym.gym.service.serviceImpl.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class GymCont {

    private final ClassService classservice;
    private final UserService userservice;
    private final OfferService offerService;
    private final JwtService jwt;
    private final AuthenticationManager authenticationmanager;
    private final TokenRepository tokenRepository;


    private static final Logger logger = LoggerFactory.getLogger(GymCont.class);

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> userData(@PathVariable("id") int id) {
        logger.error("This is an ERROR level message");
        try {
            UserDto dto = userservice.retrieveUser(id);
            return ResponseEntity.ok(dto.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/classes")
    public ResponseEntity<String> createClass(@RequestBody ClassDto classDto) {
        try {
            classservice.createClass(classDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Class created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/offers")
    public ResponseEntity<String> createOffer(@RequestBody OfferDto dto) {
        try {
            offerService.createOffer(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("offer created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto dto) {
        try {
            userservice.signup(dto);
            Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            if (authentication.isAuthenticated()) {
                User user = userservice.findByEmail(dto.getEmail());
                userservice.revokeAllUserTokens(user.getId());
                Token token = Token.builder()
                        .user(user)
                        .token(jwt.generateToken(dto.getEmail()))
                        .expired(false)
                        .revoked(false)
                        .tokenType(TokenType.BEARER)
                        .build();
                tokenRepository.save(token);
                return ResponseEntity.status(HttpStatus.CREATED).body(token.getToken());
            }
            throw new Exception("user not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            if (authentication.isAuthenticated()) {
                User user = userservice.findByEmail(request.getEmail());
                userservice.revokeAllUserTokens(user.getId());
                Token token = Token.builder()
                        .user(user)
                        .token(jwt.generateToken(request.getEmail()))
                        .expired(false)
                        .revoked(false)
                        .tokenType(TokenType.BEARER)
                        .build();
                tokenRepository.save(token);
                return ResponseEntity.status(HttpStatus.CREATED).body(token.getToken());
            }
            throw new Exception("bad credentials");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

//    @PostMapping("/logout")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<String> logout(@RequestParam("id") int id) {
//        try
//         {
//            userservice.revokeAllUserTokens(id);
//            return ResponseEntity.status(HttpStatus.OK).body("User logged out successfully.");
//        }
//        catch(Exception e)
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
//        }
//
//    }
}
