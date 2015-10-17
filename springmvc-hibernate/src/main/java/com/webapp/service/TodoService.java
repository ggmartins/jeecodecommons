package com.webapp.service;

import java.util.List;

import com.webapp.model.Todo;

public interface TodoService {

	public void addTodo(Todo todo);
	public Todo getTodoById(int id);
	public void updTodo(Todo todo);
	public void delTodo(int id);	
	public List<Todo> listTodos();
}
