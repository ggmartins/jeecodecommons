package com.example;

import java.rmi.RemoteException;

public interface componentInterface extends javax.ejb.EJBObject{
	public Integer doCalculation(Integer inputs) throws RemoteException;

}
