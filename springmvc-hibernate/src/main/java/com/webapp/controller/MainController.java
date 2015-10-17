package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.model.Todo;
import com.webapp.service.TodoService;
 

@Controller
@RequestMapping("/")
public class MainController {
	
	TodoService todoService;
	
	@Autowired(required=true)
	@Qualifier(value="todoService")
	public void setTodoService(TodoService ps){
		this.todoService = ps;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (/)");
        return "view1";
    }
 
    @RequestMapping(value="/webapp", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (webapp)");
        return "view2";
    }
    
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String listTodos(Model model) {
		model.addAttribute("message", "hello Spring 4 MVC + Hibernate");
		model.addAttribute("todo", new Todo());
		model.addAttribute("listTodos", this.todoService.listTodos());
		return "todo";
	}

	@RequestMapping(value="/todo/add", method=RequestMethod.POST)
	public String addTodo(@ModelAttribute("todo") Todo todo){
		if(todo.getId() == 0)
			this.todoService.addTodo(todo);
		else
			this.todoService.updTodo(todo);
		
		return "redirect:/todo";
	}	

	@RequestMapping(value="/todo/del/{id}")
	public String delTodo(@PathVariable("id") int id){
		this.todoService.delTodo(id);
		return "redirect:/todo";
	}
	
}