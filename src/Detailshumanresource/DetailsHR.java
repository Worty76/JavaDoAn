package Detailshumanresource;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnData.ConnJDBC;
import ConnData.HR;

import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DetailsHR extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtFindName;
	private JLabel lblNewLabel;
	private JTextField txtFindAge;
	private JTextField txtFindAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DetailsHR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 918, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"idHumanResource", "Name", "Age", "Address", "WorkDay", "Email"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnFindName = new JButton("FIND");
		btnFindName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HR st = new HR();
				
				if(txtFindName.getText().length()==0 && txtFindAge.getText().length() == 0 && txtFindAddress.getText().length() ==0){
					showDataDetailsHR(ConnJDBC.findAll());
				} else {
					if( txtFindName.getText().length() > 0 && txtFindAge.getText().length()>0 &&  txtFindAddress.getText().length() >0) {
				
						st.setName(txtFindName.getText());
						st.setAge(Integer.parseInt(txtFindAge.getText()));
						st.setAddress(txtFindAddress.getText());
						showDataDetailsHR(ConnJDBC.findHell3(st));
					}
					else if( txtFindName.getText().length() > 0 && txtFindAge.getText().length() > 0 && txtFindAddress.getText().length() == 0 ) {
						st.setName(txtFindName.getText());
						st.setAge(Integer.parseInt(txtFindAge.getText()));
						showDataDetailsHR(ConnJDBC.findHell2(st));
					} 
					else if ( txtFindName.getText().length() > 0 && txtFindAge.getText().length() == 0 && txtFindAddress.getText().length() == 0 ) {
						st.setName(txtFindName.getText());
						showDataDetailsHR(ConnJDBC.findByName(st));
					}
					
					
				}
				
			}
		});
		btnFindName.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
		btnFindName.setBounds(419, 476, 118, 41);
		contentPane.add(btnFindName);
		btnFindName.setBackground(new Color(167, 190, 174));
		
		txtFindName = new JTextField();
		txtFindName.setBounds(181, 425, 128, 41);
		contentPane.add(txtFindName);
		txtFindName.setColumns(10);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(114, 425, 81, 41);
		contentPane.add(lblNewLabel);
		contentPane.setBackground(Color.WHITE);
		
		txtFindAge = new JTextField();
		txtFindAge.setColumns(10);
		txtFindAge.setBounds(409, 424, 128, 41);
		contentPane.add(txtFindAge);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(349, 424, 81, 41);
		contentPane.add(lblAge);
		
		txtFindAddress = new JTextField();
		txtFindAddress.setColumns(10);
		txtFindAddress.setBounds(664, 425, 128, 41);
		contentPane.add(txtFindAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(581, 423, 81, 41);
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel_1 = new JLabel("employee details");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(275, 11, 360, 40);
		contentPane.add(lblNewLabel_1);
		showDataDetailsHR(ConnJDBC.findAll());
	}
	public static void showDataDetailsHR(List<HR>studentl) {
		List<HR>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listStudent.forEach((student) -> { 
	
	    	tableModel.addRow(new Object [] {
	    		student.getIdHumanResource(), student.getName(), student.getAge(),student.getAddress(), student.getWorkDay(), student.getEmail()
	    	});
	    });
	    }
}
