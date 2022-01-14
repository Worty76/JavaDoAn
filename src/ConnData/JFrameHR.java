package ConnData;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Project.JframeProject;
import login.IDandPasswords;
import login.LoginPage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.*;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Panel;  
public class JFrameHR extends JFrame {

	private JPanel contentPane;
	private JPanel contentProject;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPosition;
	private JTextField txtAddress;
	private static JTable table;
	private static JTextField txtID;
	private JTextField txtIDHM;
	private static int result;
	private static boolean check = false;
	private JTextField txtPart;
	private JTextField txtWorkDay;
	private Color myWhite = new Color(208, 225, 199);
	private Color ADD = new Color(30, 41, 92);
	private Color EXIT = new Color(200, 52, 2);
	private Color REFRESH = new Color(138, 187, 17);
	private JTextField txtExperience;
	Panel HRcontainer = new Panel();
	private static JTable table_1;
	private JTextField txtIdProject;
	private JTextField txtNameProject;
	private JTextField txtNOE;
	JPanel ProjectContainer = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
				
//					IDandPasswords idandPasswords = new IDandPasswords();
//					
//					LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
					
					JFrameHR frame = new JFrameHR();
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
//String userID
	public JFrameHR() { 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 724);
		contentPane = new JPanel();
		contentPane.setBackground(myWhite);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		JLabel lblNewLabel = new JLabel("human resource management");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(515, 11, 342, 51);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_3 = new JLabel("Welcome back ");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(10, 18, 163, 36);
		contentPane.add(lblNewLabel_3);
		
