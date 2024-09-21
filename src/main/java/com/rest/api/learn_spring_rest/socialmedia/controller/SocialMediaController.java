package com.rest.api.learn_spring_rest.socialmedia.controller;

import com.rest.api.learn_spring_rest.socialmedia.User;
import com.rest.api.learn_spring_rest.socialmedia.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SocialMediaController {

    private UserDaoService userDaoService;

    @Autowired
    public SocialMediaController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUsersById(@PathVariable int id) throws UserNotFoundException {
        try{
            return userDaoService.findUserById(id);
        } catch (RuntimeException e) {
//            throw new UserNotFoundException("id " + id);
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "User not Found");
        }
    }

    @PostMapping("/create-users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        User saveUser = userDaoService.save(user);
//        return ResponseEntity.ok("User has been created");
        URI path = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class UserNotFoundException extends Throwable {
        public UserNotFoundException(String s) {
            super("User not found");
        }
    }
}
