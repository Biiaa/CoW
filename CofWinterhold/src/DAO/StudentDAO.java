package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBCon.DBConnection;
import Library.Student;

public class StudentDAO {
	
	public ArrayList<Student> studentList() {

		ArrayList<Student> studentList = new ArrayList<Student>();
		PreparedStatement ps;
		String query = "SELECT * FROM  `students` ";
		ResultSet rs;

		try {
			ps = DBConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);

			Student student;

			while (rs.next()) {
				student = new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getString("password"), rs.getString("birth_date"),
						rs.getString("city"), rs.getString("sex"), rs.getString("profile"));
				studentList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;

	}

}
