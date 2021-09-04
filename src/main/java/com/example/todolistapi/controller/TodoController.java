package com.example.todolistapi.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.todolistapi.dto.ResultDto;
import com.example.todolistapi.dto.todo.AddTodoDto;
import com.example.todolistapi.entity.TodoEntity;
import com.example.todolistapi.service.TodoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Resource
    TodoService todoService;

    @PostMapping("/todo")
    public ResultDto addTodo(@RequestBody AddTodoDto param) {
        System.out.println(param);
        ResultDto dto = new ResultDto(200, "add Success");
        if (!todoService.addTodo(param)) {
            dto.setResultCode(500);
            dto.setMessage("add Failed");
        }
        return dto;
    }

    @GetMapping("/todolist/{sectionID}")
    public ResultDto getTodoList(@PathVariable("sectionID") Integer sectionID) {
        List<TodoEntity> list = todoService.getTodoEntitiesBySectionID(sectionID);
        ResultDto dto = new ResultDto(200, "get todolist Success");
        dto.setData(list);
        return dto;
    }

    @GetMapping("/todo/{todoID}")
    public ResultDto getTodoInfo(@PathVariable("todoID") Integer todoID) {
        TodoEntity entity = todoService.getTodoInfo(todoID);
        ResultDto dto = new ResultDto(200, "get todo Success");
        dto.setData(entity);
        return dto;
    }

    @DeleteMapping("/todo/{todoID}")
    public ResultDto deleteTodo(@PathVariable("todoID") Integer todoID) {
        ResultDto dto = new ResultDto(200, "delete Success");
        if (!todoService.deleteTodo(todoID)) {
            dto.setResultCode(500);
            dto.setMessage("delete Failed");
        }
        return dto;
    }

    @PutMapping("/todo/{todoID}")
    public ResultDto updateTodo(@PathVariable("todoID") Integer todoID, @RequestBody AddTodoDto param) {
        ResultDto dto = new ResultDto(200, "update Success");
        if (!todoService.updateTodoInfo(todoID, param)) {
            dto.setResultCode(500);
            dto.setMessage("delete Failed");
        }
        return dto;
    }

    @PutMapping("/todo/status/{todoID}")
    public ResultDto updateTodoStatus(@PathVariable("todoID") Integer todoID, @RequestBody AddTodoDto param) {
        ResultDto dto = new ResultDto(200, "update Success");
        if (!todoService.updateTodoStatus(todoID, param.isStatus())) {
            dto.setResultCode(500);
            dto.setMessage("delete Failed");
        }
        return dto;
    }
}