		JButton btnProject = new JButton("Projects");
		btnProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRcontainer.setVisible(false);
				ProjectContainer.setVisible(true);
				
			}
		});
		btnProject.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnProject.setBounds(987, 19, 111, 36);
		contentPane.add(btnProject);
		
		JButton btnProject_1 = new JButton("Projects");
		btnProject_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnProject_1.setBounds(1229, 19, 111, 36);
		contentPane.add(btnProject_1);
		
		JButton btnHumanResource = new JButton("HR");
		btnHumanResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRcontainer.setVisible(true);
				ProjectContainer.setVisible(false);
			}
		});
		btnHumanResource.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnHumanResource.setBounds(1108, 19, 111, 36);
		contentPane.add(btnHumanResource);
		
		
		ProjectContainer.setBounds(10, 73, 1350, 435);
		contentPane.add(ProjectContainer);
		ProjectContainer.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 21, 652, 342);
		ProjectContainer.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"IDProject", "NameProject", "NumOfEployees"
			}
		));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(2).setMinWidth(80);
		scrollPane_1.setViewportView(table_1);
		
		ProjectContainer.setBackground(myWhite);
			
			JLabel lblNewLabel_1_5_1 = new JLabel("IDProject:");
			lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1_5_1.setBounds(1021, 15, 93, 36);
			ProjectContainer.add(lblNewLabel_1_5_1);
			
			JLabel lblNewLabel_1_5_1_1 = new JLabel("Name Project:");
			lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1_5_1_1.setBounds(1002, 65, 112, 36);
			ProjectContainer.add(lblNewLabel_1_5_1_1);
			
			JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Number Of Employees:");
			lblNewLabel_1_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1_5_1_1_1.setBounds(948, 112, 159, 36);
			ProjectContainer.add(lblNewLabel_1_5_1_1_1);
			
			txtIdProject = new JTextField();
			txtIdProject.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtIdProject.setColumns(10);
			txtIdProject.setBounds(1113, 16, 93, 36);
			ProjectContainer.add(txtIdProject);
			
			txtNameProject = new JTextField();
			txtNameProject.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNameProject.setColumns(10);
			txtNameProject.setBounds(1112, 66, 136, 36);
			ProjectContainer.add(txtNameProject);
			
			txtNOE = new JTextField();
			txtNOE.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNOE.setColumns(10);
			txtNOE.setBounds(1113, 112, 93, 36);
			ProjectContainer.add(txtNOE);
			HRcontainer.setBounds(0, 68, 1350, 440);
			contentPane.add(HRcontainer);
			HRcontainer.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Name:");
			lblNewLabel_1.setBounds(1025, 68, 93, 36);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			HRcontainer.add(lblNewLabel_1);
			
			
			JLabel lblNewLabel_1_1 = new JLabel("Age:");
			lblNewLabel_1_1.setBounds(1025, 115, 93, 36);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			HRcontainer.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Gender:");
			lblNewLabel_1_2.setBounds(1025, 162, 93, 36);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			HRcontainer.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Address:");
			lblNewLabel_1_3.setBounds(1025, 209, 93, 36);
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			HRcontainer.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Position:");
			lblNewLabel_1_4.setBounds(1025, 256, 93, 36);
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			HRcontainer.add(lblNewLabel_1_4);
			
			txtName = new JTextField();
			txtName.setBounds(1113, 69, 200, 36);
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			HRcontainer.add(txtName);
			txtName.setColumns(10);
			
			txtAge = new JTextField();
			txtAge.setBounds(1113, 115, 200, 36);
			txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtAge.setColumns(10);
			HRcontainer.add(txtAge);
			
			txtPosition = new JTextField();
			txtPosition.setBounds(1113, 256, 200, 36);
			txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPosition.setColumns(10);
			HRcontainer.add(txtPosition);
			
			txtAddress = new JTextField();
			txtAddress.setBounds(1113, 209, 200, 36);
			txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtAddress.setColumns(10);
			HRcontainer.add(txtAddress);
			
			JComboBox cbGender = new JComboBox();
			cbGender.setBounds(1113, 162, 109, 36);
			cbGender.setFont(new Font("Tahoma", Font.BOLD, 14));
			cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
			HRcontainer.add(cbGender);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(1128, 569, 93, 36);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(HRcontainer.isVisible()) {
						HR st = new HR();
						st.setIdHumanResource(txtIDHM.getText());
						st.setName(txtName.getText());
						st.setAge(Integer.parseInt(txtAge.getText()));
						st.setGender(cbGender.getSelectedIndex());
						st.setAddress(txtAddress.getText());
						st.setPosition(txtPosition.getText());
						st.setPart(txtPart.getText());
						st.setWorkDay(Integer.parseInt(txtWorkDay.getText()));
						st.setExperience(txtExperience.getText());
						ConnJDBC.insert(st);
						showData(ConnJDBC.findAll());
						} else {
							Project st = new Project();
							st.setIdProject(txtIdProject.getText());
							st.setNameProject(txtNameProject.getText());
							st.setNOE(Integer.parseInt(txtNOE.getText()));
							ConnJDBC.insertPR(st);
							showDataPR(ConnJDBC.findAllPR());
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			btnNewButton.setBackground(ADD);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnNewButton);
			
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBounds(1229, 569, 96, 36);
			btnDelete.setForeground(Color.WHITE);
			btnDelete.addActionListener(new ActionListener() {
				   @Override
				public void actionPerformed(ActionEvent e) {
					   Object[] options = {"Có, chắc rồi", "Không, tôi đã thay đổi ý định"};
	                 result = JOptionPane.showOptionDialog(null,
	                        "Bạn có chắc muốn xoá nhân sự này",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_CANCEL_OPTION,
	                        JOptionPane.QUESTION_MESSAGE,
	                        null,
	                        options,
	                        options[0]);
	                if(result == JOptionPane.YES_OPTION){
	                     HR st=new HR();
	  					st.setIdHumanResource(txtIDHM.getText());
	  					ConnJDBC.delete(st);		 
	  					showData(ConnJDBC.findAll());     
	                }
				}
			});
			
			btnDelete.setBackground(EXIT);
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnDelete);
			
			JButton btnFind = new JButton("Find");
			btnFind.setBounds(1025, 616, 93, 36);
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HR st = new HR();
					
					if(txtName.getText().length()==0){
						showData(ConnJDBC.findAll());
					} else {
						st.setName(txtName.getText());
						showData(ConnJDBC.findByName(st));
					}
			//		st.setName(txtName.getText());
				//	showData(ConnJDBC.findByName(st));
				}
			
			});
			
			btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnFind);
			
				
				JButton btnRefresh = new JButton("Refresh");
				btnRefresh.setBounds(1025, 569, 93, 36);
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtIDHM.setText("");
						txtName.setText("");
						txtAge.setText("");
						txtAddress.setText("");
						txtPosition.setText("");
						txtPart.setText("");
						txtWorkDay.setText("");
						txtExperience.setText("");
					}
				});
				btnRefresh.setBackground(REFRESH);
				btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
				contentPane.add(btnRefresh);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setBounds(1128, 616, 94, 36);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							HR st=new HR();
							st.setIdHumanResource(txtIDHM.getText());
							st.setName(txtName.getText());
							st.setAge(Integer.parseInt(txtAge.getText()));
							st.setGender(cbGender.getSelectedIndex());
							st.setAddress(txtAddress.getText());
							st.setPosition(txtPosition.getText());
							ConnJDBC.Update(st);
							
						} catch (Exception e2) {
							// TODO: handle exception
							
						}
						
						showData(ConnJDBC.findAll());
					}
				});
				btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
				contentPane.add(btnUpdate);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(34, 21, 955, 343);
				HRcontainer.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"ID HumanResource", "Name", "Age", "Gender", "Address", "Position", "Part", "WorkDay", "Experience"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(0).setMinWidth(100);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setMinWidth(50);
				table.getColumnModel().getColumn(3).setPreferredWidth(60);
				table.getColumnModel().getColumn(3).setMinWidth(0);
				table.getColumnModel().getColumn(4).setMinWidth(70);
				table.getColumnModel().getColumn(5).setMinWidth(30);
				table.getColumnModel().getColumn(6).setPreferredWidth(100);
				table.getColumnModel().getColumn(6).setMinWidth(100);
				table.getColumnModel().getColumn(8).setPreferredWidth(92);
				table.getColumnModel().getColumn(8).setMinWidth(92);
				table.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JButton btnExit = new JButton("Exit");
				btnExit.setBounds(1229, 616, 96, 36);
				
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  System.exit(0); 
					}
				});
				btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
				contentPane.add(btnExit);
				
				txtID = new JTextField();
				txtID.setBounds(1229, 535, 96, 23);
				txtID.setHorizontalAlignment(SwingConstants.CENTER);
				txtID.setFont(new Font("Tahoma", Font.PLAIN, 16));
				contentPane.add(txtID);
				txtID.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("ID to delete");
				lblNewLabel_2.setBounds(1239, 519, 75, 14);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_1_5 = new JLabel("IDHM:");
				lblNewLabel_1_5.setBounds(1025, 21, 93, 36);
				lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_5);
				
				txtIDHM = new JTextField();
				txtIDHM.setBounds(1113, 21, 77, 36);
				txtIDHM.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtIDHM.setColumns(10);
				HRcontainer.add(txtIDHM);
				
				JLabel lblNewLabel_1_4_2 = new JLabel("Part:");
				lblNewLabel_1_4_2.setBounds(1025, 303, 93, 36);
				lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_2);
				
				JLabel lblNewLabel_1_4_3 = new JLabel("WorkDay:");
				lblNewLabel_1_4_3.setBounds(1025, 350, 93, 36);
				lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_3);
				
				txtPart = new JTextField();
				txtPart.setBounds(1113, 303, 200, 36);
				txtPart.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPart.setColumns(10);
				HRcontainer.add(txtPart);
				
				txtWorkDay = new JTextField();
				txtWorkDay.setBounds(1113, 350, 200, 36);
				txtWorkDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtWorkDay.setColumns(10);
				HRcontainer.add(txtWorkDay);
				
				txtExperience = new JTextField();
				txtExperience.setBounds(1113, 397, 200, 36);
				txtExperience.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtExperience.setColumns(10);
				HRcontainer.add(txtExperience);
				
				JLabel lblNewLabel_1_4_3_1 = new JLabel("Experience:");
				lblNewLabel_1_4_3_1.setBounds(1025, 397, 93, 36);
				lblNewLabel_1_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_3_1);
			HRcontainer.setVisible(true);
			ProjectContainer.setVisible(false);
		showData(ConnJDBC.findAll());
		showDataPR(ConnJDBC.findAllPR());
		
	
	}
	public static void showData(List<HR>studentl) {
		List<HR>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listStudent.forEach((student) -> { 
	    	String gender;
	    	if(student.getGender()==0)gender="Male";
	    	else {gender="Female";}
	    	tableModel.addRow(new Object [] {
	    		student.getIdHumanResource() ,student.getName(),student.getAge(),
	    		gender,student.getAddress(),student.getPosition(), student.getPart(), student.getWorkDay(), student.getExperience()
	    	});
	    });
	    }
	public static void showDataPR(List<Project>projectList) {
		List<Project>projectList1=new ArrayList<>();
		projectList1=projectList;
		DefaultTableModel tableModel;
	    table_1.getModel();
	    tableModel=(DefaultTableModel)table_1.getModel();
	    tableModel.setRowCount(0);
	    projectList1.forEach((project) -> { 
	    	
	    	tableModel.addRow(new Object [] {
	    			project.getIdProject(),project.getNameProject(),
	    		project.getNOE()
	    	});
	    });
	    }
	}
