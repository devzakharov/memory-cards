package com.zrv.sprbootsrv.controller;

import com.zrv.sprbootsrv.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GroupsController {

    private final GroupService groupService;

    @GetMapping("/api/v1/groups")
    Map<String, Integer> findGroup(@RequestParam int id) throws SQLException {
        return null;
    }

    @PostMapping("/api/v1/groups")
    void addGroup() throws SQLException {

    }

    @DeleteMapping("/api/v1/groups")
    void deleteGroup(@RequestParam int id) throws SQLException {

    }

}
