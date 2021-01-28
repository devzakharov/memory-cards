package com.zrv.sprbootsrv.dao;

import com.zrv.sprbootsrv.domain.user.User;
import com.zrv.sprbootsrv.service.SHA256CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao implements Dao<User> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SHA256CryptoService sha256CryptoService;

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

        paramSource.addValue("nickname", user.getNickname());
        paramSource.addValue("password", sha256CryptoService.getHashString(user.getPassword()));
        paramSource.addValue("email", user.getEmail());

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

        user.setId((java.util.UUID) rs.getObject("id"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }

    public boolean isUserLoginExist(User user) {
        String query = "SELECT * FROM user_table WHERE login = :login";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        SqlRowSet rs = namedParameterJdbcTemplate.queryForRowSet(query, parameterSource);

        return rs.next();
    }

    public boolean isUserEmailExist(User user) {
        String query = "SELECT * FROM user_table WHERE email = :email";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", user.getEmail());

        SqlRowSet rs = namedParameterJdbcTemplate.queryForRowSet(query, parameterSource);

        return rs.next();
    }
}
