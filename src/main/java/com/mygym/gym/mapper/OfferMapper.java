package com.mygym.gym.mapper;

import com.mygym.gym.dto.OfferDto;
import com.mygym.gym.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.Duration;

@Mapper
public interface OfferMapper {
    OfferDto mapToDto(Offer offer);
    Offer mapToEntity(OfferDto offer);

}
