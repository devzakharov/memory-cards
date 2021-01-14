package com.zrv.sprbootsrv.controller;

import com.zrv.sprbootsrv.domain.User;
import com.zrv.sprbootsrv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    User findUser(@RequestParam Integer id) throws SQLException {
        return userService.findUser(id);
    }

    @PostMapping("/api/v1/users")
    void addUser(@RequestBody User user) throws SQLException {
        userService.addUser(user);
    }

    @PutMapping("/api/v1/users")
    void changeUser() throws SQLException {

    }

    @DeleteMapping("/api/v1/users")
    void deleteUser(@RequestParam int id) throws SQLException {

    }

}
