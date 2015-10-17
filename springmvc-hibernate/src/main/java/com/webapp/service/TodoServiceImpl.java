package com.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.webapp.dao.TodoDAO;
import com.webapp.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	private TodoDAO todoDAO;

	public void setTodoDAO(TodoDAO todoDAO)
	{
		this.todoDAO=todoDAO;
	}
	
	@Override
	@Transactional
	public void addTodo(Todo todo) {
		todoDAO.addTodo(todo);	
	}

	@Override
	@Transactional
	public Todo getTodoById(int id) {
		return todoDAO.getTodoById(id);
	}

	@Override
	@Transactional
	public void updTodo(Todo todo) {
		todoDAO.updateTodo(todo);
	}

	@Override
	@Transactional
	public void delTodo(int id) {
		todoDAO.removeTodo(id);
	}

	@Override
	@Transactional
	public List<Todo> listTodos() {
		return todoDAO.listTodos();
	}
	

}
