package com.mygym.gym.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "OFFERS")
@Getter
@Setter
@ToString
@Component
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private int percentage;
    private String description;
    private LocalTime duration;
    private LocalDateTime startTime;
    private boolean isExpired;

    public Offer()
    {
        this.startTime = LocalDateTime.now();
    }
    public Offer(String name, int percentage, String description, LocalTime duration) {
        this.startTime = LocalDateTime.now();
        this.name = name;
        this.percentage = percentage;
        this.description = description;
        this.duration = duration;
        this.isExpired = false;
    }

    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(this.startTime.plusMinutes(this.duration.getMinute()));
    }
}

