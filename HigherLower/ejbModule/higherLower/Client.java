package higherLower;

import java.io.IOException;


import javax.ejb.EJB;


public class Client {

	@EJB
	public static void main(String[] args) throws IOException {
		int total=0;
		boolean cont=true;
		HigherLower h = new HigherLower();
		while(cont)
		{
			int i = 0;
			try{
				i = h.getInput();
			}
			catch(QuitException qe) { cont=false; continue; }
			catch(IOException ioe){ ioe.printStackTrace(); }
			if(h.checkValue(i)) cont=false;
			total++;
		}
		System.out.println("Number of attempts:"+total+".3 Bye.");
	}
}
