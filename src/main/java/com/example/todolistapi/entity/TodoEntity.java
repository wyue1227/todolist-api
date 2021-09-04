package com.example.todolistapi.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoEntity {

    private Integer todoID;

    private String content;

    private String remark;

    private boolean status;

    private Integer sectionID;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime finishTime;

    private LocalDateTime planTime;
}