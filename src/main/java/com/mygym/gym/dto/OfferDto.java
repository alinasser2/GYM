package com.mygym.gym.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class OfferDto {
    private int id;
    private String name;
    private int percentage;
    private String description;
    private Time duration;

}
