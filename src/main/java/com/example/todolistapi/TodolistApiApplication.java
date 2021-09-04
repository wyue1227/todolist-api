package com.example.todolistapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.todolistapi.config")
@MapperScan("com.example.todolistapi.dao")
public class TodolistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApiApplication.class, args);
	}

}
