package com.mygym.gym.repository;

import com.mygym.gym.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {

    @Query(value = "SELECT t.* " +
            "FROM Token t " +
            "INNER JOIN users u ON t.user_id = u.id " +
            "WHERE u.id = :id AND (t.expired = FALSE OR t.revoked = FALSE)", nativeQuery = true)
    List<Token> findAllValidTokenByUser(@Param("id") Integer id);

    Optional<Token> findByToken(String token);
}
