package com.caio.helloworld.controllers;

import com.caio.helloworld.model.User;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    private static User user = new User("Empty", "Hello, empty");

    @GetMapping("show")
    public ResponseEntity<User> showUserData() {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("register")
    public ResponseEntity registerUserData(
            String name,
            String message
    ) {
        user = new User(name, message);
        return ResponseEntity.ok().build();
    }

}
