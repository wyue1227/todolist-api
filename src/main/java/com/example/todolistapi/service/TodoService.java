package com.example.todolistapi.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.todolistapi.dao.TodoMapper;
import com.example.todolistapi.dto.todo.AddTodoDto;
import com.example.todolistapi.entity.TodoEntity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Resource
    TodoMapper todoMapper;

    public boolean addTodo(AddTodoDto dto) {
        TodoEntity entity = new TodoEntity();
        BeanUtils.copyProperties(dto, entity);
        int res = todoMapper.insertTodo(entity);
        return res > 0;
    }

    public List<TodoEntity> getTodoEntitiesBySectionID(int sectionID) {
        List<TodoEntity> result = todoMapper.getTodoList(sectionID);
        return result;
    }

    public TodoEntity getTodoInfo(int todoID) {
        TodoEntity result = todoMapper.getTodoDetail(todoID);
        return result;
    }

    public boolean updateTodoInfo(int todoID, AddTodoDto dto) {
        TodoEntity entity = new TodoEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setTodoID(todoID);
        int result = todoMapper.updateTodoInfo(entity);
        return result > 0;
    }

    public boolean updateTodoStatus(int todoID, boolean updateStatus) {
        if (updateStatus) {
            return setTodoStatusDone(todoID);
        } else {
            return setTodoStatusUndone(todoID);
        }
    }

    private boolean setTodoStatusDone(int todoID) {
        int result = todoMapper.todoEnd(todoID);
        return result > 0;
    }

    private boolean setTodoStatusUndone(int todoID) {
        int result = todoMapper.todoNotEnd(todoID);
        return result > 0;
    }

    public boolean deleteTodo(int todoID) {
        int result = todoMapper.deleteTodo(todoID);
        return result > 0;
    }
}