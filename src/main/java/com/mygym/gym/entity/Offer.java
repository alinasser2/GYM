package com.mygym.gym.entity;
import lombok.Data;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Entity
@Table(name = "OFFERS")
@Data
@Component
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int percentage;
    private String description;
    private Time duration;


    public Offer(){}
    public Offer(String name, int percentage, String description, Time duration) {
        this.name = name;
        this.percentage = percentage;
        this.description = description;
        this.duration = duration;
    }
}

