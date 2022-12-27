package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    User findByEmailIgnoreCaseAndPassword(String email, String password);
}
