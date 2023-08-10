package com.mygym.gym.mapper;

import com.mygym.gym.dto.OfferDto;
import com.mygym.gym.entity.Offer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OfferMapper {
    OfferDto mapToDto(Offer offer);
    Offer mapToEntity(OfferDto offer);
}
