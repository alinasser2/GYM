package com.mygym.gym.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class UserDto {
    private int id;
    private String name;
    private String password;
    private String email;
    private int budget;
    private int hourlyRate;
    private boolean isEmployee;
    private int managerId;
    private LocalDateTime dateOfBirth;
}
