package com.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.webapp.dao.TodoDAO;
import com.webapp.model.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addTodo(Todo t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
	}

	@Override
	public void updateTodo(Todo t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public List<Todo> listTodos() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Todo> todoList = session.createQuery("FROM Todo").list();
		return todoList;
	}

	@Override
	public Todo getTodoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Todo t = (Todo) session.load(Todo.class, new Integer(id));
		return t;
	}

	@Override
	public void removeTodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Todo p = (Todo) session.load(Todo.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		
	}

	
/*
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(todo);
	}

	
	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(todo);
		
	}

	
	public void delTodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Todo todo=(Todo) session.createQuery("from todolist").list();
		session.delete(todo);
	}

	
	public List<Todo> getTodos() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Todo> todoList = session.createQuery("from todolist").list();
		return todoList;
	} */

}
