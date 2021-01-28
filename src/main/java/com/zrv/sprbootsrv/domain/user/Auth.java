package com.zrv.sprbootsrv.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth")
public class Auth {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
}
