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

import ConnData.JFrameHR;

public class LoginPage implements ActionListener{
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
	
	public LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		userIDLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		userIDLabel.setBounds(371,100,75,25);
		userPasswordLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		userPasswordLabel.setBounds(371,150,75,25);
		messageLabel.setForeground(new Color(255, 69, 0));
		
		messageLabel.setBounds(444,205,164,35);
		messageLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		userIDField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		userIDField.setBounds(456,100,200,25);
		userPasswordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		userPasswordField.setBounds(456,150,200,25);
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		loginButton.setBounds(401,278,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setBackground(crimson);
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		resetButton.setBounds(552,278,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(crimson);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(698,378);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
		
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(419, 24, 198, 35);
		frame.getContentPane().add(lblNewLabel);
		panel.setBounds(0, -11, 346, 364);
		
		frame.getContentPane().add(panel);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/login/img.png")));
		
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
//						JFrameHR frame = new JFrameHR(userID);
//						frame.setVisible(true);
						WelcomePage frame = new WelcomePage(userID);
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
	

}