package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.dao.UserDao;
import com.zrv.sprbootsrv.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User findUser(Integer id) throws SQLException {
        return userDao.find(id).orElseThrow();
    }

    public void addUser(User user) throws SQLException {
        userDao.save(user);
    }
}
