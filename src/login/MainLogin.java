package login;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainLogin {
	
	public static void main(String[] args) { 		
		 SwingUtilities.invokeLater(() -> { 
	       
 	IDandPasswords idandPasswords = new IDandPasswords();
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		 }); 
	}
	 
}