package com.mygym.gym.service;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.User;

import java.util.List;

public interface UserService {

    public UserDto retrieveUser(int id);
    public boolean signup(UserDto dto);

    public List<User> retrieveAll();

    }
