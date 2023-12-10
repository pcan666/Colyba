package com.pengcan.colyba.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class Employee {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private Integer sex;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
