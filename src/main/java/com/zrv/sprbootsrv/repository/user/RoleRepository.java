package com.zrv.sprbootsrv.repository.user;

import com.zrv.sprbootsrv.domain.user.Role;
import com.zrv.sprbootsrv.domain.user.RoleName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
    Role findByName(RoleName name);

    @Query("SELECT r FROM Role r " +
            "JOIN UserRole ur ON r.id = ur.roleId " +
            "WHERE ur.userId = :userId")
    Set<Role> findByUserId(UUID userId);
}
