package ConnData;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    static SplashScreen execute;
    private static int count;
    private static Timer timer1;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(230, 232, 210));
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);

        JLabel lblLoading = new JLabel("loading...");
        lblLoading.setFont(new Font("Verdana", Font.BOLD, 14));
        lblLoading.setBounds(128, 55, 89, 30);
        panel.add(lblLoading);

        progressBar.setMaximum(50);
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(370, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                System.out.println(count);

                if (count == 50) {

                	Main frame = new Main();
					frame.setVisible(true);
					frame.setTitle("Human Resource Management");

                    execute.setVisible(false);//swapped this around with timer1.stop()

                    timer1.stop();
                }

            }

        };
        timer1 = new Timer(50, al);
        timer1.start();
    }

    public static void main(String[] args) {
        execute = new SplashScreen();
    }
};
