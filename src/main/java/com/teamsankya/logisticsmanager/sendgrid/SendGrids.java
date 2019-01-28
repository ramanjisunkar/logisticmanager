package com.teamsankya.logisticsmanager.sendgrid;

import com.sendgrid.*;
import java.io.IOException;

public class SendGrids {
  	
	 public static void main(String[] args) throws IOException {
		  System.out.println("inside sendgrids main()");
	    Email from = new Email("Ramanji.s@teamsankya.com");
	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email("your mail id");
	    Content content = new Content("text/plain", "and i am sending mail using send grid");
	    Mail mail = new Mail(from, subject, to, content);
	    SendGrid sg = new SendGrid(("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"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	      
	      
	      System.out.print("Email sent.");
	    
	      
	    } catch (IOException ex) {
	      throw ex;
	    }
		  
	  }
  }
