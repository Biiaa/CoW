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
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.CustomerDAO;
import DBCon.DBConnection;
import Library.Customer;

public class ListCustomer extends JFrame {

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
	CustomerDAO c = new CustomerDAO();

	public static void main(String[] args) {
		new ListCustomer();
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
		ArrayList<Customer> customerList = c.customerList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[8];
		for (int i = 0; i < customerList.size(); i++) {
			row[0] = customerList.get(i).getId();
			row[1] = customerList.get(i).getFirstName();
			row[2] = customerList.get(i).getLastName();
			row[3] = customerList.get(i).getEmail();
			row[4] = customerList.get(i).getPassword();
			row[5] = customerList.get(i).getBirthDate();
			row[6] = customerList.get(i).getCity();
			row[7] = customerList.get(i).getSex();

			model.addRow(row);
		}
	}

	public ListCustomer() {
		getContentPane().setBackground(new Color(222, 184, 135));
		this.setSize(700, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 694, 49);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblStudentList = new JLabel("Customer List");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblStudentList.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentList.setBounds(0, 11, 694, 28);
		panel.add(lblStudentList);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ListCustomer.class.getResource("/SecondInterFace/rsz_2logo.png")));
		lblNewLabel.setBounds(0, 0, 50, 49);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 663, 153);
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

				emailText.setText(model.getValueAt(i, 3).toString());

				passText.setText(model.getValueAt(i, 4).toString());

				bdayText.setText(model.getValueAt(i, 5).toString());

				cityText.setText(model.getValueAt(i, 6).toString());

				sexText.setText(model.getValueAt(i, 7).toString());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "First name", "Last Name", "E-mail", "Password", "Birth Day", "City", "Sex" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.setBounds(99, 229, 162, -128);
		Show_Users_In_JTable();

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 660, 151);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 204, 674, 156);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel firstLabel = new JLabel("First Name:");
		firstLabel.setForeground(Color.BLACK);
		firstLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		firstLabel.setBounds(10, 38, 82, 14);
		panel_2.add(firstLabel);

		JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setForeground(Color.BLACK);
		lastLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lastLabel.setBounds(10, 68, 82, 14);
		panel_2.add(lastLabel);

		JLabel emLabel = new JLabel("E-mail:");
		emLabel.setForeground(Color.BLACK);
		emLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		emLabel.setBounds(10, 98, 72, 14);
		panel_2.add(emLabel);

		JLabel pasLabel = new JLabel("Password:");
		pasLabel.setForeground(Color.BLACK);
		pasLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		pasLabel.setBounds(10, 128, 82, 14);
		panel_2.add(pasLabel);

		JLabel bdayLabel = new JLabel("Birth day:");
		bdayLabel.setForeground(Color.BLACK);
		bdayLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		bdayLabel.setBounds(326, 8, 72, 14);
		panel_2.add(bdayLabel);

		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		sexLabel.setBounds(326, 38, 72, 14);
		panel_2.add(sexLabel);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		cityLabel.setBounds(326, 66, 72, 14);
		panel_2.add(cityLabel);

		firstNameText = new JTextField();
		firstNameText.setBounds(97, 35, 200, 20);
		panel_2.add(firstNameText);
		firstNameText.setColumns(10);

		lastNameText = new JTextField();
		lastNameText.setColumns(10);
		lastNameText.setBounds(97, 65, 200, 20);
		panel_2.add(lastNameText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(97, 95, 200, 20);
		panel_2.add(emailText);

		passText = new JTextField();
		passText.setColumns(10);
		passText.setBounds(97, 125, 200, 20);
		panel_2.add(passText);

		bdayText = new JTextField();
		bdayText.setColumns(10);
		bdayText.setBounds(408, 5, 200, 20);
		panel_2.add(bdayText);

		sexText = new JTextField();
		sexText.setColumns(10);
		sexText.setBounds(408, 35, 200, 20);
		panel_2.add(sexText);

		cityText = new JTextField();
		cityText.setColumns(10);
		cityText.setBounds(408, 65, 200, 20);
		panel_2.add(cityText);

		JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		updateButton.setForeground(Color.BLACK);
		updateButton.setIcon(new ImageIcon(ListCustomer.class.getResource("/SecondInterFace/up1.png")));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE `customer` SET `first_name`='" + firstNameText.getText() + "',`last_name`='"
						+ lastNameText.getText() + "',`email`='" + emailText.getText() + "',`password`='"
						+ passText.getText() + "',`birth_date`='" + bdayText.getText() + "',`city`='"
						+ cityText.getText() + "', `sex` = '" + sexText.getText() + "' WHERE customer_id = "
						+ idText.getText();

				executeSQlQuery(query, "Updated");

			}
		});
		updateButton.setBounds(319, 92, 105, 30);
		panel_2.add(updateButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setIcon(new ImageIcon(ListCustomer.class.getResource("/SecondInterFace/delete1.png")));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String query = "DELETE FROM `customer` WHERE customer_id = " + idText.getText();
				executeSQlQuery(query, "Deleted");
			}
		});
		deleteButton.setBounds(431, 92, 105, 30);
		panel_2.add(deleteButton);

		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(97, 5, 200, 20);
		panel_2.add(idText);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblId.setBounds(10, 8, 46, 14);
		panel_2.add(lblId);

		JLabel backToAdm = new JLabel("Back to admin");
		backToAdm.setForeground(Color.BLACK);
		backToAdm.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		backToAdm.setIcon(new ImageIcon(ListCustomer.class.getResource("/SecondInterFace/back1.png")));
		backToAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AdminUser adm = new AdminUser();
				adm.setVisible(true);
				adm.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ListCustomer.this.dispose();
			}
		});
		backToAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToAdm.setBounds(547, 128, 127, 28);
		panel_2.add(backToAdm);

		this.setVisible(true);
	}
}
