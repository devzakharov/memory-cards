package com.zrv.sprbootsrv.service;

import com.zrv.sprbootsrv.domain.user.Role;
import com.zrv.sprbootsrv.domain.user.RoleName;
import com.zrv.sprbootsrv.domain.user.UserRole;
import com.zrv.sprbootsrv.repository.user.RoleRepository;
import com.zrv.sprbootsrv.repository.user.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Transactional
    public void addRole(UUID userId, RoleName roleName) {
        Role role = roleRepository.findByName(roleName);
        userRoleRepository.save(UserRole.builder()
                .roleId(role.getId())
                .userId(userId)
                .build()
        );
    }

    @Transactional(readOnly = true)
    public Set<Role> findByUserId(UUID userId) {
        return roleRepository.findByUserId(userId);
    }
}