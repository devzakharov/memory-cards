package com.zrv.sprbootsrv.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Data
public class Card {

    @NotNull
    private Integer id;

    @NotNull
    private String question;

    @NotNull
    private String answer;

    @NotNull
    private Timestamp date_created;
}
