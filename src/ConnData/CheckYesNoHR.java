package ConnData;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CheckYesNoHR extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	public static JButton NoIWillConsiderHR = new JButton("No, i will consider");
	public static JButton YesImSureHR = new JButton("Yes, i'm sure");
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
	public CheckYesNoHR(String input) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		YesImSureHR.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		YesImSureHR.setBounds(28, 124, 163, 33);
		YesImSureHR.setBackground(new Color(220, 20, 60));
		contentPane.add(YesImSureHR);
		
		
		
		NoIWillConsiderHR.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		NoIWillConsiderHR.setBounds(453, 124, 163, 33);
		NoIWillConsiderHR.setBackground(new Color(35, 78, 112));
		contentPane.add(NoIWillConsiderHR);
		
		JLabel lblNewLabel = new JLabel("Are you sure delete this human resource?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblNewLabel.setBounds(83, 11, 467, 33);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 55, 555, 40);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID Human Resource", "Name", "Age", "Gender", "Position", "Part"
			}
		));
		scrollPane.setViewportView(table);
		showData(ConnJDBC.findById(input));
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
}
