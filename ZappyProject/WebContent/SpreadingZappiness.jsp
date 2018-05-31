<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

</body>
</html><!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<html>
<head>
<title>Free Snow Bootstrap Website Template | Shop :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/dropdown.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/jquery.min.js"></script>
<script src="js/dorpdown.js"></script>
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
<% 
HttpSession session1 =request.getSession();
String Name=(String)session.getAttribute("FirstName");
%>
<% 
if(Name !=null){
	%>
	<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    	<ul class="nav" id="nav">
						    	<li><a href="ShowProduct">Shop</a></li>
						    	<li><a href="SpreadingZappiness.jsp">Spreading Zappiness</a></li>
								<li><a href="contact.jsp">Contact</a></li>
								<li><a href="cart.jsp">Cart</a></li>
								 <div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Welcome <% out.print(Name); %></button>
  <div id="myDropdown" class="dropdown-content">
    <a href="UpdateProfile">Profile</a>
    <a href="InvalidateJava">Logout</a>
  </div>
</div> 
								
															
								<div class="clear"></div>
							</ul>
							</ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
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
				<h2>Zappy is all about Spreading Happiness</h2>
<p>Zappy is an endeavor to not just spread happiness amongst our 
customers, but also to take small steps towards making the world a 
better place. Bringing amazing instant food products to you brings us a 
lot of happiness (Zappyness we call it!) and therefore we want to share 
it with the world. Just like the products we make, happiness can be 
instant too if we all joined hands together.</p>
<p>We know, it doesn’t take a lot of effort to bring a smile on 
someone’s face, and that is what we aim to achieve. With this thought, 
we join hands with <strong>Smile Foundation</strong> to work for the education, health and welfare of underprivileged children in India.</p>
<p>Through Smile, Zappy will reach out to the rural masses and initiate 
several projects and activities in Mumbai and in the states of 
Chattisgarh, Madhya Pradesh and Karnataka.</p>
<p>Zappy is a part of <strong>Mission Education - Smile Foundations’</strong>
 ongoing initiative to provide education to needy students. Through 
Cause Related Marketing, Zappy will provide financial assistance to this
 project. Every pack of Zappy that you buy, we will contribute Re. 1 to 
Smile <strong>Mission Education.</strong></p>
<p>It is our way of Spreading Zappiness to one and all. Let’s make this world a Happy World together.</p>

</div>
<img src="images/cloudbg.png" />
	</div>
	
				</a></div>
			</div>
		 </div>
	   </div>
	  </div>
	
	
	</form>
	<% 
}else{
%>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    	<ul class="nav" id="nav">
						    	<li><a href="ShowProduct">Store</a></li>
						    	<li><a href="Spreading Zappiness.jsp">Spreading Zappiness</a></li>
								<li><a href="contact.jsp">Contact</a></li>
								<li><a href="cart.jsp">Cart</a></li>
								<li><a href="login.jsp">Login/Signup</a></li>
				      			<li><a href="admin.jsp">Admin</a></li>
								<div class="clear"></div>
							</ul>
							</ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
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
			<h2>Zappy is all about Spreading Happiness</h2>
<p>Zappy is an endeavor to not just spread happiness amongst our 
customers, but also to take small steps towards making the world a 
better place. Bringing amazing instant food products to you brings us a 
lot of happiness (Zappyness we call it!) and therefore we want to share 
it with the world. Just like the products we make, happiness can be 
instant too if we all joined hands together.</p>
<p>We know, it doesn’t take a lot of effort to bring a smile on 
someone’s face, and that is what we aim to achieve. With this thought, 
we join hands with <strong>Smile Foundation</strong> to work for the education, health and welfare of underprivileged children in India.</p>
<p>Through Smile, Zappy will reach out to the rural masses and initiate 
several projects and activities in Mumbai and in the states of 
Chattisgarh, Madhya Pradesh and Karnataka.</p>
<p>Zappy is a part of <strong>Mission Education - Smile Foundations’</strong>
 ongoing initiative to provide education to needy students. Through 
Cause Related Marketing, Zappy will provide financial assistance to this
 project. Every pack of Zappy that you buy, we will contribute Re. 1 to 
Smile <strong>Mission Education.</strong></p>
<p>It is our way of Spreading Zappiness to one and all. Let’s make this world a Happy World together.</p>
<img src="images/cloudbg.png" />
</div>

	</div>
	

				</a></div>
			</div>
		 </div>
	   </div>
	  </div>


<% 
}
%>

		  <div class="footer">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Customer Support</h4>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Shipping and Order Tracking</a></li>
							<li><a href="#">Easy Returns</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Newsletter</h4>
							<div class="footer_search">
				    		   <form>
				    			<input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
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
			           <p>Â© 2014 Template by <a href="http://w3layouts.com" target="_blank">w3layouts</a></p>
		            </div>			        
   				</div>
			</div>
		</div>
</body>	
</html>