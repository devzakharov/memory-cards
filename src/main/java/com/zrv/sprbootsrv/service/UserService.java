package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.dao.UserDao;
import com.zrv.sprbootsrv.domain.User;
import com.zrv.sprbootsrv.exception.AppException;
import com.zrv.sprbootsrv.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User findUser(Integer id) throws SQLException {
        return userDao.find(id).orElseThrow(() -> AppException.of(ErrorType.USER_NOT_FOUND, id));
    }

    public void addUser(User user) throws SQLException {

        if (userDao.isUserEmailExist(user))
            throw AppException.of(ErrorType.USER_WITH_EMAIL_ALREADY_EXIST, user.getEmail());

        if (userDao.isUserLoginExist(user))
            throw AppException.of(ErrorType.USER_WITH_LOGIN_ALREADY_EXIST, user.getLogin());

        userDao.save(user);
    }

    public Request getRequestContext() {
        return null;
    }
}
