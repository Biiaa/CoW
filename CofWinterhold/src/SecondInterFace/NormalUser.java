package SecondInterFace;

import java.awt.Color;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.BookDAO;
import DAO.EncyDAO;
import DAO.MagazinsDAO;
import DBCon.DBConnection;
import InterFace.Welcome;
import Library.Publications;

public class NormalUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField pubSearchText;
	private JList<String> listForPublication;
	private JScrollPane scrollPane;
	protected JLabel userName;
	private JLabel user;
	private JTable table;
	private JLabel titleLabel;
	private JLabel authorLabel;
	String[] colors = { "black", "blue", "white", "black", "blue", "white" };
	
	BookDAO bookDAO = new BookDAO();
	MagazinsDAO magDAO = new MagazinsDAO();
	EncyDAO encyDAO = new EncyDAO();
	List<Publications> pubs = new ArrayList<>();

	public static void main(String[] args) {

		new NormalUser();
	}

	public NormalUser(String logInUser) {
		userName.setText(logInUser);

	}

	public void populateJList(JList<String> list) throws SQLException {

		DefaultListModel<String> model = new DefaultListModel<String>();
		String query = "SELECT `title` FROM `books` UNION SELECT `title` FROM `ency` UNION SELECT `title` FROM `magazins` ORDER BY `title`";
		PreparedStatement ps;
		ResultSet rs;
		ps = DBConnection.getConnection().prepareStatement(query);
		rs = ps.executeQuery();

		while (rs.next()) // go through each row that your query returns
		{
			String title = rs.getString("title");
			model.addElement(title); // add each item to the model
		}
		list.setModel(model);

		rs.close();
		ps.close();

	}

	public NormalUser() {
		getContentPane().setBackground(new Color(222, 184, 135));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 8));
		this.setSize(700, 400);
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
		panel.setBounds(0, 0, 694, 71);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel welcome = new JLabel("Welcome to the Library!");
		welcome.setBackground(Color.CYAN);
		welcome.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 17));
		welcome.setBounds(175, 31, 282, 35);
		panel.add(welcome);

		user = new JLabel("User:");
		user.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		user.setBounds(261, 10, 74, 17);
		panel.add(user);

		userName = new JLabel("");
		userName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		userName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		userName.setBackground(Color.WHITE);
		userName.setBounds(315, 10, 198, 17);
		panel.add(userName);

		JButton btnLogout = new JButton("Log out");
		btnLogout.setIcon(new ImageIcon(NormalUser.class.getResource("/SecondInterFace/log1.png")));
		btnLogout.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wel = new Welcome();
				wel.setVisible(true);
				wel.setLocationRelativeTo(null);
				wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				NormalUser.this.dispose();
			}
		});
		btnLogout.setBounds(542, 4, 118, 29);
		panel.add(btnLogout);

		JButton btnMyPublications = new JButton("My Publications");
		btnMyPublications.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		btnMyPublications.setBounds(513, 39, 171, 23);
		panel.add(btnMyPublications);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NormalUser.class.getResource("/SecondInterFace/logo.png")));
		lblNewLabel_1.setBounds(0, 0, 74, 66);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(365, 128, 319, 232);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		listForPublication = new JList<String>();
		listForPublication.setBackground(Color.LIGHT_GRAY);
		scrollPane = new JScrollPane(listForPublication);
		scrollPane.setBounds(0, 0, 319, 232);
		listForPublication.setVisibleRowCount(4);
		listForPublication.setVisibleRowCount(13);
		listForPublication.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		try {
			populateJList(listForPublication);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 72, 684, 45);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel labelForSearch = new JLabel("Search for a publication/author:");
		labelForSearch.setForeground(Color.BLACK);
		labelForSearch.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		labelForSearch.setBounds(10, 11, 220, 29);
		panel_2.add(labelForSearch);

		pubSearchText = new JTextField();
		pubSearchText.setBounds(240, 15, 240, 20);
		panel_2.add(pubSearchText);
		pubSearchText.setColumns(10);

		JButton btnSearch = new JButton("Find");
		btnSearch.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		btnSearch.setIcon(new ImageIcon(NormalUser.class.getResource("/SecondInterFace/search1.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				pubs.addAll( bookDAO.searchByAny("'title'", pubSearchText.getText()) );
				pubs.addAll( magDAO.searchByAny("'title'", pubSearchText.getText()) );
				pubs.addAll( encyDAO.searchByAny("'title'", pubSearchText.getText()) );
			
			}
		});
		btnSearch.setBounds(538, 12, 93, 26);
		panel_2.add(btnSearch);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 137, 335, 96);
		getContentPane().add(panel_3);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();

				TableModel model = table.getModel();

				titleLabel.setText(model.getValueAt(i, 0).toString());

				authorLabel.setText(model.getValueAt(i, 1).toString());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Title", "Author" }));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 335, 96);
		panel_3.add(scroll);
		panel_3.setLayout(null);

		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		btnBorrow.setForeground(Color.BLACK);
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		btnBorrow.setBounds(109, 337, 89, 23);
		getContentPane().add(btnBorrow);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 296, 235, 29);
		getContentPane().add(lblNewLabel);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(10, 256, 46, 14);
		getContentPane().add(lblTitle);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblAuthor.setForeground(Color.BLACK);
		lblAuthor.setBounds(10, 297, 59, 14);
		getContentPane().add(lblAuthor);

		titleLabel = new JLabel("");
		titleLabel.setOpaque(true);
		titleLabel.setBounds(79, 256, 208, 14);
		getContentPane().add(titleLabel);

		authorLabel = new JLabel("");
		authorLabel.setOpaque(true);
		authorLabel.setBounds(79, 297, 208, 14);
		getContentPane().add(authorLabel);

		this.setVisible(true);
	}
}
