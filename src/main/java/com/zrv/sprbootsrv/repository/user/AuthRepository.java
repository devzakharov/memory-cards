package com.zrv.sprbootsrv.repository.user;

import com.zrv.sprbootsrv.domain.user.Auth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends CrudRepository<Auth, UUID> {
    void deleteByUserId(UUID userId);

    Optional<Auth> findByUserId(UUID userId);

    Optional<Auth> findByUserIdAndToken(UUID userId, String token);
}
