package com.example.demo5.repository;

import com.example.demo5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
   public List<User> findAll();
}