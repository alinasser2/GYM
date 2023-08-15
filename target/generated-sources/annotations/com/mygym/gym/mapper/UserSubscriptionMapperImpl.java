package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.UserSubscriptions;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-15T16:13:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class UserSubscriptionMapperImpl implements UserSubscriptionMapper {

    @Override
    public UserSubscriptionDto mapToDto(UserSubscriptions u) {
        if ( u == null ) {
            return null;
        }

        UserSubscriptionDto userSubscriptionDto = new UserSubscriptionDto();

        userSubscriptionDto.setId( u.getId() );
        userSubscriptionDto.setAmountPaid( u.getAmountPaid() );

        return userSubscriptionDto;
    }

    @Override
    public UserSubscriptions mapToEntity(UserSubscriptionDto u) {
        if ( u == null ) {
            return null;
        }

        UserSubscriptions userSubscriptions = new UserSubscriptions();

        userSubscriptions.setId( u.getId() );
        userSubscriptions.setAmountPaid( u.getAmountPaid() );

        return userSubscriptions;
    }
}
