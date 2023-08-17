package com.mygym.gym.repository;

import com.mygym.gym.entity.User;
import com.mygym.gym.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
    public User findByName(String name);

    public Optional<User> findById(int id);

}
