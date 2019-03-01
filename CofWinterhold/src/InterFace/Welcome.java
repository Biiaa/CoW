package InterFace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import SecondInterFace.About;
import SecondInterFace.LogIn;
import SecondInterFace.Register;

public class Welcome extends JFrame {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new Welcome();
	}
	
	public Welcome() {
		getContentPane().setBackground(new Color(222, 184, 135));
		this.setSize(600, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setTitle("Welcome to the College of Winterhold");
		this.setResizable(false);
		
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 594, 85);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel welcome = new JLabel("College of Winterhold");
		welcome.setForeground(Color.BLACK);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBackground(Color.WHITE);
		welcome.setBounds(0, 11, 594, 30);
		welcome.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 18));
		panel.add(welcome);
		
		JLabel lblVirtualLibrary = new JLabel("Virtual Library");
		lblVirtualLibrary.setForeground(Color.BLACK);
		lblVirtualLibrary.setBounds(0, 55, 594, 30);
		panel.add(lblVirtualLibrary);
		lblVirtualLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblVirtualLibrary.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 18));
		lblVirtualLibrary.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 66, 69);
		panel.add(label);
		label.setIcon(new ImageIcon(Welcome.class.getResource("/SecondInterFace/logo.png")));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(171, 120, 254, 112);
		getContentPane().add(panel_1);

		JButton normalUser = new JButton("LOG IN\r\n");
		normalUser.setIcon(new ImageIcon(Welcome.class.getResource("/SecondInterFace/login1.png")));
		normalUser.setForeground(Color.BLACK);
		normalUser.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		normalUser.setBounds(0, 16, 254, 37);
		normalUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn log = new LogIn();
				log.setVisible(true);				
				log.setLocationRelativeTo(null);
				log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				Welcome.this.dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(normalUser);

		JButton register = new JButton("REGISTER");		
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		register.setIcon(new ImageIcon(Welcome.class.getResource("/SecondInterFace/register1.png")));
		register.setBounds(0, 64, 254, 37);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
				reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				Welcome.this.dispose();
				
			}
		});
		
		panel_1.add(register);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(222, 184, 135));
		panel_2.setBounds(0, 275, 594, 75);
		getContentPane().add(panel_2);
		
				JButton exit = new JButton("EXIT");
				exit.setForeground(Color.BLACK);
				exit.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
				exit.setIcon(new ImageIcon(Welcome.class.getResource("/SecondInterFace/exit1.png")));
				exit.setBounds(26, 27, 145, 34);
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0); 
					}
				});
		
				JButton about = new JButton("ABOUT");
				about.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						About a = new About();
						a.setVisible(true);
						a.setLocationRelativeTo(null);
						a.setDefaultCloseOperation(EXIT_ON_CLOSE);
						Welcome.this.dispose();
					}
				});
				about.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
				about.setForeground(Color.BLACK);
				about.setIcon(new ImageIcon(Welcome.class.getResource("/SecondInterFace/ab1.png")));
				about.setBounds(392, 27, 145, 34);
				about.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				panel_2.setLayout(null);
				panel_2.add(exit);
				panel_2.add(about);
				this.setVisible(true);
	}
}
