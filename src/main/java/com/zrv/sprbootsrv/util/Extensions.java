package com.zrv.sprbootsrv.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Extensions {

    public static UUID toUUID(String value) {
        return value == null ? null : UUID.fromString(value);
    }

    public static LocalDateTime toLDT(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
