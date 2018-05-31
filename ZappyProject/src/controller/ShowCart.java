package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.addproductbean;
import dao.Mydao;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip=null;
		int count=0;
		String user=null;
		HttpSession hs= request.getSession();
		String userid=(String)hs.getAttribute("FirstName");
		if(userid==null) {
			ip=new Mydao().ipAdd();
			
			}
			else {
				
				ip=userid;
		//		System.out.println("Login HAi "+ip );
			}
		
		ArrayList<addproductbean> list=new Mydao().showCart(ip);
		count=new Mydao().count(user);
		if(list!=null) {
				RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
				request.setAttribute("ip", ip);
				request.setAttribute("data", list);
				request.setAttribute("count", count);
				
				rd.forward(request, response);
		}else {
				RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
				request.setAttribute("msg", "your cart is Empty");
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
