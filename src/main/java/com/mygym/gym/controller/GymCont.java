package com.mygym.gym.controller;

import com.mygym.gym.dto.*;
import com.mygym.gym.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class GymCont {

    private final ClassService classservice;
    private final UserService userservice;
    private final OfferService offerService;



    @GetMapping("/{id}")
    public ResponseEntity<String> userData(@PathVariable("id") int id)
    {

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
            return ResponseEntity.status(HttpStatus.CREATED).body("Class created successfully");
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
