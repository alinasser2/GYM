package com.mygym.gym.controller;

import com.mygym.gym.dto.*;
import com.mygym.gym.service.*;
import com.mygym.gym.service.serviceImpl.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class GymCont {

    private final ClassService classservice;
    private final UserService userservice;
    private final OfferService offerService;
    private final JwtService jwt;
    private final AuthenticationManager authenticationmanager;


    private static final Logger logger = LoggerFactory.getLogger(GymCont.class);

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> userData(@PathVariable("id") int id)
    {
        logger.error("This is an ERROR level message");
        try {
            UserDto dto = userservice.retrieveUser(id);
            return ResponseEntity.ok(dto.toString());
        }
        catch(Exception e)
        {
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
    public ResponseEntity<String> createOffer(@RequestBody OfferDto dto)
    {
        try
        {
            offerService.createOffer(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("offer created successfully");
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto dto)
    {
        try
        {
            userservice.signup(dto);
            Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            if(authentication.isAuthenticated())
            {
                return ResponseEntity.status(HttpStatus.CREATED).body(jwt.generateToken(dto.getEmail()));
            }
             throw new Exception("user not found");

        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
