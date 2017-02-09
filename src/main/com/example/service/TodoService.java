package com.example.service;

import java.util.List;

import com.example.model.Todo;

public interface TodoService {
	
	List<Todo> getTodos();
	
	Todo getTodoById(Integer id);
	
	Integer addTodo(Todo todo);
	
	Boolean deleteTodo(Integer id);
	
	Integer editTodo(Todo todo);
	
}
