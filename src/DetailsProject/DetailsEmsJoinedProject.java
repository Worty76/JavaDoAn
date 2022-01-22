package DetailsProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConnData.ConnJDBC;
import ConnData.HR;
import ConnData.Main;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DetailsEmsJoinedProject extends JFrame {

	private JPanel contentPane;
	public static JTable table5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					DetailsEmsJoinedProject frame = new DetailsEmsJoinedProject();
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
	public DetailsEmsJoinedProject(String input) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 635, 342);
		contentPane.add(scrollPane);
		
		table5 = new JTable();
		table5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID Human Resource", "Name", "Age", "Gender", "Address", "Email", "ID Project"
			}
		));
		scrollPane.setViewportView(table5);
		
		JLabel lblNewLabel = new JLabel("Employees in the project");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 11, 481, 32);
		contentPane.add(lblNewLabel);
		
	}
	
	public static void showDataThoseWhoJoinedProject(List<HR>studentl) {
		List<HR>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel123;
	    table5.getModel();
	    tableModel123=(DefaultTableModel)table5.getModel();
	    tableModel123.setRowCount(0);
	    listStudent.forEach((student) -> { 
	    	String gender;
	    	if(student.getGender()==0)gender="Male";
	    	else {gender="Female";}
	    	tableModel123.addRow(new Object [] {
	    		student.getIdHumanResource() ,student.getName(),student.getAge(),
	    		gender,student.getAddress(), student.getEmail(), student.getIdProject()
	    	});
	    });
	    }
}
