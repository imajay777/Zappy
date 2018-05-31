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
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String user=(String)hs.getAttribute("FirstName");
		String Emailid=(String)hs.getAttribute("user");
		long id=System.currentTimeMillis();
	     String orderid="Od-Id"+(id+"").substring(5);
		double amount=Double.parseDouble(request.getParameter("amount"));
		int x=new Mydao().placeOrder(user,amount,orderid);
		if(x!=0) {
		RequestDispatcher rd=request.getRequestDispatcher("OrderMail");
		request.setAttribute("Emailid", Emailid);
		request.setAttribute("orderid", orderid);
		 request.setAttribute("FirstName",user);
		 rd.forward(request, response);
		 
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
