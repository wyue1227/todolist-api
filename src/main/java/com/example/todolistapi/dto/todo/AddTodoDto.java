package com.example.todolistapi.dto.todo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddTodoDto {

    private boolean status;

    private String content;

    private String remark;

    private int sectionID;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime planTime;
}