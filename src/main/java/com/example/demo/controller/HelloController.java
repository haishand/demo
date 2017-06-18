package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haishand on 2017/6/16.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;

    @Autowired
    private GirlProperties gp;

    @RequestMapping(value={"/say/{id}", "sa"}, method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return gp.getCupSize() + gp.getAge() + id;
    }
}
