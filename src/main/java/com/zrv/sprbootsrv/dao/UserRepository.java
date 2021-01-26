package com.zrv.sprbootsrv.dao;

import com.zrv.sprbootsrv.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findById(UUID id);

}
