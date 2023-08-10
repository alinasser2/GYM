package com.mygym.gym.dto;

import lombok.Data;
import java.sql.Time;

@Data
public class ClassDto {
    private int id;
    private String name;
    private String description;
    private int price;
    private Time duration;
    private int coachId;
}
