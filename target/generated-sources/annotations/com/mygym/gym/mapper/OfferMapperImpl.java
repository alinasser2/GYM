package com.mygym.gym.mapper;

import com.mygym.gym.dto.OfferDto;
import com.mygym.gym.entity.Offer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T14:52:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class OfferMapperImpl implements OfferMapper {

    @Override
    public OfferDto mapToDto(Offer offer) {
        if ( offer == null ) {
            return null;
        }

        OfferDto offerDto = new OfferDto();

        return offerDto;
    }

    @Override
    public Offer mapToEntity(OfferDto offer) {
        if ( offer == null ) {
            return null;
        }

        Offer offer1 = new Offer();

        return offer1;
    }
}
