package com.rest.webservice.controller;

import com.rest.webservice.bean.UserBean;
import com.rest.webservice.dao.UserDAO;
import com.rest.webservice.exceptions.UserNotFoundException;
import com.rest.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity save(@RequestBody UserBean user) {
        UserBean savedUser = service.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).body(savedUser);
    }

    @GetMapping
    public List<UserBean> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public UserBean findOne(@PathVariable int id) {
        UserBean user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        return user;
    }
}
