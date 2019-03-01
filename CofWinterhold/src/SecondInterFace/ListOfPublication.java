
package SecondInterFace;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.BookDAO;
import DAO.EncyDAO;
import DAO.MagazinsDAO;

public class ListOfPublication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable bookTable;
	private JTable magazinTable;
	private JTable encyclopediaTable;

	private JComboBox<String> comboBox;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField themeField;
	private JTextField isbnField;
	private JTextField idField;
	private JTextField numberField;
	BookDAO bookDAO = new BookDAO();
	MagazinsDAO magazineDAO = new MagazinsDAO();
	EncyDAO encyDAO = new EncyDAO();

	public static void main(String[] args) {
		new ListOfPublication();
	}

	public void clear() {
		titleField.setText("");
		authorField.setText("");
		numberField.setText("");
		themeField.setText("");
		isbnField.setText("");
		idField.setText("");
	}


	public ListOfPublication() {
		getContentPane().setBackground(new Color(222, 184, 135));
		this.setSize(700, 550);
		this.setLocationRelativeTo(null);
		this.setTitle("Welcome to College of Winterhold");
		getContentPane().setLayout(null);
		this.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 744, 53);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("List of publications");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 692, 52);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListOfPublication.class.getResource("/SecondInterFace/rsz_2logo.png")));
		label.setBounds(0, 0, 60, 52);
		panel.add(label);

		JPanel pubPanel = new JPanel();
		pubPanel.setBounds(58, 92, 560, 177);
		getContentPane().add(pubPanel);

		pubPanel.setLayout(new CardLayout(0, 0));

		JPanel bookPanel = new JPanel();
		bookPanel.setBackground(new Color(222, 184, 135));
		bookPanel.setBorder(null);
		pubPanel.add(bookPanel, "name_2140552878390200");
		bookPanel.setLayout(null);

		bookTable = new JTable();
		bookTable.setBorder(null);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = bookTable.getSelectedRow();

				TableModel model = bookTable.getModel();

				titleField.setText(model.getValueAt(i, 0).toString());

				authorField.setText(model.getValueAt(i, 1).toString());

				themeField.setText(model.getValueAt(i, 2).toString());

				isbnField.setText(model.getValueAt(i, 3).toString());

				idField.setText(model.getValueAt(i, 4).toString());

			}
		});
		bookTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Title", "Author", "Theme", "ISBN", "ID" }

				));
		bookDAO.ShowBooksTable(bookTable);
		JScrollPane scroll = new JScrollPane(bookTable);
		scroll.setBounds(0, 0, 559, 177);
		bookPanel.add(scroll);

		JPanel magPanel = new JPanel();
		pubPanel.add(magPanel, "name_2140559157061038");
		magPanel.setLayout(null);
		magazinTable = new JTable();
		magazinTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = magazinTable.getSelectedRow();
				TableModel model = magazinTable.getModel();

				titleField.setText(model.getValueAt(i, 0).toString());

				numberField.setText(model.getValueAt(i, 1).toString());

				themeField.setText(model.getValueAt(i, 2).toString());

				isbnField.setText(model.getValueAt(i, 3).toString());

				idField.setText(model.getValueAt(i, 4).toString());
			}
		});
		magazinTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Title", "Number", "Theme", "ISBN", "ID" }

				));
		magazineDAO.ShowMagazineTable(magazinTable);
		JScrollPane scroll2 = new JScrollPane(magazinTable);
		scroll2.setBounds(0, 0, 559, 177);
		magPanel.add(scroll2);

		JPanel encPanel = new JPanel();
		pubPanel.add(encPanel, "name_2140621730223685");
		encyclopediaTable = new JTable();
		encyclopediaTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = encyclopediaTable.getSelectedRow();
				TableModel model = encyclopediaTable.getModel();

				titleField.setText(model.getValueAt(i, 0).toString());

				authorField.setText(model.getValueAt(i, 1).toString());

				isbnField.setText(model.getValueAt(i, 2).toString());

				idField.setText(model.getValueAt(i, 3).toString());
			}
		});
		encyclopediaTable
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Titlu", "Autor", "ISBN", "ID" }

				));
		encyDAO.ShowEncyTable(encyclopediaTable);
		JScrollPane scroll3 = new JScrollPane(encyclopediaTable);
		scroll3.setBounds(0, 0, 559, 177);
		encPanel.setLayout(null);
		encPanel.add(scroll3);
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(222, 184, 135));
		panel_6.setBounds(0, 53, 744, 28);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = comboBox.getSelectedItem().toString();

				if (type.equals("Books")) {
					pubPanel.removeAll();
					pubPanel.add(bookPanel);
					pubPanel.repaint();
					pubPanel.revalidate();
					clear();

				} else if (type.equals("Magazins")) {
					pubPanel.removeAll();
					pubPanel.add(magPanel);
					pubPanel.repaint();
					pubPanel.revalidate();
					clear();

				} else if (type.equals("Encyclopedias")) {
					pubPanel.removeAll();
					pubPanel.add(encPanel);
					pubPanel.repaint();
					pubPanel.revalidate();
					clear();
				}
			}
		});

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Books", "Magazins", "Encyclopedias" }));
		comboBox.setBounds(191, 5, 128, 20);
		panel_6.add(comboBox);

		JLabel lblTypeOfThe = new JLabel("Type of the Publication");
		lblTypeOfThe.setForeground(Color.BLACK);
		lblTypeOfThe.setBounds(53, 8, 128, 14);
		panel_6.add(lblTypeOfThe);

		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.LIGHT_GRAY);
		textPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPanel.setBounds(10, 269, 674, 241);
		getContentPane().add(textPanel);
		textPanel.setLayout(null);

		JLabel isbnError = new JLabel("");
		isbnError.setBounds(120, 190, 216, 10);
		textPanel.add(isbnError);
		isbnError.setForeground(Color.RED);

		JLabel themeError = new JLabel("");
		themeError.setBounds(120, 150, 216, 10);
		textPanel.add(themeError);
		themeError.setForeground(Color.RED);

		JLabel authorLabel = new JLabel("");
		authorLabel.setBounds(120, 70, 216, 10);
		textPanel.add(authorLabel);
		authorLabel.setForeground(Color.RED);

		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(120, 30, 216, 10);
		textPanel.add(titleLabel);
		titleLabel.setForeground(Color.RED);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblId.setForeground(Color.BLACK);
		lblId.setBounds(50, 213, 60, 14);
		textPanel.add(lblId);

		idField = new JTextField();
		idField.setBounds(120, 210, 216, 20);
		textPanel.add(idField);
		idField.setColumns(10);

		JButton deletePub = new JButton(" Delete Publication");
		deletePub.setForeground(Color.BLACK);
		deletePub.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		deletePub
				.setIcon(new ImageIcon("D:\\Java Projects\\Library\\CofWinterhold\\src\\SecondInterFace\\delete1.png"));
		deletePub.setBounds(391, 130, 182, 36);
		textPanel.add(deletePub);

		JButton upPub = new JButton("Update Publication");
		upPub.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		upPub.setForeground(Color.BLACK);
		upPub.setIcon(new ImageIcon("D:\\Java Projects\\Library\\CofWinterhold\\src\\SecondInterFace\\up1.png"));
		upPub.setBounds(391, 80, 182, 36);
		textPanel.add(upPub);

		JButton addPub = new JButton("Add new Publication");
		addPub.setForeground(Color.BLACK);
		addPub.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		addPub.setIcon(new ImageIcon("D:\\Java Projects\\Library\\CofWinterhold\\src\\SecondInterFace\\add3.png"));
		addPub.setBounds(391, 30, 182, 36);
		textPanel.add(addPub);

		isbnField = new JTextField();
		isbnField.setBounds(120, 170, 216, 20);
		textPanel.add(isbnField);
		isbnField.setColumns(10);

		themeField = new JTextField();
		themeField.setBounds(120, 130, 216, 20);
		textPanel.add(themeField);
		themeField.setColumns(10);

		authorField = new JTextField();
		authorField.setBounds(120, 50, 216, 20);
		textPanel.add(authorField);
		authorField.setColumns(10);

		titleField = new JTextField();
		titleField.setBounds(120, 10, 216, 20);
		textPanel.add(titleField);
		titleField.setText("");
		titleField.setColumns(10);

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setForeground(Color.BLACK);
		lblIsbn.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblIsbn.setBounds(50, 173, 60, 14);
		textPanel.add(lblIsbn);

		JLabel lblTheme = new JLabel("Theme:");
		lblTheme.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblTheme.setForeground(Color.BLACK);
		lblTheme.setBounds(50, 133, 60, 14);
		textPanel.add(lblTheme);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblAuthor.setForeground(Color.BLACK);
		lblAuthor.setBounds(50, 53, 60, 14);
		textPanel.add(lblAuthor);

		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(50, 13, 60, 14);
		textPanel.add(lblNewLabel_1);

		numberField = new JTextField();
		numberField.setBounds(120, 90, 216, 20);
		textPanel.add(numberField);
		numberField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(120, 110, 216, 10);
		textPanel.add(lblNewLabel_2);

		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setForeground(Color.BLACK);
		lblNumber.setFont(new Font("Yu Gothic Medium", Font.BOLD, 13));
		lblNumber.setBounds(50, 93, 60, 14);
		textPanel.add(lblNumber);

		JLabel lblGoBackTo = new JLabel("Go back to Admin Page");
		lblGoBackTo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblGoBackTo.setForeground(Color.BLACK);
		lblGoBackTo.setBounds(482, 206, 182, 28);
		textPanel.add(lblGoBackTo);
		lblGoBackTo
				.setIcon(new ImageIcon("D:\\Java Projects\\Library\\CofWinterhold\\src\\SecondInterFace\\back1.png"));
		lblGoBackTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoBackTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminUser adm = new AdminUser();
				adm.setVisible(true);
				adm.setLocationRelativeTo(null);
				adm.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ListOfPublication.this.dispose();
			}
		});
		lblGoBackTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		addPub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = comboBox.getSelectedItem().toString();
				String title = titleField.getText();
				String author = authorField.getText();
				String number = numberField.getText();
				String theme = themeField.getText();
				String isbn = isbnField.getText();

				if (type.equals("Books")) {
					bookDAO.createBooks(title, author, theme, isbn);
					DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
					model.setRowCount(0);
					bookDAO.ShowBooksTable(bookTable);
					clear();
				} else if (type.equals("Magazins")) {
					magazineDAO.createMagazines(title, number, theme, isbn);
					DefaultTableModel model = (DefaultTableModel) magazinTable.getModel();
					model.setRowCount(0);
					magazineDAO.ShowMagazineTable(magazinTable);
					clear();
				} else if (type.equals("Encyclopedias")) {
					encyDAO.createEncy(title, author, isbn);
					DefaultTableModel model = (DefaultTableModel) encyclopediaTable.getModel();
					model.setRowCount(0);
					encyDAO.ShowEncyTable(encyclopediaTable);
					clear();
				}

			}
		});

		upPub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				String author = authorField.getText();
				String number = numberField.getText();
				String theme = themeField.getText();
				String isbn = isbnField.getText();
				String id = idField.getText();
				String type = comboBox.getSelectedItem().toString();
				
				if (type.equals("Books")) {
					bookDAO.updateBook(id,title, author, theme, isbn);
					DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
					model.setRowCount(0);
					bookDAO.ShowBooksTable(bookTable);
				} else if (type.equals("Magazins")) {
					magazineDAO.updateMagazine(id,title, number, theme, isbn);
					DefaultTableModel model = (DefaultTableModel) magazinTable.getModel();
					model.setRowCount(0);
					magazineDAO.ShowMagazineTable(magazinTable);
					clear();
				} else if (type.equals("Encyclopedias")) {
					encyDAO.updateEncy(id, title, author, isbn);
					DefaultTableModel model = (DefaultTableModel) encyclopediaTable.getModel();
					model.setRowCount(0);
					encyDAO.ShowEncyTable(encyclopediaTable);
					clear();
				}
			}
		});

		deletePub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = comboBox.getSelectedItem().toString();
				String id = idField.getText();

				if (type.equals("Books")) {
					bookDAO.deleteBook(id, bookTable);
					clear();
				} else if (type.equals("Magazins")) {
				magazineDAO.deleteMagazine(id, magazinTable);
					clear();
				} else if (type.equals("Encyclopedias")) {
				encyDAO.deleteEncy(id, encyclopediaTable);
					clear();
				}
			}
		});

		this.setVisible(true);
	}
}
