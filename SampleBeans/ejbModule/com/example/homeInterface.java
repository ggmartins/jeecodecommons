package com.example;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.RemoveException;

public interface homeInterface extends EJBHome{
	public com.example.EntityBean create() throws CreateException, RemoveException;

}
