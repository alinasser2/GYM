package com.mygym.gym;

import com.mygym.gym.mapper.UserMapper;
import com.mygym.gym.repository.OfferRepository;
import com.mygym.gym.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class GymApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GymApplication.class, args);
    }


    public final OfferRepository repository;

    @Override
    public void run(String... args) {
        System.out.println(repository.findById(1).get().isExpired());

    }
}


