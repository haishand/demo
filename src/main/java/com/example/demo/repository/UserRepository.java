package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by haishand on 2017/6/16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(Integer id);
    public List<User> findByUsername(String username);
}
