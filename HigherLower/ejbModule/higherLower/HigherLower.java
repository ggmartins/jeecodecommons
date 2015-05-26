package higherLower;

//import java.io.BufferedReader;
//import java.io.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Random;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HigherLower
 */
@Stateless
@LocalBean
public class HigherLower implements SessionBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int number;

    /**
     * Default constructor. 
     */
    public HigherLower() {
    	Random r = new Random();
        number = r.nextInt(100);
    }
    
    public int getInput() throws IOException, QuitException {
        System.out.println("Enter a number 0-100:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String cmd=br.readLine();
        if(cmd.equals("quit")) throw new QuitException();
        return Integer.parseInt(cmd);
    }
    
    public boolean checkValue(int value) {
    	if(value == number) {
    		System.out.println("Winner!");
    		return true;
    	}
    	if(value < number) {
    		System.out.println("Higher");
    	} else if(value > number) {
    		System.out.println("Lower");
    	}
    	return false;
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

}
