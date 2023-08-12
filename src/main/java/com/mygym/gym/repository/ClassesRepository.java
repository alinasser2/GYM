package com.mygym.gym.repository;
import com.mygym.gym.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository  extends JpaRepository<Classes, Integer> {

}
