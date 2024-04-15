package com.artlink.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artlink.app.user.domain.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
}
