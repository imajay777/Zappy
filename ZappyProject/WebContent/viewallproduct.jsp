<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Free Snow Bootstrap Website Template | Checkout :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
 </head>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="AdminHomePage.jsp"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    	<li><a href="addproduct.jsp">Add Product</a></li>
						    	<li><a href="ViewProduct">View All Product</a></li>
						    	<li><a href="viewpendingorder.html">View Pending Order</a></li>
								<li><a href="viewallorderhistory.html">View All Order History</a></li>
								<li><a href="ViewAllRegisteredCustomer">View All Registered Customer</a></li>
								<li><a href="InvalidateJava">Logout</a></li>							
								<div class="clear"></div>
							</ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
				    </div>							
	    		    <div class="clear"></div>
	    	    </div>
	           
		        <div class="clear"></div>
	       </div>
	      </div>
		 </div>
	    </div>
	  </div>
     <div class="main">
      <div class="shop_top">
		<div class="container">
			
				<% String s=(String)session.getAttribute("user");
					if(s==null)
						response.sendRedirect("index.jsp");
						
				%>
				<% response.addHeader("pragma", "no-cache");
						response.addHeader("cache-control", "no-store");
						response.addHeader("expire", "0");
					%>
					<%String m=(String)request.getAttribute("msg");
                if(m!=null){
                %>
                <script>alert("<%=m%>")</script>
                
                <%} %>
				<div class="col-md-12">
				 <div class="login-title">
	           		<h4 class="title">All Product Details</h4>
					<table border="1.5">
						
					<%@page import="java.util.ArrayList,bean.addproductbean" %>
					
	<center>				

<tr><th>Product Name</th><th>Category</th><th>Product Price</th><th>Weight</th><th>Description</th><th>Image</th><th>Delete</th><th>Update</th></tr>
<%
ArrayList<addproductbean> list=(ArrayList<addproductbean>)request.getAttribute("data");
    for(addproductbean e:list)
    {  	
    %>
    
    <tr>	
         	
    	<td><%=e.getProductname()%></td>
    	<td><%=e.getCategory()%></td>
    	<td><%=e.getProductprice()%></td>
    	<td><%=e.getWeight()%></td>
    	<td><%=e.getDescription()%></td>
    	<td><img src="imagesap/<%= e.getImage()%>" height="50" width="50"/></td>    	
    	
    		<td><a href="DeleteProduct?productname=<%=e.getProductname()%>">DELETE</a></td>
    		<td><a href="UpdateProduct?productname=<%=e.getProductname()%>">Edit</a></td>
    </tr>
     	
   <% 	
    }
%>
</center>
</table>
			      
				 <div class="clear"></div>
			  </div>
			</div>
		  </div>
	  </div>
	  <div class="footer">
			<div class="container">
				<div class="row">
					
					<div class="col-md-6">
						<ul class="footer_box">
							<h4>Customer Support</h4>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Shipping and Order Tracking</a></li>
							<li><a href="#">Easy Returns</a></li>

						</ul>
					</div>
					<div class="col-md-6">
						<ul class="footer_box">
							<h4>Newsletter</h4>
							<div class="footer_search">
				    		   <form>
				    			<input type="text" value="Enter your email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Enter your email';}">
				    			<input type="submit" value="Go">
				    		   </form>
					        </div>
							<ul class="social">	
							  <li class="facebook"><a href="#"><span> </span></a></li>
							  <li class="twitter"><a href="#"><span> </span></a></li>
							  <li class="instagram"><a href="#"><span> </span></a></li>	
							  <li class="pinterest"><a href="#"><span> </span></a></li>	
							  <li class="youtube"><a href="#"><span> </span></a></li>										  				
						    </ul>
		   				</ul>
					</div>
				</div>
				<div class="row footer_bottom">
				    <div class="copy">
			           <p>© 2014 Template by <a href="http://w3layouts.com" target="_blank">Praful Ojha</a></p>
		            </div>
					  
   				</div>
			</div>
		</div>
</body>	
</html>