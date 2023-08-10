package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.UserSubscriptions;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T14:52:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class UserSubscriptionMapperImpl implements UserSubscriptionMapper {

    @Override
    public UserSubscriptionDto mapToDto(UserSubscriptions u) {
        if ( u == null ) {
            return null;
        }

        UserSubscriptionDto userSubscriptionDto = new UserSubscriptionDto();

        return userSubscriptionDto;
    }

    @Override
    public UserSubscriptions mapToDto(UserSubscriptionDto u) {
        if ( u == null ) {
            return null;
        }

        UserSubscriptions userSubscriptions = new UserSubscriptions();

        return userSubscriptions;
    }
}
