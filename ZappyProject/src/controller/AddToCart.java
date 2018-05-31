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
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String ip=null;
		HttpSession hs=request.getSession();
		String user=(String)hs.getAttribute("FirstName");
		if(user==null) {
		ip=new Mydao().ipAdd();
		int x=new Mydao().addtocart(pid,quantity,ip);
		if (x!=0) {
			ArrayList<addproductbean> list=new Mydao().ViewAllProduct();
			RequestDispatcher rd= request.getRequestDispatcher("shopss.jsp");
			request.setAttribute("msg", "item added to cart");
			request.setAttribute("data", list);
			rd.forward(request,response);
		}
		}
		else {
			
			int x=new Mydao().addtocart(pid,quantity,user);
			if (x!=0) {
				ArrayList<addproductbean> list=new Mydao().ViewAllProduct();
				RequestDispatcher rd= request.getRequestDispatcher("shopss.jsp");
				request.setAttribute("msg", "item added to cart");
				request.setAttribute("data", list);
				rd.forward(request,response);
			}
		}
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
