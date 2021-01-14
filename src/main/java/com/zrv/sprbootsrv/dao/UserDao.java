package com.zrv.sprbootsrv.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.zrv.sprbootsrv.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao implements Dao<User> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Optional<User> get(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {

        String query = "insert into user_table (avatar, nickname, login, password, email, settings) \n" +
                "values (:avatar, :nickname, :login, :password, :email, to_json(:settings::json))";

        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("avatar", user.getAvatar());
        paramSource.addValue("nickname", user.getNickname());
        paramSource.addValue("login", user.getLogin());
        paramSource.addValue("password", user.getPassword());
        paramSource.addValue("email", user.getEmail());
        paramSource.addValue("settings", user.getSettings().toString());

        namedParameterJdbcTemplate.update(query, paramSource);

    }

    @Override
    public void update(User user, String[] params) throws SQLException {

    }

    @Override
    public void delete(User user) throws SQLException {

    }

    @Override
    public Optional<User> find(Integer id) throws SQLException {

        String query = "select * from user_table where id = :id limit 1";

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        SqlRowSet rs = namedParameterJdbcTemplate.queryForRowSet(query, paramSource);

        if (!rs.next()) {
            return Optional.empty();
        } else {
            return Optional.of(createUserFromSqlRowSet(rs));
        }
    }

    private User createUserFromSqlRowSet(SqlRowSet rs) {

        User user = new User();

        user.setId(rs.getInt("id"));
        user.setAvatar(rs.getString("avatar"));
        user.setLogin(rs.getString("login"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setSettings(rs.getObject("settings", JsonNode.class));

        return user;
    }
}
