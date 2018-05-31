package dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.addproductbean;
import bean.customerbean;
import bean.ordertable;

public class Mydao {
	
	
	public static Connection start() { 
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	
	
	
	public int AdminLogin(String u,String p)
	{
	int x=0;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from adminlogin where userid=? and password=?");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				x=1;
				}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return x;
	}

	public int addproduct(addproductbean e)
	{
  int z=0;		
		
  try {		
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
       PreparedStatement ps=con.prepareStatement("insert into addproduct(productname,category,productprice,weight,description,image) values(?,?,?,?,?,?)");
       ps.setString(1, e.getProductname());
       ps.setString(2, e.getCategory());
       ps.setDouble(3, e.getProductprice());
       ps.setInt(4, e.getWeight());
       ps.setString(5, e.getDescription());
       ps.setString(6, e.getImage());
       z=ps.executeUpdate();
    con.close();     
 }catch(Exception ex)
	{
		System.out.println(ex);
	}
		return z;
	}

		
	public ArrayList<addproductbean>ViewAllProduct()
	{
		ArrayList<addproductbean> ar=new ArrayList<>();
		
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
		        PreparedStatement ps=con.prepareStatement("select * from addproduct");
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {   
				   addproductbean e=new addproductbean();
				   e.setPid(rs.getInt("pid"));
				   e.setProductname(rs.getString("productname"));
				   e.setCategory(rs.getString("category"));
				   e.setProductprice(rs.getDouble("productprice"));
				   e.setWeight(rs.getInt("weight"));   
				   e.setDescription(rs.getString("description"));
				   e.setImage(rs.getString("Image"));
			  ar.add(e);
			   }
		     	con.close();	   
				   
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		return ar;
		
	}
	
