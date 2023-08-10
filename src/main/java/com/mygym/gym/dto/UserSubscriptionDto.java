package com.mygym.gym.dto;

import com.mygym.gym.entity.Classes;
import com.mygym.gym.entity.User;
import lombok.Data;

@Data
public class UserSubscriptionDto {

    private int id;

    private User user;

    private Classes classes;
    private int amountPaid;

}
