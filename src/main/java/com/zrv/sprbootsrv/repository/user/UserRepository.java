package com.zrv.sprbootsrv.repository.user;

import com.zrv.sprbootsrv.domain.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(UUID id);

    @Query(" SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByAllEmails(String email);

}
