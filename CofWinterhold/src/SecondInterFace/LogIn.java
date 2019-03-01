package SecondInterFace;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import DBCon.DBConnection;
import InterFace.Welcome;

public class LogIn extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField emailTextField;
	private JPasswordField passwordField;
	private JLabel GoToMain;
	private JComboBox<String> selectStatus;
	JLabel errorLabel;

	public static void main(String[] args) {
		new LogIn();
	}

	public LogIn() {
		getContentPane().setBackground(new Color(222, 184, 135));
		this.setSize(450, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 444, 75);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel logInText = new JLabel("Log In");
		logInText.setForeground(Color.BLACK);
		logInText.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 25));
		logInText.setBounds(145, 11, 88, 44);
		panel.add(logInText);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Java Projects\\rsz_505161-413b3a84f9545a358ef4b6f1d050ff9f.png"));
		label.setBounds(10, 0, 59, 75);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(LogIn.class.getResource("/SecondInterFace/logo.png")));
		label_1.setBounds(10, 0, 69, 64);
		panel.add(label_1);

		JPanel status = new JPanel();
		status.setBackground(Color.LIGHT_GRAY);
		status.setBounds(0, 75, 444, 180);
		getContentPane().add(status);
		status.setLayout(null);

		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setBackground(Color.GRAY);
		emailLabel.setBounds(8, 72, 74, 14);
		status.add(emailLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		passwordLabel.setBounds(8, 101, 74, 23);
		status.add(passwordLabel);

		emailTextField = new JTextField();
		emailTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		emailTextField.setBounds(84, 69, 191, 20);
		status.add(emailTextField);
		emailTextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(84, 100, 191, 20);
		status.add(passwordField);

		JRadioButton showPassBT = new JRadioButton("Show password");
		showPassBT.setBackground(SystemColor.activeCaption);
		showPassBT.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		showPassBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (showPassBT.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		showPassBT.setBounds(94, 146, 143, 23);
		status.add(showPassBT);

		JButton logIn = new JButton("Log me in");
		logIn.setIcon(new ImageIcon(LogIn.class.getResource("/SecondInterFace/login1.png")));
		logIn.setFont(new Font("Yu Gothic Medium", Font.BOLD, 10));
		logIn.setBackground(SystemColor.inactiveCaptionBorder);
		logIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				PreparedStatement ps1;
				ResultSet rs;
				ResultSet rs1;
				String email = emailTextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String status = selectStatus.getSelectedItem().toString();
				if (status.equals("Admin")) {
					String query = "SELECT * FROM `admin` WHERE `email` =? AND `password` =?";
					try {
						ps = DBConnection.getConnection().prepareStatement(query);
						ps.setString(1, email);
						ps.setString(2, password);
						rs = ps.executeQuery();

						if (rs.next()) {
							AdminUser admin = new AdminUser();
							admin.userNameLabel.setText(email);
							admin.setVisible(true);
							admin.setLocationRelativeTo(null);
							admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							LogIn.this.dispose();
						} else if (email.equals("") || password.equals("")) {
							errorLabel.setText( "Add your  Email and your Password");
						}

						else {
							errorLabel.setText( "Incorrect Email Or Password");
						}
					} catch (SQLException ex) {
						Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
					}
				} else if (status.equals("Student/Customer")) {
					String query1 = "SELECT * FROM `customer` WHERE `email` =? AND `password` =?";
					String query2 = "SELECT * FROM `students` WHERE `email` =? AND `password` =?";
					try {
						ps = DBConnection.getConnection().prepareStatement(query1);
						ps1 = DBConnection.getConnection().prepareStatement(query2);
						ps.setString(1, email);
						ps.setString(2, password);
						ps1.setString(1, email);
						ps1.setString(2, password);

						rs = ps.executeQuery();
						rs1 = ps1.executeQuery();

						if (rs.next() || rs1.next()) {
							NormalUser normalUser = new NormalUser();
							normalUser.userName.setText(email);
							normalUser.setVisible(true);
							normalUser.setLocationRelativeTo(null);
							normalUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							LogIn.this.dispose();
						} else if (email.equals("") || password.equals("")) {
							errorLabel.setText( "Add your  Email and your Password");
						}

						else {
							errorLabel.setText( "Incorrect Email Or Password");
						}
					} catch (SQLException ex) {
						Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			}

		});
		logIn.setBounds(306, 70, 128, 29);
		status.add(logIn);

		JLabel lblEnterYourCredentials = new JLabel("Enter your credentials below please");
		lblEnterYourCredentials.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblEnterYourCredentials.setForeground(Color.BLACK);
		lblEnterYourCredentials.setBounds(72, 0, 244, 14);
		status.add(lblEnterYourCredentials);

		GoToMain = new JLabel("Go to Main Menu");
		GoToMain.setIcon(new ImageIcon(LogIn.class.getResource("/SecondInterFace/back1.png")));
		GoToMain.setForeground(Color.BLACK);
		GoToMain.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		GoToMain.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Welcome wel = new Welcome();
				wel.setVisible(true);
				wel.setLocationRelativeTo(null);
				wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				LogIn.this.dispose();
			}
		});
		GoToMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GoToMain.setBounds(283, 146, 151, 23);
		status.add(GoToMain);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblStatus.setBounds(8, 41, 61, 14);
		status.add(lblStatus);

		selectStatus = new JComboBox<String>();
		selectStatus.setBackground(Color.WHITE);
		selectStatus.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		selectStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Student/Customer", "Admin", "" }));
		selectStatus.setBounds(84, 38, 191, 20);
		status.add(selectStatus);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(84, 20, 232, 14);
		status.add(errorLabel);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));

		this.setVisible(true);
	}

}
