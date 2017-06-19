package com.example.demo.controller;

import com.example.demo.domain.Result;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
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
    public Result add(@Valid User user, BindingResult bindingResult) {
        Result result;
        if(bindingResult.hasErrors()) {
            result = ResultUtil.fail(1, bindingResult.getFieldError().getDefaultMessage());
        }else {
            result = ResultUtil.success(user);
        }
        return result;
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

    @GetMapping(value = "/getAddress/{id}")
    public void getAddress(@PathVariable("id") Integer id) throws Exception {
        userService.getAddress(id);
    }
}
