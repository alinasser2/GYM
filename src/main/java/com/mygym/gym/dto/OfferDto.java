package com.mygym.gym.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class OfferDto {
    private String name;
    private int percentage;
    private String description;
    private LocalTime duration;
    private boolean isExpired;
}
