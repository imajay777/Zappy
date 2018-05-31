package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderMail
 */
@WebServlet("/OrderMail")
public class OrderMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      String to = (String) request.getAttribute("Emailid");
	      String sub="Order Confirmation"; 
	      String name=(String)request.getAttribute("FirstName");
	      String Oid=(String)request.getAttribute("orderid");
	      String msg=" Hi "+name+",\n \n Your order with orderid "+Oid+"has been placed successfully. \n for veiwing status of your order(s) login to your account."+
	                    "\n \n From, \n ZappyProject.com";
	      
	        String from = "iamlucky561@gmail.com";
			final String username = "iamlucky561@gmail.com";
			final String password = "Farzi12345";
			String host = "smtp.gmail.com";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(sub);
				message.setText(msg);

				Transport.send(message);
	         PrintWriter out=response.getWriter();
	        System.out.println(" message sent successfully....");
	        
	        response.sendRedirect("OrderPlaced");
			 
	         } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
