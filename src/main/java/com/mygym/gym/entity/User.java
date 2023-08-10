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

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}