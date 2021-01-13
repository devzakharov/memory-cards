package com.zrv.sprbootsrv.dao;

import com.zrv.sprbootsrv.domain.Card;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CardDao implements Dao<Card> {

    @Override
    public Optional<Card> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Card> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Card card) throws SQLException {

    }

    @Override
    public void update(Card card, String[] params) throws SQLException {

    }

    @Override
    public void delete(Card card) throws SQLException {

    }
}
