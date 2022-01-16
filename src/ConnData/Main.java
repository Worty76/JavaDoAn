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

import DetailsDepartment.DetailsEmsJoinedDepartment;
import DetailsProject.DetailsEmsJoinedProject;
import Detailshumanresource.DetailsHR;
import Detailshumanresource.HMhavejoined;
import Detailshumanresource.HMhaventjoined;
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
public class Main extends javax.swing.JFrame  {

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
	private Color myWhite = new Color(230, 232, 210);
	private Color ADD = new Color(35, 78, 112);
	private Color EXIT = new Color(200, 52, 2);
	private Color REFRESH = new Color(138, 187, 17);
	private Color redirect = new Color(167, 190, 174);
	private JTextField txtEmail;
	Panel HRcontainer = new Panel();
	private static JTable table_1;
	private JTextField txtIdProject;
	private JTextField txtNameProject;
	private JTextField txtNOE;
	JPanel ProjectContainer = new JPanel();
	JPanel DepartmentContainer = new JPanel();
	private JTextField textIdProject;
	private JTextField txtIdDepart;
	private static JTable table_2;
	private JTextField txtNameDepart;
	private JTextField txtNOEDepart;
	private JTextField textIDDP;
	JPanel animation1 = new JPanel();
	JPanel animation3 = new JPanel();
	JPanel animation2 = new JPanel();
	private JTextField txtIdProjectDetails;
	private JTextField txtIdDepartmentDetails;
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
//				
//					SplashScreen.execute = new SplashScreen();
					Main frame = new Main();
					frame.setVisible(true);
					frame.setTitle("Human Resource Management");
                                     
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/ConnData/606587.png"))); 
		
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(515, 11, 342, 51);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_3 = new JLabel("Hello!");
		lblNewLabel_3.setText("Hello ");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(32, 18, 163, 36);
	
		contentPane.add(lblNewLabel_3);
		
