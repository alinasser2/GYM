package com.mygym.gym.service;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.dto.UserSubscriptionDto;

public interface UserService {

    public UserDto retrieveUser(int id);
    public boolean signup(UserDto dto);
}
