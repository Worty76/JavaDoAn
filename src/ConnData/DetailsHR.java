package ConnData;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
	private JTextField txtFindAge;
	private JTextField txtFindAddress;
	private JLabel lblNewLabel;
	private JLabel lblAge;
	private JLabel lblAddress;

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
		scrollPane.setBounds(42, 38, 844, 343);
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
				
				if(txtFindName.getText().length()==0){
					showDataDetailsHR(ConnJDBC.findAll());
				} else {
					st.setName(txtFindName.getText());
					showDataDetailsHR(ConnJDBC.findByName(st));
				}
				
			}
		});
		btnFindName.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
		btnFindName.setBounds(362, 443, 170, 49);
		contentPane.add(btnFindName);
		btnFindName.setBackground(new Color(167, 190, 174));
		
		txtFindName = new JTextField();
		txtFindName.setBounds(124, 392, 128, 41);
		contentPane.add(txtFindName);
		txtFindName.setColumns(10);
		
		txtFindAge = new JTextField();
		txtFindAge.setColumns(10);
		txtFindAge.setBounds(377, 392, 128, 41);
		contentPane.add(txtFindAge);
		
		txtFindAddress = new JTextField();
		txtFindAddress.setColumns(10);
		txtFindAddress.setBounds(636, 392, 128, 41);
		contentPane.add(txtFindAddress);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 392, 81, 41);
		contentPane.add(lblNewLabel);
		
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(286, 392, 81, 41);
		contentPane.add(lblAge);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(545, 392, 81, 41);
		contentPane.add(lblAddress);
		contentPane.setBackground(new Color(230, 232, 210));
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
