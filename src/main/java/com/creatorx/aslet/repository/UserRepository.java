package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
