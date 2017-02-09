package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.Todo;

@Service
@Component
public class TodoServiceImplementation implements TodoService {
	
	static List<Todo> todoList;
	static{
		todoList = new ArrayList<Todo>();
		todoList.add(new Todo(1, "home", "Pay rent"));
		todoList.add(new Todo(2, "home", "Buy milk"));
		todoList.add(new Todo(3, "home", "Buy veggies"));

	}
	
	
	
	public List<Todo> getTodos() {

		return todoList;
	}

	public Integer addTodo(Todo todo) {	
		todoList.add(todo);
		return todo.getId();
	}

	public Boolean deleteTodo(Integer id) {
		Todo todo = getTodoById(id);
		return todoList.remove(todo);
	}

	

	@Override
	public Todo getTodoById(Integer id) {
		for(Todo t:todoList){
			if(t.getId() == id ){
				return t;
			}
		}
		return null;
	}

	@Override
	public Integer editTodo(Todo todo) {
		try{
			System.out.println("todo ID-->"+todo.getId());
			Todo originalTodo= getTodoById(todo.getId());
			originalTodo.setId(todo.getId());
			originalTodo.setCategory(todo.getCategory());
			originalTodo.setTodo(todo.getTodo());
			return originalTodo.getId();
		}catch(Exception e){
			e.printStackTrace();
			addTodo(todo);
			return todo.getId();
		}
	}
	

}
