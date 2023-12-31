package com.mygym.gym.mapper;

import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.UserSubscriptions;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserSubscriptionMapper {
    UserSubscriptionDto mapToDto(UserSubscriptions u);
    UserSubscriptions mapToEntity(UserSubscriptionDto u);

}
