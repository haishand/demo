package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void addTwo() {
        User user1 = new User();
        user1.setUsername("aaa");
        user1.setAddress("aa11");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("bbb");
        user2.setAddress("bb222");
        userRepository.save(user2);
    }
}
