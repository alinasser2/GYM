package com.mygym.gym.service.serviceImpl;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import com.mygym.gym.mapper.UserMapper;
import com.mygym.gym.repository.UsersRepository;
import com.mygym.gym.service.UserService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto retrieveUser(int id) {
        if (id < 0)
        {
            throw new ValidationException("Id must be greater than zero.");
        }
        Optional<User> user = repository.findById(id);
        if (!user.isPresent())
        {
            throw new NoSuchElementException("No user with id "+ id);
        }
        return mapper.mapToDto(user.get());
    }
}
