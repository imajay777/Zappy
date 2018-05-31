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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;

/**
 * Servlet implementation class Forgetpassword
 */
@WebServlet("/Forgetpassword")
public class Forgetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgetpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("EmailId");

		String pass = new Mydao().ForgetPassword(email);
		if (pass != null) {
			String to = email;
			String sub = "Zappy Account Password";
			String msg = " Hi,\r\n" + "\r\n" + "Greetings!\r\n" + "\r\n"
					+ "You are just a step away from accessing your Zappy account\r\n" + "\r\n"
					+ "We are sharing a password to access your account.\r\n" + "\r\n" + "\r\n" + "Your Password: "
					+ pass + "\r\n" +

					"\r\n" + "Best Regards,\r\n" + "Team Zappy ";
			// Sender's email ID needs to be mentioned
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
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Your Password Has Been Sent To Your Email Address");
				//request.setAttribute("pagename1", "Index");
				rd.forward(request, response);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "Email id Does Not Exist");
			rd.forward(request, response);
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
