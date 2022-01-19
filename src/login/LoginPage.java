package login;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import ConnData.Main;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.EtchedBorder;

public class LoginPage implements ActionListener{
	
	private Color myWhite = new Color(230, 232, 210);
	private Color ADD = new Color(35, 78, 112);
	private Color EXIT = new Color(200, 52, 2);
	private Color REFRESH = new Color(138, 187, 17);
	private Color redirect = new Color(167, 190, 174);
	private Color crimson = new Color(220, 20, 60);
	JFrame frame = new JFrame("LOGIN");
	
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JPanel panel = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("Human Resource Management");
	
	public LoginPage(HashMap<String,String> loginInfoOriginal){
		frame.setUndecorated(true);
		logininfo = loginInfoOriginal;
		messageLabel.setForeground(new Color(255, 69, 0));
		
		messageLabel.setBounds(511,293,200,43);
		messageLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));

		loginButton.setBounds(447,366,121,43);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setBackground(Color.white);
		resetButton.setForeground(Color.BLACK);
		resetButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		resetButton.setBounds(667,366,121,43);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(Color.white);

 
	    FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);
		frame.getContentPane().add(messageLabel);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(865,472);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
		
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(511, 61, 198, 35);
		
		frame.getContentPane().add(lblNewLabel);
		panel.setBackground(new Color(53, 36, 87));
		panel.setBounds(0, -11, 346, 483);
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		lblNewLabel_1.setBounds(173, 5, 0, 0);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_1.setOpaque(true);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 80, 325, 3);
		
		panel.add(panel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(37, 48, 279, 32);
		
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 21));
		btnNewButton.setBackground(Color.white);
		btnNewButton.setBounds(838, 0, 66, 35);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBorder(null);
		userPasswordField.setBounds(530, 203, 200, 43);
		frame.getContentPane().add(userPasswordField);
		userPasswordField.setBorder(new TitledBorder(null, "Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userPasswordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		userPasswordLabel.setBounds(430, 213, 75, 30);
		frame.getContentPane().add(userPasswordLabel);
		userPasswordLabel.setForeground(Color.BLACK);
		userPasswordLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		userIDLabel.setBounds(430, 154, 75, 35);
		frame.getContentPane().add(userIDLabel);
		userIDLabel.setForeground(Color.BLACK);
		userIDLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		userIDField.setBounds(530, 149, 200, 43);
		frame.getContentPane().add(userIDField);
		userIDField.setBorder(new TitledBorder(null, "UserID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userIDField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(Color.white);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(Color.white);
		    }
		});
		frame.setLocationRelativeTo(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
	

		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
//					WelcomePage welcomePage = new WelcomePage(userID);
					try {
//						Main frame = new Main(userID);
//						frame.setVisible(true);
//						frame.setTitle("Human Resource Management");
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found");
			}
		}
		
	}
	 public static class FrameDragListener extends MouseAdapter {

	        private final JFrame frame;
	        private Point mouseDownCompCoords = null;

	        public FrameDragListener(JFrame frame) {
	            this.frame = frame;
	        }

	        public void mouseReleased(MouseEvent e) {
	            mouseDownCompCoords = null;
	        }

	        public void mousePressed(MouseEvent e) {
	            mouseDownCompCoords = e.getPoint();
	        }

	        public void mouseDragged(MouseEvent e) {
	            Point currCoords = e.getLocationOnScreen();
	            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	        }
	    }
}