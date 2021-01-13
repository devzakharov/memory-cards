package com.zrv.sprbootsrv.dao;

import com.zrv.sprbootsrv.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements Dao<User> {
    @Override
    public Optional<User> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {

    }

    @Override
    public void update(User user, String[] params) throws SQLException {

    }

    @Override
    public void delete(User user) throws SQLException {

    }
}
