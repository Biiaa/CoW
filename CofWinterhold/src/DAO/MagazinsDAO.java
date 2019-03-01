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
import Library.Magazins;
import net.proteanit.sql.DbUtils;

public class MagazinsDAO {

	public ArrayList<Magazins> magazinesList() {

		ArrayList<Magazins> magazinsList = new ArrayList<Magazins>();
		PreparedStatement ps;
		String query = "SELECT * FROM  `magazins` ";
		ResultSet rs;

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);

			Magazins magazin;

			while (rs.next()) {
				magazin = new Magazins(rs.getInt("magazin_id"), rs.getString("title"), rs.getString("number"),
						rs.getString("theme"), rs.getString("isbn"));
				magazinsList.add(magazin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return magazinsList;
	}

	public List<Magazins> searchByAny(String column, String value) {
		PreparedStatement ps;
		ResultSet rs;
		try {
			String query = "SELECT Title FROM magazins WHERE " + column + " LIKE '" + value + "' ";
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			return (List<Magazins>) DbUtils.resultSetToTableModel(rs);
		} catch (Exception e) {
			return null; // or throw it / let if pass through, handle it in caller method
		}
	}
	
	public void ShowMagazineTable(JTable table) {
		ArrayList<Magazins> magList = magazinesList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < magList.size(); i++) {
			row[0] = magList.get(i).getTitle();
			row[1] = magList.get(i).getNumber();
			row[2] = magList.get(i).getTheme();
			row[3] = magList.get(i).getISBN();
			row[4] = magList.get(i).getId();

			model.addRow(row);
		}
	}
	public void createMagazines(String title, String number, String theme, String isbn) {
		PreparedStatement ps;
		String query = "INSERT INTO `magazins`(`title`, `number`, `theme`, `isbn`) VALUES (?,?,?,?)";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, number);
			ps.setString(3, theme);
			ps.setString(4, isbn);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "New Magazin Added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMagazine(String id, String title, String number, String theme, String isbn) {
		PreparedStatement ps;
		String query = "UPDATE magazins SET title=?, number=?, theme=?, isbn=? WHERE magazin_id=?";
		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, number);
			ps.setString(3, theme);
			ps.setString(4, isbn);
			ps.setString(5, id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Magazine Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteMagazine(String id, JTable table) {
		PreparedStatement ps;
		String query = "DELETE FROM `magazins` WHERE book_id = " + id;
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
		ShowMagazineTable(table);

	}
}
