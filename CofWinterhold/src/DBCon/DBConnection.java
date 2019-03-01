package DBCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/relations", "root", "18121996");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return con;
	}

}
