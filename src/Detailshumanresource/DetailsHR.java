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

public class DetailsHR extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtFindName;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JTextField txtFindIdHumanResource;
	private JTextField txtFindAge;

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
		scrollPane.setBounds(42, 38, 860, 343);
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
			},
			new String[] {
				"idHumanResource", "Name", "Address", "WorkDay", "Email"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnFindName = new JButton("FIND");
		btnFindName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HR st = new HR();
				
				if(txtFindName.getText().length()==0 && txtFindIdHumanResource.getText().length() == 0 && txtFindAge.getText().length() == 0){
					showDataDetailsHR(ConnJDBC.findAll());
				} else {
					if(txtFindIdHumanResource.getText().length() > 0) {
						st.setIdHumanResource(txtFindIdHumanResource.getText());
					}
					if(txtFindName.getText().length() > 0) {
						st.setName(txtFindName.getText());
					}
					if(txtFindAge.getText().length()>0) {
						st.setAge(Integer.parseInt(txtFindAge.getText()));
					}
					
					showDataDetailsHR(ConnJDBC.findByName(st));
				}
				
			}
		});
		btnFindName.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
		btnFindName.setBounds(419, 450, 118, 41);
		contentPane.add(btnFindName);
		btnFindName.setBackground(new Color(167, 190, 174));
		
		txtFindName = new JTextField();
		txtFindName.setBounds(315, 392, 128, 41);
		contentPane.add(txtFindName);
		txtFindName.setColumns(10);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(252, 392, 81, 41);
		contentPane.add(lblNewLabel);
		contentPane.setBackground(Color.WHITE);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(42, 392, 81, 41);
		contentPane.add(lblId);
		
		txtFindIdHumanResource = new JTextField();
		txtFindIdHumanResource.setColumns(10);
		txtFindIdHumanResource.setBounds(93, 392, 128, 41);
		contentPane.add(txtFindIdHumanResource);
		
		txtFindAge = new JTextField();
		txtFindAge.setColumns(10);
		txtFindAge.setBounds(544, 392, 128, 41);
		contentPane.add(txtFindAge);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(475, 392, 81, 41);
		contentPane.add(lblAge);
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
	    		student.getIdHumanResource(), student.getName(), student.getAddress(), student.getWorkDay(), student.getEmail()
	    	});
	    });
	    }
}
