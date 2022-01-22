package DetailsDepartment;

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

import ConnData.HR;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class DetailsEmsJoinedDepartment extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsEmsJoinedDepartment frame = new DetailsEmsJoinedDepartment();
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
	public DetailsEmsJoinedDepartment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 635, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID Human Resource", "Name", "Age", "Gender", "Address", "Email", "ID Department"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("details of employees who participated in the project");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblNewLabel.setBounds(92, 11, 493, 36);
		contentPane.add(lblNewLabel);
	}
	public static void showDataThoseWhoJoinedDepartment(List<HR>studentl) {
		List<HR>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel123;
		table.getModel();
	    tableModel123=(DefaultTableModel)table.getModel();
	    tableModel123.setRowCount(0);
	    listStudent.forEach((student) -> { 
	    	String gender;
	    	if(student.getGender()==0)gender="Male";
	    	else {gender="Female";}
	    	tableModel123.addRow(new Object [] {
	    		student.getIdHumanResource() ,student.getName(),student.getAge(),
	    		gender,student.getAddress(), student.getEmail(), student.getIdDepartment()
	    	});
	    });
	    }
}
