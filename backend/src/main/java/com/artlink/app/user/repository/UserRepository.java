package com.artlink.app.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.artlink.app.user.domain.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users u WHERE u.username LIKE :expression", nativeQuery = true)
    Optional<User> findUsersByUsernameExpression(String expression);
}
