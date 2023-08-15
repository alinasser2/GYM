package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-15T16:13:47+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setBudget( user.getBudget() );
        userDto.setHourlyRate( user.getHourlyRate() );
        userDto.setEmployee( user.isEmployee() );
        userDto.setManagerId( user.getManagerId() );
        userDto.setDateOfBirth( user.getDateOfBirth() );

        return userDto;
    }

    @Override
    public User mapToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setBudget( dto.getBudget() );
        user.setHourlyRate( dto.getHourlyRate() );
        user.setEmployee( dto.isEmployee() );
        user.setManagerId( dto.getManagerId() );
        user.setDateOfBirth( dto.getDateOfBirth() );

        return user;
    }
}
