package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by haishand on 2017/6/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping(value="/add")
    public User add(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }
        return userRepository.save(user);
    }

    @GetMapping(value="/search/{id}")
    public User search(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @PutMapping(value="/update/{id}")
    public User update(@PathVariable("id") Integer id,
                       @RequestParam("username") String name,
                       @RequestParam("address") String address) {
        User user = new User();
        user.setUsername(name);
        user.setAddress(address);
        return userRepository.save(user);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userRepository.delete(id);
    }

    @GetMapping("/search/name/{username}")
    public List<User> searchByName(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @PutMapping("/addtwo")
    public void addTwo() {
        userService.addTwo();
    }
}
