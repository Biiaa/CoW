package SecondInterFace;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
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

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import DBCon.DBConnection;
import InterFace.Welcome;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField EmailText;
	private JTextField fNameTextField;
	private JTextField lNameTextField;
	private JTextField cityTextField;
	private JCalendar BdCalendar;
	private JComboBox<String> selectComboBox;
	JRadioButton femaleButton;
	JRadioButton maleButton;
	private JTextField txtEnterYour;
	private JLabel errorLabel;

	public static void main(String[] args) {
		new Register();
	}

	public boolean checkEmailStudent(String eMail) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkEm = false;
		String query = "SELECT * FROM `students` WHERE `email` =?";

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, eMail);

			rs = ps.executeQuery();

			if (rs.next()) {
				checkEm = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
		}
		return checkEm;
	}

	public boolean checkEmailCustomer(String eMail) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkEm = false;
		String query = "SELECT * FROM `customer` WHERE `email` =?";

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, eMail);

			rs = ps.executeQuery();

			if (rs.next()) {
				checkEm = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
		}
		return checkEm;
	}

	public void clear() {
		passwordField.setText("");
		EmailText.setText("");
		fNameTextField.setText("");
		lNameTextField.setText("");
		cityTextField.setText("");
		txtEnterYour.setText("");
	}

	public Register() {
		getContentPane().setBackground(new Color(222, 184, 135));

		this.setSize(700, 500);
		this.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 694, 95);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblRegist = new JLabel("Register");
		lblRegist.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegist.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 24));
		lblRegist.setForeground(Color.BLACK);
		lblRegist.setBounds(0, 0, 694, 33);
		panel.add(lblRegist);

		selectComboBox = new JComboBox<String>();
		selectComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Student", "Customer" }));
		selectComboBox.setBounds(216, 44, 140, 20);
		panel.add(selectComboBox);

		JLabel selectStatus = new JLabel("Select your status");
		selectStatus.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		selectStatus.setForeground(Color.BLACK);
		selectStatus.setBounds(62, 48, 144, 14);
		panel.add(selectStatus);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Register.class.getResource("/SecondInterFace/logo.png")));
		label.setBounds(0, 0, 66, 72);
		panel.add(label);

		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 12));
		errorLabel.setBounds(72, 73, 368, 14);
		panel.add(errorLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(28, 94, 641, 367);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label eMail = new Label("E-mail");
		eMail.setForeground(Color.BLACK);
		eMail.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		eMail.setBounds(72, 14, 85, 18);
		panel_1.add(eMail);

		JLabel passwornd = new JLabel("Password");
		passwornd.setForeground(Color.BLACK);
		passwornd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		passwornd.setBounds(72, 48, 72, 18);
		panel_1.add(passwornd);

		passwordField = new JPasswordField();
		passwordField.setBounds(186, 45, 214, 24);
		panel_1.add(passwordField);

		EmailText = new JTextField();
		EmailText.setToolTipText("sa");
		EmailText.setBounds(186, 11, 214, 24);
		panel_1.add(EmailText);
		EmailText.setColumns(10);

		JButton registerButton = new JButton("Register");
		registerButton.setIcon(new ImageIcon(Register.class.getResource("/SecondInterFace/register1.png")));
		registerButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = EmailText.getText();
				String passwornd = String.valueOf(passwordField.getPassword());
				String firstName = fNameTextField.getText();
				String lastName = lNameTextField.getText();
				String profile = txtEnterYour.getText();
				String city = cityTextField.getText();
				String birthDate = String.valueOf(BdCalendar.getDate());
				String sex = null;
				String selectStatus = selectComboBox.getSelectedItem().toString();

				if (eMail.equals(" ")) {
					errorLabel.setText("*Please enter your email!!");
				} else if (checkEmailStudent(email) || checkEmailCustomer(email)) {
					errorLabel.setText("*This email already exist!!");
				} else if (passwornd.equals("")) {
					errorLabel.setText( "*Add A Password!!");
				} else if (firstName.equals("")) {
					errorLabel.setText( "*Add your First Name!!");
				} else if (lastName.equals("")) {
					errorLabel.setText( "*Add your Last Name!!");
				} else {

					PreparedStatement ps;
					if (selectStatus.equals("Student")) {
						String query = "INSERT INTO `students`(`first_name`, `last_name`, `email`, `password`, `birth_date`, `city`, `sex`, `profile`) VALUES (?,?,?,?,?,?,?,?)";
						try {
							ps = DBConnection.getConnection().prepareStatement(query);

							ps.setString(1, firstName);
							ps.setString(2, lastName);
							ps.setString(3, email);
							ps.setString(4, passwornd);
							ps.setString(5, birthDate);
							ps.setString(6, city);

							if (maleButton.isSelected()) {
								sex = "Male";
							} else if (femaleButton.isSelected()) {
								sex = "Female";
							}
							ps.setString(7, sex);
							ps.setString(8, profile);

							if (ps.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "New User Added");
								clear();
							}

						} catch (SQLException ex) {
							Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (selectStatus.equals("Customer")) {

						String query = "INSERT INTO `customer`(`first_name`, `last_name`, `email`, `password`, `birth_date`, `city`, `sex`) VALUES (?,?,?,?,?,?,?)";
						try {
							ps = DBConnection.getConnection().prepareStatement(query);

							ps.setString(1, firstName);
							ps.setString(2, lastName);
							ps.setString(3, email);
							ps.setString(4, passwornd);
							ps.setString(5, birthDate);

							ps.setString(6, city);

							if (maleButton.isSelected()) {
								sex = "Male";
							} else if (femaleButton.isSelected()) {
								sex = "Female";
							}
							ps.setString(7, sex);

							if (ps.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "New User Added");
								clear();
							}

						} catch (SQLException ex) {
							System.out.println("Done");
							Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}

		});

		registerButton.setBounds(474, 215, 120, 33);
		panel_1.add(registerButton);

		JLabel firstName = new JLabel("First Name");
		firstName.setForeground(Color.BLACK);
		firstName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		firstName.setBounds(72, 83, 104, 14);
		panel_1.add(firstName);

		JLabel lastName = new JLabel("Last Name");
		lastName.setForeground(Color.BLACK);
		lastName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lastName.setBounds(72, 115, 85, 14);
		panel_1.add(lastName);

		JLabel city = new JLabel("City");
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		city.setBounds(72, 182, 68, 14);
		panel_1.add(city);

		JLabel birthDate = new JLabel("Birth Date");
		birthDate.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		birthDate.setForeground(Color.BLACK);
		birthDate.setBounds(72, 237, 85, 14);
		panel_1.add(birthDate);

		JLabel sex = new JLabel("Sex");
		sex.setForeground(Color.BLACK);
		sex.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		sex.setBounds(72, 327, 68, 14);
		panel_1.add(sex);

		fNameTextField = new JTextField();
		fNameTextField.setColumns(10);
		fNameTextField.setBounds(186, 78, 214, 24);
		panel_1.add(fNameTextField);

		lNameTextField = new JTextField();
		lNameTextField.setColumns(10);
		lNameTextField.setBounds(186, 110, 214, 24);
		panel_1.add(lNameTextField);

		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(186, 177, 214, 24);
		panel_1.add(cityTextField);

		BdCalendar = new JCalendar();
		BdCalendar.setBounds(186, 209, 214, 107);
		panel_1.add(BdCalendar);

		JRadioButton showPassBT = new JRadioButton("Show Password");
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
		showPassBT.setBounds(434, 46, 134, 23);
		panel_1.add(showPassBT);

		JLabel logInButton = new JLabel("Click here to LogIn");
		logInButton.setIcon(new ImageIcon(Register.class.getResource("/SecondInterFace/login1.png")));
		logInButton.setForeground(Color.BLACK);
		logInButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		logInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogIn log = new LogIn();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
				log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Register.this.dispose();

			}

		});

		logInButton.setBounds(447, 274, 169, 24);
		panel_1.add(logInButton);

		femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(180, 323, 109, 23);
		panel_1.add(femaleButton);

		maleButton = new JRadioButton("Male");
		maleButton.setBounds(291, 323, 109, 23);
		panel_1.add(maleButton);
		ButtonGroup group = new ButtonGroup();
		group.add(maleButton);
		group.add(femaleButton);

		JLabel labelToMain = new JLabel("Go back to Main Menu");
		labelToMain.setIcon(new ImageIcon(Register.class.getResource("/SecondInterFace/back1.png")));
		labelToMain.setForeground(Color.BLACK);
		labelToMain.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		labelToMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelToMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Welcome wel = new Welcome();
				wel.setVisible(true);
				wel.setLocationRelativeTo(null);
				wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Register.this.dispose();
			}
		});
		labelToMain.setBounds(434, 323, 197, 23);
		panel_1.add(labelToMain);

		txtEnterYour = new JTextField();
		txtEnterYour.setColumns(10);
		txtEnterYour.setBounds(186, 142, 214, 24);
		panel_1.add(txtEnterYour);

		JLabel lblProfile = new JLabel("Profile\r\n");
		lblProfile.setForeground(Color.BLACK);
		lblProfile.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblProfile.setBounds(72, 147, 68, 14);
		panel_1.add(lblProfile);

		JLabel lblRequiredJust = new JLabel("* Required only  for students");
		lblRequiredJust.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblRequiredJust.setForeground(Color.BLACK);
		lblRequiredJust.setBounds(410, 147, 171, 14);
		panel_1.add(lblRequiredJust);

		this.setVisible(true);
	}
}