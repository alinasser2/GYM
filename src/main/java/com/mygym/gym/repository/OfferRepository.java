package com.mygym.gym.repository;

import com.mygym.gym.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
    boolean findByName(String name);
}
