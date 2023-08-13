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

import java.util.Random;

@RequiredArgsConstructor
@Validated
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapper mapper;
    private final OfferRepository repository;


    @Override
    public boolean createOffer(OfferDto dto) {
        validateInput(dto);
        setRandomUniquePromocode(dto);
        Offer offer = mapper.mapToEntity(dto);
        repository.save(offer);
        return true;
    }

    private static void validateInput(OfferDto dto) {
        if(dto.getPercentage() <= 0)
        {
            throw new ValidationException("Offer percentage must be greater than 0");
        }
    }

    private void setRandomUniquePromocode(OfferDto dto) {
        String promocode;
        do
        {
            promocode = "df"+getRandomNumber(0,100);
        }
        while(repository.findByName(promocode));
        dto.setName(promocode);
    }

    int getRandomNumber(int min,int max)
    {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
