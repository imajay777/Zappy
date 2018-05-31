package controller;

import java.io.IOException;
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
 * Servlet implementation class ViewProductDescription
 */
@WebServlet("/ViewProductDescription")
public class ViewProductDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductDescription() {
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
		int p=Integer.parseInt(request.getParameter("pid"));
		
		ArrayList<addproductbean> list=new Mydao().singleproduct(p);
		if(list!=null) {
		RequestDispatcher rd=request.getRequestDispatcher("single.jsp");
		request.setAttribute("data", list);
		rd.forward(request, response);
		}
		else {
			System.out.println(list);
		}
		
		
		
		
	}

}
