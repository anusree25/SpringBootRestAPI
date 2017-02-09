package com.example.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Todo;
import com.example.service.TodoService;

@Path("/todos")
@Component
public class TodoResource {
	
	@Autowired
	TodoService todoService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getAllTodos(){
		return todoService.getTodos();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getTodo(@PathParam(value = "id")Integer id){
		if(todoService.getTodoById(id)!=null){
		    return Response.ok().entity(todoService.getTodoById(id)).build();
		}else{
			return Response.ok().entity("The entity not found").build();
		}
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTodo(Todo todo) throws URISyntaxException{
		if(todo==null){
			return Response.status(400).entity("Please enter the todo!!").build();
		}else{
			todoService.addTodo(todo);
			return Response.created(new URI("/rest/todos")).build();
		}
			
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteTod(@PathParam(value="id")Integer id){
		todoService.deleteTodo(id);
		return Response.status(Response.Status.NO_CONTENT).entity("Deleted the entity").build();
		
	}
	
	@PUT
	public Response updateTodo(Todo todo){
		todoService.editTodo(todo);
		return Response.status(200).entity("Edited").build();
	}
	
}
