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

public class CheckYesNoPR extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	public static JButton NoIWillConsiderPR = new JButton("No, i will consider");
	public static JButton YesImSurePR = new JButton("Yes, i'm sure");
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
	public CheckYesNoPR(String input) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		YesImSurePR.setForeground(Color.WHITE);
		
		
	
		YesImSurePR.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		YesImSurePR.setBounds(28, 124, 163, 33);
		YesImSurePR.setBackground(new Color(220, 20, 60));
		contentPane.add(YesImSurePR);
		NoIWillConsiderPR.setForeground(Color.WHITE);
		
		
		
		NoIWillConsiderPR.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		NoIWillConsiderPR.setBounds(453, 124, 163, 33);
		NoIWillConsiderPR.setBackground(new Color(35, 78, 112));
		contentPane.add(NoIWillConsiderPR);
		
		JLabel lblNewLabel = new JLabel("Are you sure delete this project?");
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
				{null, null, null, null, null},
			},
			new String[] {
				"ID Project", "Name Project", "Number Of Employees", "Starting Day", "Ending Day"
			}
		));
		scrollPane.setViewportView(table);
		showDataPR(ConnJDBC.findbyIdProject(input));
	}
	public static void showDataPR(List<Project>projectList) {
		List<Project>projectList1=new ArrayList<>();
		projectList1=projectList;
		DefaultTableModel tableModel;
		table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	    projectList1.forEach((project) -> { 
	    	String startingDay;
	    	String endingDay;
			try {
				startingDay = sdf.format(sdf2.parse(project.getStartingDay()));
				endingDay = sdf.format(sdf2.parse(project.getEndingDay()));
				tableModel.addRow(new Object [] {
		    			project.getIdProject(),project.getNameProject(),
		    		project.getNOE(), startingDay, endingDay
		    	});
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	    }
}
