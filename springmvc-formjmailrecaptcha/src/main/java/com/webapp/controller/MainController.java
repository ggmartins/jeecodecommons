package com.webapp.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private JavaMailSender mailSender;

	
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
	
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String sayHelloForm(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (Form contact, JavaMail)");
        return "view3";
    }
    
	@RequestMapping(value="/form/request_form", method = RequestMethod.POST)
	public ModelAndView requestForm( 
			@RequestParam(value = "name", required = true) final String name,
			@RequestParam(value = "email", required = true) final String email,
			@RequestParam(value = "notabot", required = false) String notabot,
			@RequestParam(value = "message", required = true) final String message,
			@RequestParam(value = "g-recaptcha-response", required = false) final String recaptcharesponse
			){
		final String option=notabot!=null ? "notabot" : "bot";

		String output = "New device for ["+ name +"]["+email+"]["+option+"]["+message+"]";
		System.out.println(output);
		try{
			if(option.equals("bot")) return new ModelAndView("main", "message", "Error: no bots allowed.");;
			if(sendPost(recaptcharesponse)!=200)
				return null;
		} catch(Exception e) { System.err.println("sendPost:"); e.printStackTrace();}
		
		try{
			mailSender.send(new MimeMessagePreparator() {			
			  //@Override
			  public void prepare(MimeMessage mimeMessage) throws Exception {
			    MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			    msg.setFrom(email);
			    msg.setTo("@gmail.com");
			    msg.setSubject("Contact");
			    msg.setText("<b>received ["+option+"] from ["+name+"|"+
			                                                   email+"] Reason: "+message+"</b>", true);
			  }
		});
		} catch(Exception e) { System.err.println("mailSender:"); e.printStackTrace();}
				
		return new ModelAndView("main", "message", "Request sent successfully.");
	}
	
	private int sendPost(String response) throws Exception {
		 
		String url = "https://www.google.com/recaptcha/api/siteverify";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "App");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "secret=yoursecrethere&response="+response;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' validation request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer resp = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			resp.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(resp.toString());
		return responseCode;
 
	}
    
}