package SecondInterFace;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import DBCon.DBConnection;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class AddStudent extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField emailTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField cityTextField;
	private JPasswordField passwordTextField;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JTextField profileText;

	public static void main(String[] args) {
		
		new AddStudent();
		
	}
	
	public AddStudent(){
		getContentPane().setBackground(new Color(222, 184, 135));
		
		this.setSize(500, 500);
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
		panel.setBounds(0, 0, 494, 63);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add a new Student");
		lblAddANew.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setBounds(0, 21, 484, 23);
		panel.add(lblAddANew);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddStudent.class.getResource("/SecondInterFace/logo.png")));
		label.setBounds(10, 0, 69, 60);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 62, 494, 407);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblEmail.setBounds(10, 13, 64, 14);
		panel_1.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblPassword.setBounds(10, 48, 80, 14);
		panel_1.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 80, 95, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblLastName.setBounds(10, 111, 95, 14);
		panel_1.add(lblLastName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblCity.setBounds(10, 170, 80, 14);
		panel_1.add(lblCity);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblBirthDate.setBounds(10, 247, 95, 14);
		panel_1.add(lblBirthDate);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblSex.setBounds(10, 327, 46, 14);
		panel_1.add(lblSex);
		
		JRadioButton showPassword = new JRadioButton("Show Password");
		showPassword.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (showPassword.isSelected()) {
					passwordTextField.setEchoChar((char) 0);
				} else {
					passwordTextField.setEchoChar('*');
				}
				
			}
		});
		showPassword.setBounds(343, 46, 123, 23);
		panel_1.add(showPassword);
		
		JCalendar BdCalendar = new JCalendar();
		BdCalendar.setBounds(110, 195, 205, 107);
		panel_1.add(BdCalendar);
		
		emailTextField = new JTextField();
		emailTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailTextField.setBounds(103, 8, 234, 24);
		panel_1.add(emailTextField);
		emailTextField.setColumns(10);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(103, 75, 234, 24);
		panel_1.add(firstNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(103, 105, 234, 24);
		panel_1.add(lastNameTextField);
		
		cityTextField = new JTextField();
		cityTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cityTextField.setColumns(10);
		cityTextField.setBounds(103, 165, 234, 24);
		panel_1.add(cityTextField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnAdd.setIcon(new ImageIcon(AddStudent.class.getResource("/SecondInterFace/add3.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String email = emailTextField.getText();
			String password = String.valueOf(passwordTextField.getPassword());
			String firstname = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String city = cityTextField.getText();
			String birthdate = String.valueOf(BdCalendar.getDate());
			String sex = null;
			String profile = profileText.getText();
			
			PreparedStatement ps;
			String query = "INSERT INTO `students`(`first_name`, `last_name`, `email`, `password`, `birth_date`, `city`, `sex`, `profile`) VALUES (?,?,?,?,?,?,?,?)";
			
			try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, birthdate);
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
			}

		} catch (SQLException ex) {
			System.out.println("Done");
			Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
		}
			
			}
		});
		btnAdd.setBounds(136, 355, 109, 26);
		panel_1.add(btnAdd);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		femaleButton.setBounds(103, 325, 80, 23);
		panel_1.add(femaleButton);
		
		maleButton = new JRadioButton("Male");
		maleButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		maleButton.setBounds(206, 325, 109, 23);
		panel_1.add(maleButton);
		
		JLabel backToAdm = new JLabel("Go back to admin page");
		backToAdm.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		backToAdm.setIcon(new ImageIcon(AddStudent.class.getResource("/SecondInterFace/back1.png")));
		backToAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminUser adm = new AdminUser();
				adm.setVisible(true);
				adm.setDefaultCloseOperation(EXIT_ON_CLOSE);
				AddStudent.this.dispose();
						
			}
		});
		backToAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToAdm.setBounds(279, 370, 205, 26);
		panel_1.add(backToAdm);
		ButtonGroup group = new ButtonGroup();
		group.add(maleButton);
		group.add(femaleButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordTextField.setBounds(103, 45, 234, 24);
		panel_1.add(passwordTextField);
		
		profileText = new JTextField();
		profileText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		profileText.setColumns(10);
		profileText.setBounds(103, 135, 234, 24);
		panel_1.add(profileText);
		
		JLabel lblProfile = new JLabel("Profile:");
		lblProfile.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblProfile.setBounds(10, 140, 64, 14);
		panel_1.add(lblProfile);
		
		this.setVisible(true);
	}
}
