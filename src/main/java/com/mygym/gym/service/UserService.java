package com.mygym.gym.service;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDto retrieveUser(int id);
    public boolean signup(UserDto dto);

    public List<User> retrieveAll();

    public User findByEmail(String email);

    public void revokeAllUserTokens(int userId);

    public Optional<User> findById(int id);

}
