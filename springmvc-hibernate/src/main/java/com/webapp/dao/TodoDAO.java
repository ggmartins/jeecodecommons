package com.webapp.dao;

import java.util.List;

import com.webapp.model.Todo;


public interface TodoDAO {

	public void addTodo(Todo t);
	public void updateTodo(Todo t);
	public List<Todo> listTodos();
	public Todo getTodoById(int id);
	public void removeTodo(int id);
}

/*
public interface TodoDAO {

	public void addTodo(Todo todo);
	public Todo getTodoById(int id);
	public void updTodo(Todo todo);
	public void delTodo(int id);	
	public List<Todo> getTodos();
	
}
*/