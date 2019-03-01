package SecondInterFace;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.StudentDAO;
import DBCon.DBConnection;
import Library.Student;

public class ListStudents extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailText;
	private JTextField passText;
	private JTextField bdayText;
	private JTextField sexText;
	private JTextField cityText;
	private JTextField idText;
	private JTextField profileText;
	private JTextField searchField;
	private JLabel errorLabel;
	StudentDAO s = new StudentDAO();

	public static void main(String[] args) {
		new ListStudents();
	}

	public void executeSQlQuery(String query, String message) {
		PreparedStatement ps;

		Statement st;
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			st = ps;
			if ((st.executeUpdate(query)) == 1) {
				// refresh jtable data
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Users_In_JTable();

				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void Show_Users_In_JTable() {
		ArrayList<Student> list = s.studentList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getFirstName();
			row[2] = list.get(i).getLastName();
			row[3] = list.get(i).getProfile();
			row[4] = list.get(i).getEmail();
			row[5] = list.get(i).getPassword();
			row[6] = list.get(i).getBirthDate();
			row[7] = list.get(i).getCity();
			row[8] = list.get(i).getSex();

			model.addRow(row);
		}
	}

	public ListStudents() {
		getContentPane().setBackground(new Color(222, 184, 135));
		getContentPane().setForeground(Color.WHITE);
		this.setSize(750, 450);
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
		panel.setForeground(Color.WHITE);
		panel.setBounds(46, 0, 698, 36);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentList.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblStudentList.setBounds(-43, 0, 731, 37);
		panel.add(lblStudentList);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(34, 64, 688, 131);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = table.getSelectedRow();

				TableModel model = table.getModel();

				// Display Slected Row In JTexteFields
				idText.setText(model.getValueAt(i, 0).toString());

				firstNameText.setText(model.getValueAt(i, 1).toString());

				lastNameText.setText(model.getValueAt(i, 2).toString());

				profileText.setText(model.getValueAt(i, 3).toString());

				emailText.setText(model.getValueAt(i, 4).toString());

				passText.setText(model.getValueAt(i, 5).toString());

				bdayText.setText(model.getValueAt(i, 6).toString());

				cityText.setText(model.getValueAt(i, 7).toString());

				sexText.setText(model.getValueAt(i, 8).toString());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "First name", "Last Name",
				"Profile", "E-mail", "Password", "Birth Day", "City", "Sex" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, true, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.setBounds(99, 229, 162, -128);
		Show_Users_In_JTable();

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 688, 130);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 206, 724, 204);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel firstLabel = new JLabel("First Name:");
		firstLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		firstLabel.setForeground(Color.BLACK);
		firstLabel.setBounds(10, 34, 82, 14);
		panel_2.add(firstLabel);

		JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setForeground(Color.BLACK);
		lastLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		lastLabel.setBounds(10, 63, 96, 14);
		panel_2.add(lastLabel);

		JLabel emLabel = new JLabel("E-mail:");
		emLabel.setForeground(Color.BLACK);
		emLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		emLabel.setBounds(10, 123, 72, 14);
		panel_2.add(emLabel);

		JLabel pasLabel = new JLabel("Password:");
		pasLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		pasLabel.setForeground(Color.BLACK);
		pasLabel.setBounds(10, 153, 82, 14);
		panel_2.add(pasLabel);

		JLabel bdayLabel = new JLabel("Birth day:");
		bdayLabel.setForeground(Color.BLACK);
		bdayLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		bdayLabel.setBounds(10, 183, 72, 14);
		panel_2.add(bdayLabel);

		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		sexLabel.setBounds(310, 33, 72, 14);
		panel_2.add(sexLabel);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setBounds(310, 5, 72, 14);
		panel_2.add(cityLabel);

		firstNameText = new JTextField();
		firstNameText.setBounds(95, 30, 200, 20);
		panel_2.add(firstNameText);
		firstNameText.setColumns(10);

		lastNameText = new JTextField();
		lastNameText.setColumns(10);
		lastNameText.setBounds(95, 60, 200, 20);
		panel_2.add(lastNameText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(95, 120, 200, 20);
		panel_2.add(emailText);

		bdayText = new JTextField();
		bdayText.setColumns(10);
		bdayText.setBounds(95, 180, 200, 20);
		panel_2.add(bdayText);

		sexText = new JTextField();
		sexText.setColumns(10);
		sexText.setBounds(354, 3, 200, 20);
		panel_2.add(sexText);

		cityText = new JTextField();
		cityText.setColumns(10);
		cityText.setBounds(354, 30, 200, 20);
		panel_2.add(cityText);

		JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		updateButton.setForeground(Color.BLACK);
		updateButton.setIcon(new ImageIcon(ListStudents.class.getResource("/SecondInterFace/up1.png")));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE `students` SET `first_name`='" + firstNameText.getText() + "',`last_name`='"
						+ lastNameText.getText() + "',`email`='" + emailText.getText() + "',`password`='"
						+ passText.getText() + "',`birth_date`='" + bdayText.getText() + "',`city`='"
						+ cityText.getText() + "', `sex` = '" + sexText.getText() + "', `profile` = '"
						+ profileText.getText() + "' WHERE student_id = " + idText.getText();

				executeSQlQuery(query, "Updated");

			}
		});
		updateButton.setBounds(591, 83, 105, 35);
		panel_2.add(updateButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setIcon(new ImageIcon(ListStudents.class.getResource("/SecondInterFace/delete1.png")));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String query = "DELETE FROM `students` WHERE student_id = " + idText.getText();
				executeSQlQuery(query, "Deleted");
			}
		});
		deleteButton.setBounds(591, 24, 105, 35);
		panel_2.add(deleteButton);

		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(95, 3, 200, 20);
		panel_2.add(idText);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblId.setForeground(Color.BLACK);
		lblId.setBounds(10, 5, 46, 14);
		panel_2.add(lblId);

		JLabel backToAdm = new JLabel("Back to admin");
		backToAdm.setIcon(new ImageIcon(ListStudents.class.getResource("/SecondInterFace/back1.png")));
		backToAdm.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		backToAdm.setForeground(Color.BLACK);
		backToAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AdminUser adm = new AdminUser();
				adm.setVisible(true);
				adm.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ListStudents.this.dispose();
			}
		});
		backToAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToAdm.setBounds(591, 167, 123, 26);
		panel_2.add(backToAdm);

		passText = new JTextField();
		passText.setBounds(95, 150, 200, 20);
		panel_2.add(passText);
		passText.setColumns(10);

		profileText = new JTextField();
		profileText.setColumns(10);
		profileText.setBounds(95, 90, 200, 20);
		panel_2.add(profileText);

		JLabel lblProfile = new JLabel("Profile:");
		lblProfile.setForeground(Color.BLACK);
		lblProfile.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblProfile.setBounds(10, 93, 72, 14);
		panel_2.add(lblProfile);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		panel_3.setBounds(354, 77, 200, 120);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search student by email");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 180, 14);
		panel_3.add(lblNewLabel);

		searchField = new JTextField();
		searchField.setBounds(10, 30, 180, 20);
		panel_3.add(searchField);
		searchField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnSearch.setIcon(new ImageIcon(ListStudents.class.getResource("/SecondInterFace/search1.png")));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PreparedStatement ps;
				String query = "SELECT * FROM  students  WHERE email = ?";
				ResultSet rs;
				try {
					ps = DBConnection.getConnection().prepareStatement(query);
					ps.setString(1, searchField.getText());
					rs = ps.executeQuery();

					if (rs.next()) {
						idText.setText(rs.getString("student_id"));
						firstNameText.setText(rs.getString("first_name"));
						lastNameText.setText(rs.getString("last_name"));
						emailText.setText(rs.getString("email"));
						passText.setText(rs.getString("password"));
						bdayText.setText(rs.getString("birth_date"));
						cityText.setText(rs.getString("city"));
						sexText.setText(rs.getString("sex"));
						profileText.setText(rs.getString("profile"));
						errorLabel.setText("");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				String search = searchField.getText();
				if (search.equals("")) {
					errorLabel.setText(" *Please enter the email adress");
				}

				searchField.setText("");
			}
		});
		btnSearch.setBounds(34, 75, 109, 34);
		panel_3.add(btnSearch);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 50, 180, 14);
		panel_3.add(errorLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 59, 53);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ListStudents.class.getResource("/SecondInterFace/rsz_2logo.png")));

		this.setVisible(true);
	}
}
