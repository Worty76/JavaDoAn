package ConnData;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;


public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3307/studentmn";
	static String user="root";
	static String password="";
	
	public static Connection getConnection() { // connection function
		Connection connection = null;
		
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
	
}
	
	
	
	 public static List<HR> findAll(){
		 List<HR> studentList = new ArrayList<>();
		 String query = "SELECT * FROM humanresource";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),
						 rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),
						 rs.getString("address"),
						 rs.getString("position"),
						 rs.getString("part"),
						 rs.getInt("workDay"),
						 rs.getString("experience")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static void insert(HR st) {
		 String query="insert into humanresource(idHumanResource,name,age,gender,address,position,part,workDay,experience) values(?,?,?,?,?,?,?,?,?);";
		 
		 try {
			 Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(query);
			 pstmt.setString(1, st.getIdHumanResource());
			 pstmt.setString(2, st.getName());
			 pstmt.setInt(3, st.getAge());
			 pstmt.setInt(4, st.getGender());	
			 pstmt.setString(5, st.getAddress());
			 pstmt.setString(6, st.getPosition());
			 pstmt.setString(7, st.getPart());
			 pstmt.setInt(8, st.getWorkDay());
			 pstmt.setString(9, st.getExperience());
			 pstmt.execute();
		 } catch (Exception e ) {	
			 JOptionPane.showMessageDialog(null, "The idhm is duplicated!", "Error", JOptionPane.ERROR_MESSAGE);
			 System.out.println("rr here");
		 }
	 } 

	 public static void delete(HR st) {
		 String query="delete from humanresource where id ='"+ st.getIdHumanResource()+ "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	 }
	
	 public static void Update(HR st) {
		String query = "Update humanresource set idHumanResource=?,name=?,age=?,gender=?,address=?,position=?,part=?,workDay=?,experience=? where id='"+st.getIdHumanResource()+"'";
		
		 try {
			Connection connection = getConnection();
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setString(1, st.getIdHumanResource());
			 pstmt.setString(2, st.getName());
			 pstmt.setInt(3, st.getAge());
			 pstmt.setInt(4, st.getGender());	
			 pstmt.setString(5, st.getAddress());
			 pstmt.setString(6, st.getPosition());
			 pstmt.setString(7, st.getPart());
			 pstmt.setInt(8, st.getWorkDay());
			 pstmt.setString(9, st.getExperience());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Not Found! ");
		}
	 }	

	 public static List<HR> findByName(HR s) {
		 List<HR> studentl = new ArrayList<>();
		 String query = "SELECT * FROM humanresource, where name='"+ s.getName() +"'";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("address"),rs.getString("position"), rs.getString("part"), rs.getInt("workDay"), rs.getString("experience"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }

//-------------------------------------------------------------------crud 2--------------------------------------------------------------
	 
	 public static void insertPR(Project st) {
		 String query="insert into projects(idProject,nameProject,numberOfEmployees) values(?,?,?);";
		 
		 try {
			 Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(query);
			 pstmt.setString(1, st.getIdProject());
			 pstmt.setString(2, st.getNameProject());
			 pstmt.setInt(3, st.getNOE());
			 pstmt.execute();
		 } catch (Exception e ) {	
			 
			 System.out.println("rr here");
		 }
	 } 
	 public static List<Project> findAllPR(){
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees")
						 );
				 projectList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }

	 
	 
}