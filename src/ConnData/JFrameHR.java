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
public class JFrameHR extends JFrame {

	private JPanel contentPane;
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
	private JTextField txtExperience;
	
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
		setBounds(100, 100, 1366, 693);
		contentPane = new JPanel();
		contentPane.setBackground(myWhite);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1025, 117, 93, 36);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(1025, 164, 93, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(1025, 211, 93, 36);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(1025, 258, 93, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Position");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(1025, 305, 93, 36);
		contentPane.add(lblNewLabel_1_4);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setBounds(1113, 118, 200, 36);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(1113, 165, 200, 36);
		contentPane.add(txtAge);
		
		txtPosition = new JTextField();
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPosition.setColumns(10);
		txtPosition.setBounds(1113, 305, 200, 36);
		contentPane.add(txtPosition);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(1113, 258, 200, 36);
		contentPane.add(txtAddress);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(1113, 211, 109, 36);
		contentPane.add(cbGender);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnNewButton.setBackground(Color.RED);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnNewButton.setBackground(UIManager.getColor("control"));
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(1128, 556, 84, 36);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
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
		
		
		btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnDelete.setBackground(Color.CYAN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnDelete.setBackground(UIManager.getColor("control"));
		    }
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(1229, 556, 84, 36);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Find");
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
		btnFind.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnFind.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnFind.setBackground(UIManager.getColor("control"));
		    }
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(1025, 603, 93, 36);
		contentPane.add(btnFind);
		btnFind.setBorder(new LineBorder(Color.BLACK));
	
		
		JButton btnRefresh = new JButton("Refresh");
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
		btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnRefresh.setBackground(Color.BLUE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnRefresh.setBackground(UIManager.getColor("control"));
		    }
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(1025, 556, 93, 36);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HR st=new HR();
				st.setIdHumanResource(txtIDHM.getText());
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setAddress(txtAddress.getText());
				st.setPosition(txtPosition.getText());
				ConnJDBC.Update(st);
				JOptionPane.showMessageDialog(null, "Save Success! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnUpdate.setBackground(Color.PINK);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnUpdate.setBackground(UIManager.getColor("control"));
		    }
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(1128, 603, 84, 36);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 77, 955, 343);
		contentPane.add(scrollPane);
		
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
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  System.exit(0); 
			}
		});
		btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnExit.setBackground(Color.ORANGE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnExit.setBackground(UIManager.getColor("control"));
		    }
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(1229, 603, 84, 36);
		contentPane.add(btnExit);
		
		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtID.setBounds(1229, 509, 84, 36);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID to delete");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(1229, 493, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("IDHM");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(1025, 71, 93, 36);
		contentPane.add(lblNewLabel_1_5);
		
		txtIDHM = new JTextField();
		txtIDHM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDHM.setColumns(10);
		txtIDHM.setBounds(1113, 71, 77, 36);
		contentPane.add(txtIDHM);
		
		JLabel lblNewLabel = new JLabel("human resource management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(515, 11, 342, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Part");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_2.setBounds(1025, 352, 93, 36);
		contentPane.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("WorkDay");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_3.setBounds(1025, 399, 93, 36);
		contentPane.add(lblNewLabel_1_4_3);
		
		txtPart = new JTextField();
		txtPart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPart.setColumns(10);
		txtPart.setBounds(1113, 352, 200, 36);
		contentPane.add(txtPart);
		
		txtWorkDay = new JTextField();
		txtWorkDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkDay.setColumns(10);
		txtWorkDay.setBounds(1113, 399, 200, 36);
		contentPane.add(txtWorkDay);
		
		txtExperience = new JTextField();
		txtExperience.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtExperience.setColumns(10);
		txtExperience.setBounds(1113, 446, 200, 36);
		contentPane.add(txtExperience);
		
		JLabel lblNewLabel_1_4_3_1 = new JLabel("Experience");
		lblNewLabel_1_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_3_1.setBounds(1025, 446, 93, 36);
		contentPane.add(lblNewLabel_1_4_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome back ");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(10, 18, 163, 36);
		contentPane.add(lblNewLabel_3);
		showData(ConnJDBC.findAll());
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
	}
