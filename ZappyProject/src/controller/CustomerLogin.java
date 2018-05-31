package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.Mydao;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u = request.getParameter("EmailId");
		String p = request.getParameter("Password");
		Mydao md = new Mydao();
		try {
			 System.out.println(u+p);
			//int user = Integer.parseInt(u);
			String name = md.CustomerLogin(u, p);
			if (name != null ) {
				System.out.println("hello");
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				session.setAttribute("FirstName", name);
				response.sendRedirect("index.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Login Fail,try again");
				rd.forward(request, response);
			}
		} catch (NumberFormatException e) {
			
		}
	}

}
