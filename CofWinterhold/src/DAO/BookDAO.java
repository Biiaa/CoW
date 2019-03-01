package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBCon.DBConnection;
import Library.Books;
import net.proteanit.sql.DbUtils;

public class BookDAO {

	public ArrayList<Books> bookList() {

		ArrayList<Books> booksList = new ArrayList<Books>();
		PreparedStatement ps;
		String query = "SELECT * FROM  `books` ";
		ResultSet rs;

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);

			Books book;

			while (rs.next()) {
				book = new Books(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
						rs.getString("theme"), rs.getString("isbn"));
				booksList.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksList;
	}

	public List<Books> searchByAny(String column, String value) {
		PreparedStatement ps;
		ResultSet rs;
		try {
			String query = "SELECT Title, Author FROM books WHERE " + column + " LIKE '" + value + "' ";
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			return  (List<Books>) DbUtils.resultSetToTableModel(rs);
		} catch (Exception e) {
			return null; // or throw it / let if pass through, handle it in caller method
		}
	}

	public void createBooks(String title, String author, String theme, String isbn) {
		PreparedStatement ps;
		String query = "INSERT INTO `books`(`title`, `author`, `theme`, `isbn`) VALUES (?,?,?,?)";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, theme);
			ps.setString(4, isbn);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "New Book Added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ShowBooksTable(JTable table) {

		ArrayList<Books> bookList = bookList();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < bookList.size(); i++) {
			row[0] = bookList.get(i).getTitle();
			row[1] = bookList.get(i).getAuthor();
			row[2] = bookList.get(i).getTheme();
			row[3] = bookList.get(i).getISBN();
			row[4] = bookList.get(i).getId();

			model.addRow(row);
		}

	}

	public void updateBook(String id, String title, String author, String theme, String isbn) {
		PreparedStatement ps;
		String query = "UPDATE books SET title=?, author=?, theme=?, isbn=? WHERE book_id=?";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, theme);
			ps.setString(4, isbn);
			ps.setString(5, id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Book Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(String id, JTable table) {
		PreparedStatement ps;
		String query = "DELETE FROM `books` WHERE book_id = " + id;
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			if ((ps.executeUpdate(query)) == 1) {
//			 //refresh jtable data
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ShowBooksTable(table);

	}
}
