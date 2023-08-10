package com.mygym.gym.config;
//
import com.mygym.gym.mapper.*;
import com.mygym.gym.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfiguration {


    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
//
    @Bean
    public OfferMapper OfferMapper() {
        return new OfferMapperImpl();
    }

    @Bean
    public ClassMapper ClassMapper() {
        return new ClassMapperImpl();
    }

    @Bean
    public UserSubscriptionMapper UserSubscriptionMapper() {
        return new UserSubscriptionMapperImpl();
    }

}