import java.util.*;

import java.sql.*;


public class StudentService {
	
	public static void insert() throws ClassNotFoundException, SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstat =null;
		ResultSet rs=null;
		//write code for inserting record
		int id,m1,m2,m3;
		String name;
		System.out.println("Enter the Id: ");
		id=sc.nextInt();
		System.out.println("Enter the name of student: ");
		name=sc.next();
		System.out.println("Enter Marks for sub1(m1): ");
		m1=sc.nextInt();
		System.out.println("Enter Marks for sub2(m2): ");
		m2=sc.nextInt();
		System.out.println("Enter Marks for sub3(m3): ");
		m3=sc.nextInt();
		String sql="insert into student"+"(student_id,student_name,mark1,mark2,mark3)"+"values(?,?,?,?,?)";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1,id);
		pstat.setString(2, name);
		pstat.setInt(3, m1);
		pstat.setInt(4, m2);
		pstat.setInt(5, m3);
		int isInserted = pstat.executeUpdate();
		if(isInserted==1)
		{
			System.out.println("Data is inserted successfully!!");
		}
		
	}
	
	public static void delete() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fisglobal","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		System.out.println("Enter the Id: ");
		id=sc.nextInt();
		String sql = "delete from student where student_id=?";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1, id);
		int isDelted = pstat.executeUpdate();
		if(isDelted == 1)
			System.out.println("Record Deleted Succesfully!!");
	}
	
	public static void search() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fisglobal","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		System.out.println("Enter the Id: ");
		id=sc.nextInt();
		String sql = "select * from student where student_id=?";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1, id);
		rs=pstat.executeQuery();  
		while(rs.next())  
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+" "+rs.getInt(5));  
		}
	}
	
	public static void update() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fisglobal","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		String upadted_name;
		System.out.println("Enter the Id: ");
		id=sc.nextInt();
		System.out.println("Enter new Name: ");
		upadted_name = sc.next();
		
		String sql = "update student set student_name=? where student_id=?";
		pstat = con.prepareStatement(sql);
		
		pstat.setString(1, upadted_name);
		pstat.setInt(2, id);
		int isUpdated = pstat.executeUpdate();
		if(isUpdated == 1)
			System.out.println("Record Updated Succesfully!!");
	}
	
	public static void search1() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fisglobal","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		Statement stmt=con.createStatement();  
		rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+" "+rs.getInt(5));  
		}
	}
}
