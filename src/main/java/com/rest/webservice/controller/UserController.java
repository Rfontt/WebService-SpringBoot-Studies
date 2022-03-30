package com.rest.webservice.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.rest.webservice.bean.UserBean;
import com.rest.webservice.exceptions.UserNotFoundException;
import com.rest.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserBean user) {
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
    public EntityModel<UserBean> findOne(@PathVariable int id) {
        UserBean user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        EntityModel<UserBean> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).listAll());

        model.add(linkToUsers.withRel("all-users"));

        return model;
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable int id) {
        UserBean user = service.deleteByID(id);

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
    }
}
