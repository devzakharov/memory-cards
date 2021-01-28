package com.zrv.sprbootsrv.repository.user;

import com.zrv.sprbootsrv.domain.user.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}

