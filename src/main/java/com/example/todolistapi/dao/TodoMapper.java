package com.example.todolistapi.dao;

import java.util.List;

import com.example.todolistapi.entity.TodoEntity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    int insertTodo(TodoEntity entity);

    int updateTodoInfo(TodoEntity entity);

    int todoEnd(int todoID);

    int todoNotEnd(int todoID);

    int deleteTodo(int todoID);

    TodoEntity getTodoDetail(int todoID);

    List<TodoEntity> getTodoList(int sectionID);
}