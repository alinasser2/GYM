package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T14:52:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public User mapToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}
