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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CheckYesNoDP extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	public static JButton NoIWillConsiderDP = new JButton("No, i will consider");
	public static JButton YesImSureDP = new JButton("Yes, i'm sure");
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
	public CheckYesNoDP(String input) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		YesImSureDP.setForeground(Color.WHITE);
		
		
	
		YesImSureDP.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		YesImSureDP.setBounds(28, 124, 163, 33);
		YesImSureDP.setBackground(new Color(220, 20, 60));
		contentPane.add(YesImSureDP);
		NoIWillConsiderDP.setForeground(Color.WHITE);
		
		
		
		NoIWillConsiderDP.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		NoIWillConsiderDP.setBounds(453, 124, 163, 33);
		NoIWillConsiderDP.setBackground(new Color(35, 78, 112));
		contentPane.add(NoIWillConsiderDP);
		
		JLabel lblNewLabel = new JLabel("Are you sure delete this department?");
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
				{null, null, null},
			},
			new String[] {
				"ID Department", "Name Department", "Number Of Employees"
			}
		));
		scrollPane.setViewportView(table);
		showDataDP(ConnJDBC.findbyIdDepartment(input));
	}

	public static void showDataDP(List<Department>departmentList) {
		List<Department>departmentList1=new ArrayList<>();
		departmentList1=departmentList;
		DefaultTableModel tableModel;
		table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    departmentList1.forEach((project) -> { 
	    	
	    	tableModel.addRow(new Object [] {
	    			project.getIdDepartment(),project.getNameDepartment(),
	    		project.getNumbersOfEmployeesDepart()
	    	});
	    });
	    }
	
}
