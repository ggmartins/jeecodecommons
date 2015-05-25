package com.example;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ApplicationClient {
	public static void main(String args[]) throws NamingException, CreateException, RemoveException{
		Context initial = new InitialContext();
		Context environment = (Context)initial.lookup("java:comp/env");
		//homeInterface home = (homeInterface) initial.lookup("com.example.EntityBean");
		homeInterface home = (homeInterface) initial.lookup("EntityBean");
		com.example.EntityBean entitybean = home.create();
	}
}
