package com.mygym.gym.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLASSES")
@Component
@Data
public class Classes {
    @Id
    private int id;
    private String name;
    private String description;
    private int price;
    private Time duration;
    private int coachId;
    @JsonProperty("dateTimes")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTimes;
    public Classes(){
    }

    public Classes(String name, String description, int price, Time duration, int coachId, LocalDateTime dateTime) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.coachId = coachId;
        this.dateTimes = dateTime;
        }
}