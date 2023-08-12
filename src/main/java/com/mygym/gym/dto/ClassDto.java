package com.mygym.gym.dto;

import lombok.Data;
import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class ClassDto {
    private String name;
    private String description;
    private int price;
    private Time duration;
    private int coachId;
    private LocalDateTime dateTimes;
}
