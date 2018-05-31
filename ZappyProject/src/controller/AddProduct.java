package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.addproductbean;
import dao.Mydao;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 1000 * 4096;
	   private File file ;
	
	
    public AddProduct() {
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
		String productname=null;
        String category=null;
        String productprice=null;
        String weight=null;
        String description=null;
        String image=null;
        
		 response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
     
		  if( !isMultipart ){
            return;
     }
		  DiskFileItemFactory factory = new DiskFileItemFactory();
	      factory.setSizeThreshold(maxMemSize);
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      upload.setSizeMax( maxFileSize );
	      
	      try {
	    	  List fileItems = upload.parseRequest(request);
	          Iterator i = fileItems.iterator();
	      
	          
	          while ( i.hasNext())
	          {

	             FileItem fi = (FileItem)i.next();
	             if ( fi.isFormField () )
	             {
	                // Get the uploaded file parameters
	               String  fieldName = fi.getFieldName();
	               if(fieldName.equals("pn"))
	                 {
	            	  productname=fi.getString();
	                  
	                 }
	               if(fieldName.equals("cat"))
	               {
	            	   category=fi.getString();
	                
	               }
	               if(fieldName.equals("pp"))
	               {
	            	   productprice=fi.getString();
	               
	               }
	               if(fieldName.equals("wei"))
	               {
	            	   weight=fi.getString();
	               
	               }
	               if(fieldName.equals("des"))
	               {
	            	   description=fi.getString();
	                
	               }
	             }
	             else
	              {    
	            	 String fieldName = fi.getFieldName();

	                if(fieldName.equals("ima"))
	                {
	                 ServletConfig sc=getServletConfig();
	                 image=fi.getName();
	                  
	                  File f = new File(sc.getServletContext().getRealPath("/")+"imagesap") ;
	                     if(!f.exists())
	                    	 f.mkdir();
	                
	                  file = new File(sc.getServletContext().getRealPath("/")+"imagesap/"+image) ;
	                   fi.write( file ) ;
	                  out.println("Uploaded Filename: " +image + "<br>");
	                System.out.println("PATH="+file.getPath());
	                }
	             }
	          }
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	      
	    addproductbean e=new addproductbean();
		
		e.setProductname(productname);;
		e.setCategory(category);
		e.setProductprice(Double.parseDouble(productprice));
		e.setWeight(Integer.parseInt(weight));	
		e.setDescription(description);
		e.setImage(image);
	   
		Mydao m=new Mydao();
		int x=m.addproduct(e);
		if(x!=0)
	       {
		RequestDispatcher rd=request.getRequestDispatcher("addproduct.jsp");
		request.setAttribute("msg", "Product Added...");
		rd.forward(request, response);
	       }
	}

}
