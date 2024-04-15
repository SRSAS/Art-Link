package com.artlink.app.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.artlink.app.auth.domain.AuthUser;

@Repository
@Transactional
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    @Query(value = "SELECT * FROM auth_users u WHERE u.username = lower(:username)", nativeQuery = true)
    Optional<AuthUser> findAuthUserByUsername(String username);
}
