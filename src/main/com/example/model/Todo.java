package com.example.model;

public class Todo {
	
	public Todo(Integer id,String category,String todo){
		this.setId(id);
		this.category = category;
		this.todo = todo;
	}
	
	public Todo(){
		
	}
	

	private Integer id;
	private String category;
	private String todo;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
