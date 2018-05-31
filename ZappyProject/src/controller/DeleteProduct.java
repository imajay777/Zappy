package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.addproductbean;

import dao.Mydao;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();		
		String acn=request.getParameter("productname");
try {		
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
     PreparedStatement ps=con.prepareStatement("delete from addproduct where productname=?");
     ps.setString(1, acn);
	  int x=ps.executeUpdate();
	  if(x!=0)
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("viewallproduct.jsp");
			ArrayList<addproductbean> list=new Mydao().ViewAllProduct();
			request.setAttribute("data", list);
			request.setAttribute("msg", "Product Deleted of ProductName is = "+acn);
			rd.forward(request,response);
	  }  
     con.close();	   
		   
}catch(Exception e)
{
	System.out.println(e);
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
