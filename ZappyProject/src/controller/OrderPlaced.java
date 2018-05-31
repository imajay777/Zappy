package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ordertable;
import dao.Mydao;

/**
 * Servlet implementation class OrderPlaced
 */
@WebServlet("/OrderPlaced")
public class OrderPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaced() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		String user=(String)hs.getAttribute("FirstName");
		 ArrayList<ordertable> o= new Mydao().DetailAfterPlacingOrder(user); 
		 if(o!=null) {
		 RequestDispatcher rd=request.getRequestDispatcher("OrderPlaced.jsp");
		
		  request.setAttribute("data", o);
          
    	  rd.forward(request, response);
		 }else {
			 out.println("error");
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
