package DetailsProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnData.ConnJDBC;
import ConnData.HR;
import ConnData.Project;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ProjectsEnded extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectsEnded frame = new ProjectsEnded();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectsEnded() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 635, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Project", "Name Project", "Number Of Employees", "Starting Day", "Ending Day"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Projects ended");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 11, 519, 42);
		contentPane.add(lblNewLabel);
		showDataProjectsEnded(ConnJDBC.findAllProjectsEnded());

	
	}
	
	public static void showDataProjectsEnded(List<Project>projectList) {
		List<Project>projectList1=new ArrayList<>();
		projectList1=projectList;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    
	    projectList1.forEach((project) -> { 
				tableModel.addRow(new Object [] {
	    			project.getIdProject(),project.getNameProject(),project.getNOE(), project.getStartingDay(),project.getEndingDay()
				});
	    });
	    }
}
