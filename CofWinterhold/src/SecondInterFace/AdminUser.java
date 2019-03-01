package SecondInterFace;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InterFace.Welcome;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AdminUser extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel userNameLabel;

	public static void main(String[] args) {
		new AdminUser();
	}

	
	public AdminUser() {
		getContentPane().setBackground(new Color(222, 184, 135));
		this.setSize(700, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 694, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("College of Winterhold");
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 45, 695, 49);
		panel.add(welcomeLabel);
		
		JLabel adminLabel = new JLabel("ADMIN USER");
		adminLabel.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/admin1.png")));
		adminLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		adminLabel.setBounds(220, 7, 152, 33);
		panel.add(adminLabel);
		
		JButton logOutButton = new JButton("LogOut");
		logOutButton.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/log1.png")));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wel = new Welcome();
				wel.setVisible(true);
				wel.setLocationRelativeTo(null);
				wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		logOutButton.setBounds(552, 7, 132, 27);
		panel.add(logOutButton);
		
		userNameLabel = new JLabel("");
		userNameLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		userNameLabel.setBounds(360, 11, 182, 23);
		panel.add(userNameLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/logo.png")));
		label.setBounds(10, 7, 60, 76);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 116, 344, 171);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddNewStudent = new JButton("Add new Student");
		btnAddNewStudent.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/add2.png")));
		btnAddNewStudent.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent as = new AddStudent();
				as.setVisible(true);
				as.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		btnAddNewStudent.setBounds(78, 11, 210, 42);
		panel_1.add(btnAddNewStudent);
		
		JButton btnAddNewCustomer = new JButton("Add new customer");
		btnAddNewCustomer.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/add2.png")));
		btnAddNewCustomer.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer ac = new AddCustomer();
				ac.setVisible(true);
				ac.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		btnAddNewCustomer.setBounds(78, 101, 210, 42);
		panel_1.add(btnAddNewCustomer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(340, 116, 354, 171);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnListOfStudents = new JButton("List of Students");
		btnListOfStudents.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/student1.png")));
		btnListOfStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListStudents ls = new ListStudents();
				ls.setVisible(true);
				ls.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		btnListOfStudents.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnListOfStudents.setBounds(105, 11, 202, 42);
		panel_2.add(btnListOfStudents);
		
		JButton btnListOfCustomers = new JButton("List of Customers");
		btnListOfCustomers.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/cutom1.png")));
		btnListOfCustomers.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		btnListOfCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListCustomer lc = new ListCustomer();
				lc.setVisible(true);
				lc.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		btnListOfCustomers.setBounds(105, 101, 202, 43);
		panel_2.add(btnListOfCustomers);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 285, 694, 63);
		getContentPane().add(panel_3);
		
		JButton btnListOfPublications = new JButton("Add/Edit Publications");
		panel_3.add(btnListOfPublications);
		btnListOfPublications.setIcon(new ImageIcon(AdminUser.class.getResource("/SecondInterFace/add2.png")));
		btnListOfPublications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListOfPublication lp = new ListOfPublication();
				lp.setVisible(true);
				lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AdminUser.this.dispose();
			}
		});
		btnListOfPublications.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		
		this.setVisible(true);
	}
}
