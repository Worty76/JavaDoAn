package Update;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnData.ConnJDBC;
import ConnData.HR;
import ConnData.Project;

import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateHR extends JFrame {

	private JPanel contentPane;
	public static JTextField textUpdateName;
	public static JTextField textUpdateAge;
	public static JTextField textUpdateAddress;
	public static JTextField textUpdatePosition;
	public static JTextField textUpdatePart;
	public static JTextField textUpdateWorkDay;
	public static JTextField textUpdateEmail;
	public static JTextField textUpdateIdProject;
	public static JTextField textUpdateIdDepartment;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UpdateHR frame = new UpdateHR();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateHR(String input) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUpdateName = new JTextField();
		textUpdateName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateName.setColumns(10);
		textUpdateName.setBounds(397, 85, 200, 36);
		contentPane.add(textUpdateName);
		
		textUpdateAge = new JTextField();
		textUpdateAge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateAge.setColumns(10);
		textUpdateAge.setBounds(397, 132, 200, 36);
		contentPane.add(textUpdateAge);
		
		textUpdateAddress = new JTextField();
		textUpdateAddress.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateAddress.setColumns(10);
		textUpdateAddress.setBounds(397, 179, 200, 36);
		contentPane.add(textUpdateAddress);
		
		textUpdatePosition = new JTextField();
		textUpdatePosition.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdatePosition.setColumns(10);
		textUpdatePosition.setBounds(397, 38, 200, 36);
		contentPane.add(textUpdatePosition);
		
		textUpdatePart = new JTextField();
		textUpdatePart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdatePart.setColumns(10);
		textUpdatePart.setBounds(397, 226, 200, 36);
		contentPane.add(textUpdatePart);
		
		textUpdateWorkDay = new JTextField();
		textUpdateWorkDay.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateWorkDay.setColumns(10);
		textUpdateWorkDay.setBounds(397, 273, 200, 36);
		contentPane.add(textUpdateWorkDay);
		
		textUpdateEmail = new JTextField();
		textUpdateEmail.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateEmail.setColumns(10);
		textUpdateEmail.setBounds(397, 320, 200, 36);
		contentPane.add(textUpdateEmail);
		
		textUpdateIdProject = new JTextField();
		textUpdateIdProject.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateIdProject.setColumns(10);
		textUpdateIdProject.setBounds(397, 367, 200, 36);
		contentPane.add(textUpdateIdProject);
		
		textUpdateIdDepartment = new JTextField();
		textUpdateIdDepartment.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textUpdateIdDepartment.setColumns(10);
		textUpdateIdDepartment.setBounds(397, 414, 200, 36);
		contentPane.add(textUpdateIdDepartment);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(397, 461, 200, 36);
		contentPane.add(textField_9);
		
	
		Update2(input);
	
	
	}
	 public static void Update2(String st) {
			String query = "select * from humanresource where idHumanResource = '" + st + "'";
			 try {
				 Connection connection = ConnJDBC.getConnection();
				 Statement stmt = connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
					while(rs.next()) {
						textUpdateName.setText(rs.getString("name"));
//						textUpdateAge.setText(Integer.parseInt(rs.getInt("age")));
						textUpdateAddress.setText(rs.getString("address"));
						textUpdatePosition.setText(rs.getString("Position"));
						textUpdatePart.setText(rs.getString("part"));
//						textUpdateWorkDay.setText(rs.getInt("workDay"));
						textUpdateEmail.setText(rs.getString("email"));
						textUpdateIdProject.setText(rs.getString("idProject"));
						textUpdateIdDepartment.setText(rs.getString("idDepartment"));
					}
			} catch (Exception e) {
				// TODO: handle exception	
				JOptionPane.showMessageDialog(null, "Not Found! ");
			}
			
		 }	
		

}
