package com.zrv.sprbootsrv.dao;

import com.zrv.sprbootsrv.domain.Group;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupDao implements Dao<Group> {
    @Override
    public Optional<Group> get(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Group> find(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Group> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Group group) throws SQLException {

    }

    @Override
    public void update(Group group, String[] params) throws SQLException {

    }

    @Override
    public void delete(Group group) throws SQLException {

    }

}
