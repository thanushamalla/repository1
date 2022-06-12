package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.User;
public class Userdao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USER_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,firstname,lastname,salary,department,position,emailaddress,contactnumber,picture from user where id =?";
	private static final String SELECT_ALL_USER = "select * from user";
	private static final String DELETE_USER_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USER_SQL = "update user set firstname = ?,lastname= ?, salary=?,department= ?,position= ?,emailaddress= ?,contactnumber=?,picture= ? where id = ?;";

	public Userdao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USER_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setInt(3, user.getSalary());
			preparedStatement.setString(3, user.getDepartment());
			preparedStatement.setString(3, user.getPosition());
			preparedStatement.setString(3, user.getEmailaddress());
			preparedStatement.setInt(3, user.getContactnumber());
			preparedStatement.setString(3, user.getPicture());
			
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User us = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				int salary = rs.getInt("salary");
				String department = rs.getString("department");
				String position = rs.getString("position");
				String emailaddress = rs.getString("emailaddress");
				int contactnumber = rs.getInt("contactnumber");
				Blob picture=rs.getBlob("picture");
				us = new User(id, firstname, lastname, salary, department, position, emailaddress,contactnumber, picture );
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return us;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				int salary = rs.getInt("salary");
				String department = rs.getString("department");
				String position = rs.getString("position");
				String emailaddress = rs.getString("emailaddress");
				int contactnumber = rs.getInt("contactnumber");
				Blob picture =rs.getBlob("picture");
				users.add(new User(id, firstname, lastname, salary,department,position,emailaddress,contactnumber,picture));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setInt(3, user.getSalary());
			statement.setString(4, user.getDepartment());
			statement.setString(5, user.getPosition());
			statement.setString(6, user.getEmailaddress());
			statement.setInt(7, user.getContactnumber());
			statement.setBlob(8, user.getPicture());
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
