package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.RafalWorkshop.Customer;
import pl.RafalWorkshop.Employee;

public class CustomerDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME+"?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static CustomerDao instance;

	public static CustomerDao getInstance() {

		if (instance == null) {

			instance = new CustomerDao();

		}

		return instance;

	}

	private CustomerDao() {

		try {

		 Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					statement.executeUpdate("Create table IF NOT EXISTS Customer \n" + " 		(\n"
							+ " 		customer_id int auto_increment,\n" + " 		user_name varchar(255) not null,\n"
							+ " 		user_lastName varchar(255) not null, \n"
							+ " 		dateOfBirth date not null, \n" + " 		primary key(customer_id) \n"
							+ "        )");

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}
	
	
	public boolean save(String name, String lastName, Date dateOfBirth) {
		

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"INSERT INTO Customer(user_name, user_lastName, dateOfBirth) VALUES(?, ?, ?)")) {

					
					statement.setString(1, name);
					statement.setString(2, lastName);
					java.sql.Date sd = new java.sql.Date(dateOfBirth.getTime());
					statement.setDate(3, sd);

					statement.executeUpdate();

					return true;

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}

	}

	
	public boolean delete(int id) {
		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"DELETE FROM Customer WHERE customer_id = ?")) {

					statement.setInt(1, id);

					int numRowsAffected = statement.executeUpdate();

					return numRowsAffected > 0;

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}
	}


	public List<Customer> getAll() {

		List<Customer> customers = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Customer");

					while (rs.next()) {

						Customer customer;

						int id = rs.getInt("customer_id");

						String employeeName = rs.getString("user_name");

						String employeeLastName = rs.getString("user_lastName");

						Date dateOfBirth = rs.getDate("dateOfBirth");

						customer = new Customer(employeeName, employeeLastName, dateOfBirth);
						customer.setId(id);

						customers.add(customer);

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return customers;

	}


	public boolean update(Customer customer) throws ClassNotFoundException {

		Class.forName(JDBC_DRIVER);

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

			try (PreparedStatement statement = connection.prepareStatement(

					"UPDATE Customer SET user_name=?, user_lastName=?, dateOfBirth= ? WHERE customer_id = ?")) {

				
				statement.setString(1, customer.getName());
				statement.setString(2, customer.getLasyName());

				statement.setDate(3, new java.sql.Date(customer.getDateOfBirth().getTime()));
				statement.setInt(4, customer.getId());

				

				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;

			}

		}
		catch (Exception ex) {

		ex.printStackTrace();

		return false;

	}
}


	public WorkShopDao get(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<WorkShopDao> search(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
}
