package com.example;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StatelessBean
 */
@Stateless
@LocalBean
public class StatelessBean implements SessionBean{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public StatelessBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub
		
	}
	
    double getC2F(double celsius)
    {
    	return celsius * 1.8 + 32;
    }
    
    double getF2C(double fahrenheit)
    {
    	return fahrenheit / 1.8 - 32;
    }

}
