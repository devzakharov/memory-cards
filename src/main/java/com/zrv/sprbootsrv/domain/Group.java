package com.zrv.sprbootsrv.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Group {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String color;

    @NotNull
    private String type;

    @NotNull
    private Integer[] likes;
}
