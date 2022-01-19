package login;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainLogin {

	public static void main(String[] args) { 		
		
	       
 	IDandPasswords idandPasswords = new IDandPasswords();
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
	      
	}
	 
}