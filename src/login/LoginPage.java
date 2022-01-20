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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class LoginPage  implements ActionListener{
	
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
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	private final JLabel lblNewLabel_1 = new JLabel("User ID:");
	private final JLabel lblNewLabel_2 = new JLabel("Password:");
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_1_1 = new JLabel("New label");
	
	public LoginPage(HashMap<String,String> loginInfoOriginal){
		
		frame.setUndecorated(true);
		logininfo = loginInfoOriginal;
		loginButton.setOpaque(true);
		resetButton.setOpaque(true);
		userIDField.setOpaque(true);
	    FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(808,512);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(0, 0, 808, 512);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		 ImageIcon icon = new ImageIcon(LoginPage.class.getResource("imgoldman.jpg"));
		
		
		JLabel lblHumanResourceManagement = new JLabel("HUMAN RESOURCE MANAGEMENT SYSTEM");
		lblHumanResourceManagement.setBounds(159, 90, 493, 35);
		panel_1.add(lblHumanResourceManagement);
		lblHumanResourceManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumanResourceManagement.setForeground(Color.RED);
		lblHumanResourceManagement.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
			
			
			JLabel lblNewLabel = new JLabel("VKU");
			lblNewLabel.setBounds(303, 55, 198, 35);
			panel_1.add(lblNewLabel);
			lblNewLabel.setForeground(Color.ORANGE);
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JButton btnNewButton = new JButton("X");
			btnNewButton.setBounds(784, -1, 66, 35);
			panel_1.add(btnNewButton);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setFocusPainted(false);
			btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 21));
			btnNewButton.setBackground(Color.white);
			btnNewButton.setBorder(null);
			userIDField.setBounds(280, 189, 265, 43);
			panel_1.add(userIDField);
			userIDField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			userPasswordField.setBounds(280, 243, 265, 43);
			panel_1.add(userPasswordField);
			userPasswordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			JButton btnNewButton_1 = new JButton("Forget password?");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBounds(418, 285, 173, 23);
			panel_1.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Relax and try to remember your password ^^","Forget password?",JOptionPane.INFORMATION_MESSAGE, icon);
				}
			});
			btnNewButton_1.setBackground(Color.WHITE);
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setFocusable(false);
			btnNewButton_1.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnNewButton_1.setBackground(Color.white);
			    	btnNewButton_1.setForeground(Color.RED);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnNewButton_1.setBackground(Color.white);
			    	btnNewButton_1.setForeground(Color.white);
			    }
			});
			btnNewButton_1.setContentAreaFilled(false);
			messageLabel.setBounds(310, 297, 200, 43);
			panel_1.add(messageLabel);
			messageLabel.setForeground(new Color(255, 69, 0));
			messageLabel.setFont(new Font("Century Gothic", Font.PLAIN, 19));
			loginButton.setBounds(290, 362, 83, 35);
			panel_1.add(loginButton);
			loginButton.setForeground(Color.BLACK);
			loginButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			loginButton.setFocusable(false);
			loginButton.addActionListener(this);
			loginButton.setBackground(Color.white);
			resetButton.setBounds(441, 362, 83, 35);
			panel_1.add(resetButton);
			resetButton.setForeground(Color.BLACK);
			resetButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			resetButton.setFocusable(false);
			resetButton.addActionListener(this);
			resetButton.setBackground(Color.white);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 19));
			lblNewLabel_1.setBounds(146, 189, 125, 43);
			
			panel_1.add(lblNewLabel_1);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 19));
			lblNewLabel_2.setBounds(146, 243, 125, 43);
			
			panel_1.add(lblNewLabel_2);
			panel.setLayout(null);
			panel.setBounds(2, 2, 804, 508);
			
			panel_1.add(panel);
			lblNewLabel_1_1.setIcon(new ImageIcon(LoginPage.class.getResource("/Update/universe2.png")));
			lblNewLabel_1_1.setBounds(0, 0, 805, 510);
			
			panel.add(lblNewLabel_1_1);
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