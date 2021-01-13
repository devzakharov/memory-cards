package com.zrv.sprbootsrv.controller;

import com.zrv.sprbootsrv.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @GetMapping("/api/v1/cards")
    Map<String, Integer> findCard(@RequestParam int id) throws SQLException {
        return null;
    }

    @PostMapping("/api/v1/cards")
    void addCard() throws SQLException {

    }

    @DeleteMapping("/api/v1/cards")
    void deleteCard(@RequestParam int id) throws SQLException {

    }

}