		animation1.setVisible(false);
		animation3.setVisible(false);
		JButton btnProject = new JButton("Projects");
		btnProject.setForeground(Color.BLACK);
		btnProject.setBackground(redirect);
		btnProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRcontainer.setVisible(false);
				ProjectContainer.setVisible(true);
				DepartmentContainer.setVisible(false);
				animation1.setVisible(true);
				animation3.setVisible(false);
				animation2.setVisible(false);
				
			}
		});
		btnProject.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnProject.setBounds(960, 19, 111, 36);
		contentPane.add(btnProject);
		
		
		JComboBox cbGender = new JComboBox();
		cbGender.setBounds(1113, 162, 109, 36);
		cbGender.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		HRcontainer.add(cbGender);
		
		JButton btnProject_1 = new JButton("Department");
		btnProject_1.setForeground(Color.BLACK);
		btnProject_1.setBackground(redirect);
		btnProject_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentContainer.setVisible(true);
				HRcontainer.setVisible(false);
				ProjectContainer.setVisible(false);
				animation1.setVisible(false);
				animation3.setVisible(true);
				animation2.setVisible(false);
				
			}
		});
		btnProject_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnProject_1.setBounds(1202, 19, 138, 36);
		contentPane.add(btnProject_1);
	
		JButton btnHumanResource = new JButton("HR");
		btnHumanResource.setForeground(Color.BLACK);
		btnHumanResource.setBackground(redirect);
		btnHumanResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRcontainer.setVisible(true);
				ProjectContainer.setVisible(false);
				DepartmentContainer.setVisible(false);
				animation1.setVisible(false);
				animation3.setVisible(false);
				animation2.setVisible(true);
			}
		});
		btnHumanResource.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnHumanResource.setBounds(1081, 19, 111, 36);
		contentPane.add(btnHumanResource);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(1025, 585, 93, 36);
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
						st.setEmail(txtEmail.getText());
						if(textIdProject.getText().length() == 0 && textIDDP.getText().length() == 0) {
							
						} else if (textIdProject.getText().length() > 0 && textIDDP.getText().length() == 0) {
							st.setIdProject(textIdProject.getText());
						} else if (textIdProject.getText().length() == 0 && textIDDP.getText().length() > 0) {
							st.setIdDepartment(textIDDP.getText());
						} else if(textIdProject.getText().length() > 0 && textIDDP.getText().length() > 0) {
							st.setIdProject(textIdProject.getText());
							st.setIdDepartment(textIDDP.getText());
						}

						ConnJDBC.insert(st);
						showData(ConnJDBC.findAll());
						showDataPR(ConnJDBC.findAllPR());
						showDataDP(ConnJDBC.findAllDP());
					
						
						
						
						} else {
							if(ProjectContainer.isVisible()) {
							Project st = new Project();
							st.setIdProject(txtIdProject.getText());
							st.setNameProject(txtNameProject.getText());
							st.setNOE(Integer.parseInt(txtNOE.getText()));
							ConnJDBC.insertPR(st);
							showDataPR(ConnJDBC.findAllPR());
							} else {
								Department st = new Department();
								st.setIdDepartment(txtIdDepart.getText());
								st.setNameDepartment(txtNameDepart.getText());
								st.setNumbersOfEmployeesDepart(txtNOEDepart.getText());			
								ConnJDBC.insertDP(st);
								showDataDP(ConnJDBC.findAllDP());
							}
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			btnNewButton.setBackground(ADD);
			btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPane.add(btnNewButton);
			
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBounds(1229, 585, 96, 36);
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
	                    if(HRcontainer.isVisible()) {
	                    	 HR st=new HR();
	 	  					st.setIdHumanResource(txtID.getText());
	 	  					ConnJDBC.delete(st);		 
	 	  					showData(ConnJDBC.findAll()); 
	 	  					showDataPR(ConnJDBC.findAllPR());   
                    		showDataDP(ConnJDBC.findAllDP()); 
	                    } else {
	                    	if(ProjectContainer.isVisible()) {
	                    		Project st = new Project();
	                    		st.setIdProject(txtIdProject.getText());
	                    		ConnJDBC.deletePR(st);
	                    		showDataPR(ConnJDBC.findAllPR());   
	                    		showDataDP(ConnJDBC.findAllDP()); 
	                    		showData(ConnJDBC.findAll()); 
	                    	}
	                    }
	                }
				}
			});
			
			btnDelete.setBackground(new Color(184, 80, 67));
			btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPane.add(btnDelete);
			
			JButton btnFind = new JButton("Find");
			btnFind.setBounds(1025, 627, 93, 36);
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HR st = new HR();
					
					if(txtName.getText().length()==0){
						showData(ConnJDBC.findAll());
					} else {
						st.setName(txtName.getText());
						showData(ConnJDBC.findByName(st));
					}
					
				}
			
			});
			
			btnFind.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPane.add(btnFind);
			btnFind.setBackground(redirect);
				
				JButton btnRefresh = new JButton("Refresh");
				btnRefresh.setForeground(Color.WHITE);
				btnRefresh.setBounds(1126, 585, 93, 36);
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtIDHM.setText("");
						txtName.setText("");
						txtAge.setText("");
						txtAddress.setText("");
						txtPosition.setText("");
						txtPart.setText("");
						txtWorkDay.setText("");
						txtEmail.setText("");
					}
				});
				btnRefresh.setBackground(REFRESH);
				btnRefresh.setFont(new Font("Century Gothic", Font.BOLD, 14));
				contentPane.add(btnRefresh);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setBounds(1126, 627, 93, 36);
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
				btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 14));
				contentPane.add(btnUpdate);
				btnUpdate.setBackground(redirect);
				
				JButton btnExit = new JButton("Exit");
				btnExit.setBounds(1229, 627, 96, 36);
				
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  System.exit(0);
					}
				});
				btnExit.setFont(new Font("Century Gothic", Font.BOLD, 14));
				contentPane.add(btnExit);
				btnExit.setBackground(redirect);
				txtID = new JTextField();
				txtID.setBounds(1229, 556, 96, 21);
				txtID.setHorizontalAlignment(SwingConstants.CENTER);
				txtID.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				contentPane.add(txtID);
				txtID.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("ID to delete");
				lblNewLabel_2.setBounds(1237, 542, 75, 14);
				lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 11));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(lblNewLabel_2);
				ProjectContainer.setBounds(20, 104, 1350, 470);
				contentPane.add(ProjectContainer);
				ProjectContainer.setLayout(null);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 15, 676, 348);
				ProjectContainer.add(scrollPane_1);
				
				table_1 = new JTable();
				table_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
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
				lblNewLabel_1_5_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1.setBounds(1021, 15, 93, 36);
				ProjectContainer.add(lblNewLabel_1_5_1);
				
				JLabel lblNewLabel_1_5_1_1 = new JLabel("Name Project:");
				lblNewLabel_1_5_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1_1.setBounds(1002, 65, 112, 36);
				ProjectContainer.add(lblNewLabel_1_5_1_1);
				
				JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Number Of Employees:");
				lblNewLabel_1_5_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1_1_1.setBounds(952, 111, 159, 36);
				ProjectContainer.add(lblNewLabel_1_5_1_1_1);
				
				txtIdProject = new JTextField();
				txtIdProject.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtIdProject.setColumns(10);
				txtIdProject.setBounds(1113, 16, 93, 36);
				ProjectContainer.add(txtIdProject);
				
				txtNameProject = new JTextField();
				txtNameProject.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtNameProject.setColumns(10);
				txtNameProject.setBounds(1113, 62, 136, 39);
				ProjectContainer.add(txtNameProject);
				
				txtNOE = new JTextField();
				txtNOE.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtNOE.setColumns(10);
				txtNOE.setBounds(1113, 112, 93, 36);
				ProjectContainer.add(txtNOE);
				
				JButton btnEmployeesInThe = new JButton("Employees in the project");
				btnEmployeesInThe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						DetailsEmsJoinedProject frame = new DetailsEmsJoinedProject();
						HR st = new HR();
						st.setIdProject(txtIdProjectDetails.getText());
						DetailsProject.DetailsEmsJoinedProject.showDataThoseWhoJoinedProject(ConnJDBC.findAllThoseInTheProject(st));
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						
					}
				});
				btnEmployeesInThe.setForeground(Color.BLACK);
				btnEmployeesInThe.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnEmployeesInThe.setBackground(new Color(167, 190, 174));
				btnEmployeesInThe.setBounds(841, 295, 231, 36);
				ProjectContainer.add(btnEmployeesInThe);
				
				JButton btnDetails_1_1 = new JButton("Details Project");
				btnDetails_1_1.setForeground(Color.BLACK);
				btnDetails_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnDetails_1_1.setBackground(new Color(167, 190, 174));
				btnDetails_1_1.setBounds(841, 248, 231, 36);
				ProjectContainer.add(btnDetails_1_1);
				
				txtIdProjectDetails = new JTextField();
				txtIdProjectDetails.setColumns(10);
				txtIdProjectDetails.setBounds(719, 250, 112, 34);
				ProjectContainer.add(txtIdProjectDetails);
				
				JLabel lblNewLabel_4_1 = new JLabel("ID Project");
				lblNewLabel_4_1.setBounds(744, 215, 67, 36);
				ProjectContainer.add(lblNewLabel_4_1);
				
				
				DepartmentContainer.setBounds(10, 68, 1320, 435);
				contentPane.add(DepartmentContainer);
				DepartmentContainer.setLayout(null);
				DepartmentContainer.setBackground(myWhite);
				
				txtIdDepart = new JTextField();
				txtIdDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtIdDepart.setColumns(10);
				txtIdDepart.setBounds(1103, 21, 126, 38);
				DepartmentContainer.add(txtIdDepart);
				
				JLabel lblNewLabel_1_5_1_2 = new JLabel("ID Department:");
				lblNewLabel_1_5_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1_2.setBounds(996, 21, 108, 30);
				DepartmentContainer.add(lblNewLabel_1_5_1_2);
				
				JScrollPane scrollPane_1_1 = new JScrollPane();
				scrollPane_1_1.setBounds(10, 29, 676, 348);
				DepartmentContainer.add(scrollPane_1_1);
				
				table_2 = new JTable();
				table_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				table_2.setModel(new DefaultTableModel(
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
					},
					new String[] {
						"ID Department", "Name Department", "Numbers of employees"
					}
				));
				scrollPane_1_1.setViewportView(table_2);
				
				txtNameDepart = new JTextField();
				txtNameDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtNameDepart.setColumns(10);
				txtNameDepart.setBounds(1103, 65, 126, 38);
				DepartmentContainer.add(txtNameDepart);
				
				txtNOEDepart = new JTextField();
				txtNOEDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtNOEDepart.setColumns(10);
				txtNOEDepart.setBounds(1103, 110, 126, 38);
				DepartmentContainer.add(txtNOEDepart);
				
				JLabel lblNewLabel_1_5_1_2_1 = new JLabel("Name Department:");
				lblNewLabel_1_5_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1_2_1.setBounds(965, 61, 130, 38);
				DepartmentContainer.add(lblNewLabel_1_5_1_2_1);
				
				JLabel lblNewLabel_1_5_1_2_1_1 = new JLabel("Number Of Employees:");
				lblNewLabel_1_5_1_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_5_1_2_1_1.setBounds(941, 110, 163, 36);
				DepartmentContainer.add(lblNewLabel_1_5_1_2_1_1);
				
				txtIdDepartmentDetails = new JTextField();
				txtIdDepartmentDetails.setBounds(696, 242, 126, 38);
				DepartmentContainer.add(txtIdDepartmentDetails);
				txtIdDepartmentDetails.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("⁯ID Department");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(714, 220, 87, 20);
				DepartmentContainer.add(lblNewLabel_4);
				
				JButton btnDetails_1_1_1 = new JButton("Employees in Department");
				btnDetails_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DetailsEmsJoinedDepartment frame = new DetailsEmsJoinedDepartment();
						HR st = new HR();
						st.setIdDepartment(txtIdDepartmentDetails.getText());
						DetailsDepartment.DetailsEmsJoinedDepartment.showDataThoseWhoJoinedDepartment(ConnJDBC.findAllThoseInTheDepartment(st));
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
				});
				btnDetails_1_1_1.setForeground(Color.BLACK);
				btnDetails_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnDetails_1_1_1.setBackground(new Color(167, 190, 174));
				btnDetails_1_1_1.setBounds(832, 242, 233, 38);
				DepartmentContainer.add(btnDetails_1_1_1);
				
				animation1.setBackground(new Color(184, 80, 67));
				animation1.setBounds(980, 59, 70, 3);
				contentPane.add(animation1);
				
			
				animation2.setBackground(new Color(184, 80, 67));
				animation2.setBounds(1101, 59, 70, 3);
				contentPane.add(animation2);
				
				animation3.setBackground(new Color(184, 80, 67));
				animation3.setBounds(1237, 59, 70, 3);
				contentPane.add(animation3);
				HRcontainer.setBounds(10, 68, 1350, 470);
				contentPane.add(HRcontainer);
				HRcontainer.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Name:");
				lblNewLabel_1.setBounds(1025, 68, 93, 36);
				lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1);
				
				
				JLabel lblNewLabel_1_1 = new JLabel("Age:");
				lblNewLabel_1_1.setBounds(1025, 115, 93, 36);
				lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_1_2 = new JLabel("Gender:");
				lblNewLabel_1_2.setBounds(1025, 162, 93, 36);
				lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_1_3 = new JLabel("Address:");
				lblNewLabel_1_3.setBounds(1025, 209, 93, 36);
				lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_3);
				
				JLabel lblNewLabel_1_4 = new JLabel("Position:");
				lblNewLabel_1_4.setBounds(1025, 256, 93, 36);
				lblNewLabel_1_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4);
				
				txtName = new JTextField();
				txtName.setBounds(1113, 69, 200, 36);
				txtName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				HRcontainer.add(txtName);
				txtName.setColumns(10);
				
				txtAge = new JTextField();
				txtAge.setBounds(1113, 115, 200, 36);
				txtAge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtAge.setColumns(10);
				HRcontainer.add(txtAge);
				
				txtPosition = new JTextField();
				txtPosition.setBounds(1113, 256, 200, 36);
				txtPosition.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtPosition.setColumns(10);
				HRcontainer.add(txtPosition);
				
				txtAddress = new JTextField();
				txtAddress.setBounds(1113, 209, 200, 36);
				txtAddress.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtAddress.setColumns(10);
				HRcontainer.add(txtAddress);
			
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(34, 21, 955, 343);
				HRcontainer.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, "", null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, "", null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
					},
					new String[] {
						"ID HumanResource", "Name", "Age", "Gender", "Position", "Part", "idProject", "idDepartment"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(70);
				table.getColumnModel().getColumn(0).setMinWidth(70);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(1).setMinWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(30);
				table.getColumnModel().getColumn(2).setMinWidth(30);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setMinWidth(40);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setMinWidth(30);
				table.getColumnModel().getColumn(5).setMinWidth(75);
				table.getColumnModel().getColumn(7).setPreferredWidth(100);
				table.getColumnModel().getColumn(7).setMinWidth(100);
				table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				
				JLabel lblNewLabel_1_5 = new JLabel("IDHM:");
				lblNewLabel_1_5.setBounds(1025, 21, 93, 36);
				lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_5);
				
				txtIDHM = new JTextField();
				txtIDHM.setBounds(1113, 21, 77, 36);
				txtIDHM.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtIDHM.setColumns(10);
				HRcontainer.add(txtIDHM);
				
				JLabel lblNewLabel_1_4_2 = new JLabel("Part:");
				lblNewLabel_1_4_2.setBounds(1025, 303, 93, 36);
				lblNewLabel_1_4_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_2);
				
				JLabel lblNewLabel_1_4_3 = new JLabel("WorkDay:");
				lblNewLabel_1_4_3.setBounds(1025, 350, 93, 36);
				lblNewLabel_1_4_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_3);
				
				txtPart = new JTextField();
				txtPart.setBounds(1113, 303, 200, 36);
				txtPart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtPart.setColumns(10);
				HRcontainer.add(txtPart);
				
				txtWorkDay = new JTextField();
				txtWorkDay.setBounds(1113, 350, 200, 36);
				txtWorkDay.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtWorkDay.setColumns(10);
				HRcontainer.add(txtWorkDay);
				
				txtEmail = new JTextField();
				txtEmail.setBounds(1113, 397, 200, 36);
				txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 14));
				txtEmail.setColumns(10);
				HRcontainer.add(txtEmail);
				
				JLabel lblNewLabel_1_4_3_1 = new JLabel("Email:");
				lblNewLabel_1_4_3_1.setBounds(1025, 397, 93, 36);
				lblNewLabel_1_4_3_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				HRcontainer.add(lblNewLabel_1_4_3_1);
				
				textIdProject = new JTextField();
				textIdProject.setBounds(860, 380, 109, 31);
				HRcontainer.add(textIdProject);
				textIdProject.setColumns(10);
				
				JLabel lblNewLabel_1_4_3_1_1 = new JLabel("ID Project:");
				lblNewLabel_1_4_3_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_4_3_1_1.setBounds(787, 375, 93, 36);
				HRcontainer.add(lblNewLabel_1_4_3_1_1);
				
				textIDDP = new JTextField();
				textIDDP.setBounds(860, 422, 109, 31);
				HRcontainer.add(textIDDP);
				textIDDP.setColumns(10);
				
				JLabel lblNewLabel_1_4_3_1_1_1 = new JLabel("ID Department:");
				lblNewLabel_1_4_3_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNewLabel_1_4_3_1_1_1.setBounds(752, 417, 128, 36);
				HRcontainer.add(lblNewLabel_1_4_3_1_1_1);
				
				JButton btnDetails = new JButton("Details Human Resources");
				btnDetails.setBounds(44, 375, 227, 36);
				HRcontainer.add(btnDetails);
				btnDetails.setForeground(Color.BLACK);
				btnDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DetailsHR frame = new DetailsHR();
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				btnDetails.setBackground(redirect);
				btnDetails.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				
				JButton btnHmHaventJoin = new JButton("HM havent joined");
				btnHmHaventJoin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HMhaventjoined frame = new HMhaventjoined();
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
				});
				btnHmHaventJoin.setForeground(Color.BLACK);
				btnHmHaventJoin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnHmHaventJoin.setBackground(new Color(167, 190, 174));
				btnHmHaventJoin.setBounds(296, 375, 171, 36);
				HRcontainer.add(btnHmHaventJoin);
				
				JButton btnHmHaveJoined = new JButton("HM have joined");
				btnHmHaveJoined.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HMhavejoined frame = new HMhavejoined();
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
				});
				btnHmHaveJoined.setForeground(Color.BLACK);
				btnHmHaveJoined.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnHmHaveJoined.setBackground(new Color(167, 190, 174));
				btnHmHaveJoined.setBounds(497, 375, 171, 36);
				HRcontainer.add(btnHmHaveJoined);
				HRcontainer.setVisible(true);
				
				
				
				ProjectContainer.setVisible(false);
			DepartmentContainer.setVisible(false);
			
		showData(ConnJDBC.findAll());
		showDataPR(ConnJDBC.findAllPR());
		showDataDP(ConnJDBC.findAllDP());
		
	
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
	    		gender,student.getPosition(), student.getPart(),
	    		student.getIdProject(), student.getIdDepartment()
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
	
	public static void showDataDP(List<Department>departmentList) {
		List<Department>departmentList1=new ArrayList<>();
		departmentList1=departmentList;
		DefaultTableModel tableModel;
	    table_2.getModel();
	    tableModel=(DefaultTableModel)table_2.getModel();
	    tableModel.setRowCount(0);
	    departmentList1.forEach((project) -> { 
	    	
	    	tableModel.addRow(new Object [] {
	    			project.getIdDepartment(),project.getNameDepartment(),
	    		project.getNumbersOfEmployeesDepart()
	    	});
	    });
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
