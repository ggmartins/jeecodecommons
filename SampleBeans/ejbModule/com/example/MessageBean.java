package com.example;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: MessageBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		})
public class MessageBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public MessageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        
    }
    
    public void setMessageDriveContext(MessageDrivenContext mdc)
    {
    	
    }
    
    public void ejbCreate(){}
    public void ejbRemove(){}

}