	public int addtocart(String pid,String quantity,String user)
	{
  int z=0;		
		
  try {		
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
       PreparedStatement ps=con.prepareStatement("insert into cart(pid,quantity,user) values(?,?,?)");
       ps.setString(1, pid);
       ps.setString(2, quantity);
       ps.setString(3, user );
      
     int x=ps.executeUpdate();
       if(x!=0) {
    	   z=1;
       }
  		}catch(Exception ex)
	{
		System.out.println(ex);
	}
		return z;
	}
	
	
	public ArrayList<customerbean>ViewAllRegisteredCustomer()
	{
		ArrayList<customerbean> ar=new ArrayList<customerbean>();
		
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
		        PreparedStatement ps=con.prepareStatement("select * from customerdetails");
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {   
				   customerbean e=new customerbean();
				   e.setFirstname(rs.getString("FirstName"));
				   e.setLastname(rs.getString("LastName"));
				   e.setGender(rs.getString("Gender"));
				   e.setEmailid(rs.getString("Emailid"));   
				   e.setMobileno(rs.getString("Mobileno"));
				   e.setPassword(rs.getString("Password"));
			  ar.add(e);
			   }
		     	con.close();	   
				   
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		return ar;
		
	}
	
	
	
	
	public String ipAdd() {
		String  ipAddress=null;
		try {
			InetAddress	ipAddrs=InetAddress.getLocalHost();
			ipAddress=InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		return ipAddress;
	}
	
	
	public int insertCustomer( customerbean e)
	{
  int z=0;		
		
  try {		
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");
       PreparedStatement ps=con.prepareStatement("insert into customerdetails values(?,?,?,?,?,?)");
       ps.setString(1, e.getFirstname());
       ps.setString(2, e.getLastname());
       ps.setString(3, e.getGender());
       ps.setString(4, e.getEmailid()); 
       ps.setString(5, e.getMobileno());
       ps.setString(6, e.getPassword());
       
       z=ps.executeUpdate();
       	con.close();     
  		}catch(Exception ex)
	{
		System.out.println(ex);
	}
		return z;
	}
	
	
	public String CustomerLogin(String u,String p)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from customerdetails where EmailId=? and Password=?");
			ps.setString(1, u);
			ps.setString(2, p);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name=rs.getString("FirstName");
				return name;
				}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public String ForgetPassword(String user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
			PreparedStatement ps = con.prepareStatement("select password from customerdetails where Emailid=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String pass = rs.getString("Password");
				return pass;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
		
	
	
	public ArrayList<addproductbean>singleproduct(int pid) {
		ArrayList<addproductbean> ar=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from addproduct where pid=?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 addproductbean x=new addproductbean();
				x.setPid(rs.getInt("pid"));
				x.setProductname(rs.getString("productname"));
				x.setCategory(rs.getString("category"));
				x.setProductprice(rs.getDouble("productprice"));
				x.setWeight(rs.getInt("weight"));
				x.setDescription(rs.getString("description"));
				x.setImage(rs.getString("image"));
				
				ar.add(x);
				
				}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return ar;
	}
	
	
	
	public int placeOrder(String user, double amount, String orderid) {
		int q = 0;
		Connection con = start();
		try {
			PreparedStatement ps = con.prepareStatement(
					"select addproduct.pid,productprice,quantity from addproduct inner join cart on cart.pid=addproduct.pid where user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PreparedStatement ps1 = con
						.prepareStatement("Insert into orderplaced(oid,pid,quantity,amount,user) values(?,?,?,?,?)");
				ps1.setString(1, orderid);
				ps1.setInt(2, rs.getInt("pid"));
				ps1.setInt(3, rs.getInt("quantity"));
				ps1.setDouble(4, rs.getDouble("productprice"));
				ps1.setString(5, user);

				PreparedStatement ps2 = con.prepareStatement("delete from cart where user=?");
				ps2.setString(1, user);
				con.setAutoCommit(false);
				int y = ps1.executeUpdate();
				int z = ps2.executeUpdate();

				con.commit();
			}
			con.setAutoCommit(true);
			PreparedStatement pss = con.prepareStatement("insert into ordertable(oid,amount,user) values(?,?,?)");
			pss.setString(1, orderid);
			pss.setDouble(2, amount);
			pss.setString(3, user);
			q = pss.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return q;
	}

	public ArrayList<ordertable> DetailAfterPlacingOrder(String user) {
		ArrayList<ordertable> ordertable = new ArrayList<>();
		Connection con = start();
		String orderid = null;
		try {
			PreparedStatement ps1 = con.prepareStatement("select oid from ordertable where user=?");
			ps1.setString(1, user);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.last()) {
				orderid = rs1.getString("oid");
			}
			PreparedStatement ps = con.prepareStatement(
					"SELECT orderplaced.orderid,ordertable.date,ordertable.status,ordertable.oid,ordertable.amount FROM ordertable INNER JOIN orderplaced ON orderplaced.oid=ordertable.oid WHERE ordertable.oid=?");
			ps.setString(1, orderid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ordertable o = new ordertable();
				o.setOrderid(rs.getInt("orderid"));
				o.setDate(rs.getString("date"));
				o.setStatus(rs.getInt("status"));
				o.setAmount(rs.getDouble("amount"));
			
				ordertable.add(o);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ordertable;
	}
	
	
	
	
	
	
	
	
	public ArrayList<addproductbean> showCart(String ip) {
		ArrayList<addproductbean> ar=new ArrayList<>();
		
		 try {
			 	Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "");
			    PreparedStatement ps=con.prepareStatement("select productname,quantity,productprice,image,weight,addproduct.pid FROM addproduct INNER JOIN cart ON addproduct.pid = cart.pid where cart.user=?");
			    ps.setString(1, ip);
				   ResultSet rs=ps.executeQuery();
						   while(rs.next())
						   {   
							   addproductbean e=new addproductbean();
							   e.setProductname(rs.getString(1));
							   e.setQuantity(rs.getInt(2));
							   e.setProductprice(rs.getDouble(3));
							   e.setImage(rs.getString(4));
							   e.setWeight(rs.getInt(5));
							   e.setPid(rs.getInt(6));
							   ar.add(e);
						   }
					     		   
				   	   
				   }catch(Exception ex)
					{
						System.out.println(ex);
					}
		 return ar;
	}
	
	public int count(String user) {

		Connection con = Mydao.start();
		try {
			
			PreparedStatement ps = con.prepareStatement("select COUNT(user) FROM cart where user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int x = rs.getInt(1);
				return x;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return 0;
	}

	public int remove(String pid, String user) {
		Connection con = Mydao.start();
		int x = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from cart where pid=? and user=?");
			ps.setString(1, pid);
			ps.setString(2, user);

			x = ps.executeUpdate();
			if (x != 0) {
				return x;
			}

		} catch (Exception e) {

		}
		return x;
	}
	
		
	
}

