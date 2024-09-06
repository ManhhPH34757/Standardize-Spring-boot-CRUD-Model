package com.spring.springsecurity.repositories;

import com.spring.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String s);

    Optional<User> findByEmail(String s);

}
