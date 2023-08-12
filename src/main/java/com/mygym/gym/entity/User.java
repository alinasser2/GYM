package com.mygym.gym.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Component
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private int budget;
    private int hourlyRate;
    private boolean isEmployee;
    @Column(nullable = true)
    private int managerId;
    private LocalDateTime dateOfBirth;

    public User(){}

    public User(int hourlyRate, String name, String email, String password, int budget, boolean is_employee, int manager_id, LocalDateTime dateOfBirth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.hourlyRate = hourlyRate;
        this.isEmployee = is_employee;
        this.managerId = manager_id;
        this.dateOfBirth = dateOfBirth;
    }
}