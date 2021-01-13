package com.zrv.sprbootsrv.controller;

import com.zrv.sprbootsrv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    Map<String, Integer> findUser(@RequestParam int id) throws SQLException {
        return null;
    }

    @PostMapping("/api/v1/users")
    void addUser() throws SQLException {

    }

    @DeleteMapping("/api/v1/users")
    void deleteUser(@RequestParam int id) throws SQLException {

    }

}
