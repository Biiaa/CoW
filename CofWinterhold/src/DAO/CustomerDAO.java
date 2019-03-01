package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBCon.DBConnection;
import Library.Customer;

public class CustomerDAO {
	public ArrayList<Customer> customerList() {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		PreparedStatement ps;
		String query = "SELECT * FROM  `customer` ";
		ResultSet rs;

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);

			Customer customer;

			while (rs.next()) {
				customer = new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getString("password"), rs.getString("birth_date"),
						rs.getString("city"), rs.getString("sex"));
				customerList.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;

	}

}
