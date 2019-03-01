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
import Library.Encyclopedias;
import net.proteanit.sql.DbUtils;

public class EncyDAO {

	public ArrayList<Encyclopedias> encyList() {

		ArrayList<Encyclopedias> encyList = new ArrayList<Encyclopedias>();
		PreparedStatement ps;
		String query = "SELECT * FROM  `ency` ";
		ResultSet rs;

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);

			Encyclopedias ency;

			while (rs.next()) {
				ency = new Encyclopedias(rs.getInt("ency_id"), rs.getString("author"), rs.getString("title"),
						rs.getString("isbn"));
				encyList.add(ency);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encyList;
	}

//	PreparedStatement ps;
//	ResultSet rs;
//	try {
//		String query = "SELECT Title, Author FROM books WHERE title LIKE '" + pubSearchText.getText()
//				+ "' ";
//		ps = DBConnection.getConnection().prepareStatement(query);
//		rs = ps.executeQuery();
//		table.setModel(DbUtils.resultSetToTableModel(rs));
//	} catch (Exception e) {
//		JOptionPane.showMessageDialog(null, e);
//	}

	public List<Encyclopedias> searchByAny(String column, String value) {
		PreparedStatement ps;
		ResultSet rs;
		try {
			String query = "SELECT Title, Author FROM ency WHERE " + column + " LIKE '" + value + "' ";
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			return (List<Encyclopedias>) DbUtils.resultSetToTableModel(rs);
		} catch (Exception e) {
			return null; // or throw it / let if pass through, handle it in caller method
		}
	}

	public void ShowEncyTable(JTable table) {
		ArrayList<Encyclopedias> encyList = encyList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[4];
		for (int i = 0; i < encyList.size(); i++) {
			row[0] = encyList.get(i).getTitle();
			row[1] = encyList.get(i).getAuthor();
			row[2] = encyList.get(i).getISBN();
			row[3] = encyList.get(i).getId();

			model.addRow(row);
		}
	}

	public void createEncy(String title, String author, String isbn) {
		PreparedStatement ps;
		String query = "INSERT INTO `ency`(`title`, `author`, `isbn`) VALUES (?,?,?)";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, isbn);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "New Encyclopedia Added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateEncy(String id, String title, String author, String isbn) {
		PreparedStatement ps;
		String query = "UPDATE ency SET title=?, author=?,isbn=? WHERE ency_id=?";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, isbn);
			ps.setString(4, id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Encyclopedia Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteEncy(String id, JTable table) {
		PreparedStatement ps;
		String query = "DELETE FROM `ency` WHERE book_id = " + id;
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
		ShowEncyTable(table);

	}
}
