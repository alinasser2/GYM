package com.mygym.gym.service.serviceImpl;

import com.mygym.gym.dto.OfferDto;
import com.mygym.gym.entity.Offer;
import com.mygym.gym.mapper.OfferMapper;
import com.mygym.gym.repository.OfferRepository;
import com.mygym.gym.service.OfferService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapper mapper;
    private final OfferRepository repository;


    @Override
    public boolean createOffer(OfferDto dto) {
        if(dto.getPercentage() <= 0)
        {
            throw new ValidationException("Offer percentage must be greater than 0");
        }
        Offer offer = mapper.mapToEntity(dto);
        repository.save(offer);
        return true;
    }
}
