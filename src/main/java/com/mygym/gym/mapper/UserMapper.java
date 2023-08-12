package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
    UserDto mapToDto(User user);
    User mapToEntity(UserDto dto);
}
