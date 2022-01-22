package ConnData;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;


public class ConnJDBC {
	static String url="jdbc:sqlserver://WINDOWS-10\\SQLEXPRESS;databaseName=studentmn";
	static String user="sa"; 
	static String password="0388121738Wort";
	
	public static Connection getConnection() { // connection function
		Connection connection = null;	
		
		try {	
			connection=DriverManager.getConnection(url,user,password); 
			System.out.println("connected to sql server");
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
						 rs.getString("email"),
						 rs.getString("idProject"),
						 rs.getString("idDepartment")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static void insert(HR st) {
		 String query="insert into humanresource(idHumanResource,name,age,gender,address,position,part,workDay,Email,idProject,idDepartment) values(?,?,?,?,?,?,?,?,?,?,?);";
		 
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
			 pstmt.setString(9, st.getEmail());
			 pstmt.setString(10, st.getIdProject());
			 pstmt.setString(11, st.getIdDepartment());
			 pstmt.execute();
		 } catch (Exception e ) {	
			 JOptionPane.showMessageDialog(null, "Duplicating idhm or invalid idProject or idDepartment", "Error", JOptionPane.ERROR_MESSAGE);
			 System.out.println("rr here");
		 }
	 } 

	 public static void delete(String input) {
		 String query="delete from humanresource where idhumanresource ='"+ input + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	 }
	
	 public static void Update(HR st) {
		 String s = st.getIdProject();
		 String z = st.getIdDepartment();
		 String query = "";
		 if(s == "NULL" && z == "NULL") {
			 query = "ALTER TABLE humanresource NOCHECK CONSTRAINT ALL; Update humanresource set name=?,age=?,gender=?,address=?,position=?,part=?,workDay=?,Email=?,idProject=" + st.getIdProject() + ", idDepartment=" + st.getIdDepartment() + "  where idHumanResource='"+st.getIdHumanResource()+"'; ALTER TABLE humanresource CHECK CONSTRAINT ALL;";
		 } else if(s != "NULL" && z == "NULL") {
				query = "ALTER TABLE humanresource NOCHECK CONSTRAINT ALL; Update humanresource set name=?,age=?,gender=?,address=?,position=?,part=?,workDay=?,Email=?,idProject='" + st.getIdProject() + "', idDepartment=" + st.getIdDepartment() + "  where idHumanResource='"+st.getIdHumanResource()+"'; ALTER TABLE humanresource CHECK CONSTRAINT ALL;";

		 } else if(s == "NULL" && z != "NULL") {
				query = "ALTER TABLE humanresource NOCHECK CONSTRAINT ALL; Update humanresource set name=?,age=?,gender=?,address=?,position=?,part=?,workDay=?,Email=?,idProject=" + st.getIdProject() + ", idDepartment='" + st.getIdDepartment() + "'  where idHumanResource='"+st.getIdHumanResource()+"'; ALTER TABLE humanresource CHECK CONSTRAINT ALL;";

		 } else if(s != "NULL" && z != "NULL") {
				query = "ALTER TABLE humanresource NOCHECK CONSTRAINT ALL; Update humanresource set name=?,age=?,gender=?,address=?,position=?,part=?,workDay=?,Email=?,idProject='" + st.getIdProject() + "', idDepartment='" + st.getIdDepartment() + "'  where idHumanResource='"+st.getIdHumanResource()+"'; ALTER TABLE humanresource CHECK CONSTRAINT ALL;";
		 };
		
		 try {
			Connection connection = getConnection();
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, st.getName());
			 pstmt.setInt(2, st.getAge());
			 pstmt.setInt(3, st.getGender());	
			 pstmt.setString(4, st.getAddress());
			 pstmt.setString(5, st.getPosition());
			 pstmt.setString(6, st.getPart());
			 pstmt.setInt(7, st.getWorkDay());
			 pstmt.setString(8, st.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception	
			JOptionPane.showMessageDialog(null, "Not Found! ");
		}
	 }	
	 public static List<HR> findById(String input) {
		 List<HR> studentl = new ArrayList<>();
		 String query = "SELECT * FROM humanresource where idHumanResource ='" + input + "'";
		 
//		 + s.getAddress() + "'" + " and position = '" + s.getPosition() + "'" + " and part = '"
//			+ s.getPart() + "'" + " and workDay= '" + s.getWorkDay() + "'" + " and idProject = '" + s.getIdProject() + "'" + " and idDepartment= '" + s.getIdDepartment() + "'" ;
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("address"),rs.getString("position"), rs.getString("part"), rs.getInt("workDay"), rs.getString("Email"), 
						 rs.getString("idProject"), rs.getString("idDepartment"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }
	 public static List<HR> findByName(HR s) {
		 List<HR> studentl = new ArrayList<>();
		 String query = "SELECT * FROM humanresource where name like'%" + s.getName() + "%'";
		 
//		 + s.getAddress() + "'" + " and position = '" + s.getPosition() + "'" + " and part = '"
//			+ s.getPart() + "'" + " and workDay= '" + s.getWorkDay() + "'" + " and idProject = '" + s.getIdProject() + "'" + " and idDepartment= '" + s.getIdDepartment() + "'" ;
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("address"),rs.getString("position"), rs.getString("part"), rs.getInt("workDay"), rs.getString("Email"), 
						 rs.getString("idProject"), rs.getString("idDepartment"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }

	 public static void Update2(String st) {
			String query = "select * from humanresource where idHumanResource = '" + st + "'";
			 try {
				 Connection connection = getConnection();
				 Statement stmt = connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
					while(rs.next()) {
				 		 rs.getString("name");
						 rs.getInt("age");
						 rs.getInt("gender");
						 rs.getString("address");
						 rs.getString("position"); 
						 rs.getString("part");
						 rs.getInt("workDay");
						 rs.getString("Email"); 
						 rs.getString("idProject"); 
						 rs.getString("idDepartment");	
					}
			} catch (Exception e) {
				// TODO: handle exception	
				JOptionPane.showMessageDialog(null, "Not Found! ");
			}
			
		 }	
	 
	 
	 public static int numberHR() {
		 int rt = 0;
		 String query = "select count(idHumanResource) as 'soluong' from humanresource";
			 try {
				 Connection connection = getConnection();
				 Statement stmt = connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				 while (rs.next()) {
						rt = rs.getInt(1);
				 };
						 
			} catch (Exception e) {
				// TODO: handle exception	
			
			}
			return rt;
		 }	
	 public static int numberPR() {
		 int rt = 0;
		 String query = "select count(idProject) as 'soluong' from projects";
			 try {
				 Connection connection = getConnection();
				 Statement stmt = connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				 while (rs.next()) {
						rt = rs.getInt(1);
				 };
						 
			} catch (Exception e) {
				// TODO: handle exception	
			
			}
			return rt;
		 }	
	 public static int numberDP() {
		 int rt = 0;
		 String query = "select count(idDepartment) as 'soluong' from department";
			 try {
				 Connection connection = getConnection();
				 Statement stmt = connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				if(rs.next()) {
						rt = rs.getInt(1);
				 } else {
					 
				 }
						 
			} catch (Exception e) {
				// TODO: handle exception	
				
			}
			return rt;
		 }	
//-------------------------------------------------------------------crud project--------------------------------------------------------------
	 
	 public static void insertPR(Project st) {
		 String query="insert into projects(idProject,nameProject,numberOfEmployees,startingDay,endingDay) values(?,?,?,?,?);";
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		 
		 try {
			 Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(query);
			 pstmt.setString(1, st.getIdProject());
			 pstmt.setString(2, st.getNameProject());
			 pstmt.setInt(3, 0);
			 String s = sdf2.format(sdf.parse(st.getStartingDay()));
			 Date d = Date.valueOf(s);
			 pstmt.setDate(4,d);
			 String z = sdf2.format(sdf.parse(st.getEndingDay()));
			 Date c = Date.valueOf(z);
			 pstmt.setDate(5,c);
			 pstmt.execute();
		 } catch (Exception e ) {	
			 
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
						 rs.getInt("numberOfEmployees"),
						 rs.getString("startingDay"),
						 rs.getString("endingDay")
						 );
				 projectList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 public static void deletePR(String input) {
		 String query="delete from projects where idProject ='"+ input + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	 }

	 public static void UpdatePR(Project st) {
			String query = "Update projects set nameProject=?,startingDay=?,endingDay=? where idProject = '" + st.getIdProject() + "'";			
			 try {
				 
				 Connection connection = getConnection();
				 PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, st.getNameProject());
				 String s = st.getStartingDay();
				 Date d = Date.valueOf(s);
				 pstmt.setDate(2, d);
				 String z = st.getEndingDay();
				 Date c = Date.valueOf(z);
				 pstmt.setDate(3, c);
				 pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception	
				JOptionPane.showMessageDialog(null, "Not Found! ");
			}
		 }	
	 
	 public static List<Project> findbyIdProject(String input) {
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects where idProject = '" + input + "'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 rs.getString("endingDay"),
						 rs.getString("startingDay")
						 );
						 projectList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 public static List<Project> findbyNameProject(Project s) {
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects where nameProject like '" + s.getNameProject() + "%'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			 while(rs.next()) {
				 String z = sdf2.format(sdf.parse(rs.getString("startingDay")));
				 String d = sdf2.format(sdf.parse(rs.getString("endingDay")));
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 z,
						 d
						 );
						 projectList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 
	 public static List<Project> findbyStartingDay(Project s) {
		 
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects where nameProject like '%" + s.getNameProject() + "%'and startingDay like '%" + s.getStartingDay() + "%'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			 while(rs.next()) {
				 String z = sdf2.format(sdf.parse(rs.getString("startingDay")));
				 String d = sdf2.format(sdf.parse(rs.getString("endingDay")));
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 rs.getString("startingDay"),
						 rs.getString("endingDay")
						 );
						 projectList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 public static List<Project> findbyEndingDay(Project s) {
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects where nameProject like '%" + s.getNameProject() + "%'and startingDay like '%" + s.getStartingDay() + "%' and endingDay like '%" + s.getEndingDay() + "%'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			 while(rs.next()) {
				 String z = sdf2.format(sdf.parse(rs.getString("startingDay")));
				 String d = sdf2.format(sdf.parse(rs.getString("endingDay")));
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 z,
						 d
						 );
						 projectList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 
	 public static List<Project> findAllProjectsEnded(){
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * from projects where endingDay < GETDATE()";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 rs.getString("startingDay"),
						 rs.getString("endingDay")
						 );
				 projectList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
	 
		
	 public static List<Project> findAllPRtest(String input){
		 List<Project> projectList = new ArrayList<>();
		 String query = "SELECT * FROM projects where id = '" + input + "'";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Project st = new Project(
						 rs.getString("idProject"),
						 rs.getString("nameProject"),
						 rs.getInt("numberOfEmployees"),
						 rs.getString("startingDay"),
						 rs.getString("endingDay")
						 );
				 projectList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return projectList;
	 }
// ------------------------------------------------------------------ crud department-------------------------------------------------------------
	 
	 public static void insertDP(Department st) {
		 String query="insert into department(idDepartment,nameDepartment,numberOfEmployeesDepart) values(?,?,?);";
		 
		 try {
			 Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(query);
			 pstmt.setString(1, st.getIdDepartment());
			 pstmt.setString(2, st.getNameDepartment());
			 pstmt.setInt(3, 0);
			 pstmt.execute();
		 } catch (Exception e ) {	
			 
			 JOptionPane.showMessageDialog(null, e.getMessage());
		 }
	 } 
	 public static List<Department> findAllDP(){
		 List<Department> departmentList = new ArrayList<>();
		 String query = "SELECT * FROM department";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Department st = new Department(
						 rs.getString("idDepartment"),
						 rs.getString("nameDepartment"),
						 rs.getInt("numberOfEmployeesDepart")
						 );
				 departmentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return departmentList;
	 }
	 
	 
	 public static void deleteDP(String input) {
		 String query="delete from department where idDepartment ='"+ input + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	 }
	 public static void UpdateDP(Department st) {
		
			String query = "Update department set nameDepartment=? where idDepartment ='" + st.getIdDepartment() + "'";			
			 try {
				Connection connection = getConnection();
				PreparedStatement pstmt= connection.prepareStatement(query);
				 
				 pstmt.setString(1, st.getNameDepartment());
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception	
				JOptionPane.showMessageDialog(null, "Not Found! ");
			}
		 }	
	 public static List<Department> findbyNameDepartment(Department s) {
		 List<Department> departmentList  = new ArrayList<>();
		 String query = "SELECT * FROM department where nameDepartment like'" + s.getNameDepartment() + "%'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Department st = new Department(
						 rs.getString("idDepartment"),
						 rs.getString("nameDepartment"),
						 rs.getInt("numberOfEmployeesDepart")
						 );
				 departmentList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return departmentList;
	 }
	 public static List<Department> findbyIdDepartment(String input) {
		 List<Department> departmentList  = new ArrayList<>();
		 String query = "SELECT * FROM department where idDepartment ='" + input + "'";
		 
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Department st = new Department(
						 rs.getString("idDepartment"),
						 rs.getString("nameDepartment"),
						 rs.getInt("numberOfEmployeesDepart")
						 );
				 departmentList.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return departmentList;
	 }
	 
	 
	 
	// ------------------------------------------------------------ find those who have joined ----------------------------
	 
	 public static List<HR> findAllThoseWhoHaveJoined(){
		 List<HR> studentList = new ArrayList<>();
		 String query = "select * from humanresource where idProject <> ''";
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
						 rs.getString("email"),
						 rs.getString("idProject"),
						 rs.getString("idDepartment")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static List<HR> findAllThoseWhoHaveNotJoined(){
		 List<HR> studentList = new ArrayList<>();
		 String query = "select * from humanresource where idProject is null";
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
						 rs.getString("email"),
						 rs.getString("idProject"),
						 rs.getString("idDepartment")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static List<HR> findAllThoseInTheProject(String input){
		 List<HR> studentList = new ArrayList<>();
		 String query = " select * from humanresource where idProject = '" + input + "'";
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
						 rs.getString("email"),
						 rs.getString("idProject"),
						 rs.getString("idDepartment")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static List<HR> findAllThoseInTheDepartment(String input){
		 List<HR> studentList = new ArrayList<>();
		 String query = " select * from humanresource where idDepartment = '" + input + "'";
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
						 rs.getString("email"),
						 rs.getString("idProject"),
						 rs.getString("idDepartment")
						 );
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	
	 
	 
	//------------------------------------------------------FIND HELL --------------------------------------------------------------------------
	 //------------------------------------------------------WARNING!------------------------------------------------------------------------------

	 public static List<HR> findHell2(HR s) {
		 List<HR> studentl = new ArrayList<>();
		 String query = "SELECT * FROM humanresource where name like '" + s.getName() + "%'" +" and age like '" + s.getAge() + "%'";
		 
//		 + s.getAddress() + "'" + " and position = '" + s.getPosition() + "'" + " and part = '"
//			+ s.getPart() + "'" + " and workDay= '" + s.getWorkDay() + "'" + " and idProject = '" + s.getIdProject() + "'" + " and idDepartment= '" + s.getIdDepartment() + "'" ;
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("address"),rs.getString("position"), rs.getString("part"), rs.getInt("workDay"), rs.getString("Email"), 
						 rs.getString("idProject"), rs.getString("idDepartment"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }

	 public static List<HR> findHell3(HR s) {
		 List<HR> studentl = new ArrayList<>();
		 String query = "SELECT * FROM humanresource where name like '" + s.getName() + "%' and age like '" + s.getAge() + "%' and address like '" + s.getAddress() + "%'";
		  
//		 + s.getAddress() + "'" + " and position = '" + s.getPosition() + "'" + " and part = '"
//			+ s.getPart() + "'" + " and workDay= '" + s.getWorkDay() + "'" + " and idProject = '" + s.getIdProject() + "'" + " and idDepartment= '" + s.getIdDepartment() + "'" ;
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 HR st = new HR(rs.getString("idHumanResource"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("address"),rs.getString("position"), rs.getString("part"), rs.getInt("workDay"), rs.getString("Email"), 
						 rs.getString("idProject"), rs.getString("idDepartment"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }


































}