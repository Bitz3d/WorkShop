package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.RafalWorkshop.Employee;

public class EmployeeDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static EmployeeDao instance;

	public static EmployeeDao getInstance() {

		if (instance == null) {

			instance = new EmployeeDao();

		}

		return instance;

	}

	public boolean save(String name, String lastname, String adress, Integer telephoneNumber, String text,Double pricePerhoure) {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"INSERT INTO Employee(employee_name, employee_lastName, employee_adress, employee_phoneNumber, note, price_per_hour) "
								+ "VALUES(?, ?, ?,?,?,?)")) {

					statement.setString(1, name);
					statement.setString(2, lastname);
					statement.setString(3, adress);
					statement.setInt(4, telephoneNumber);
					statement.setString(5, text);
					statement.setDouble(6, pricePerhoure);
					
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

						"DELETE FROM Employee WHERE employee_id = ?")) {

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
	
	
	public static Double getEmployeePricePerHoure(int id) {
		
		
		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"select price_per_hour from Employee where employee_id=?")) {

					statement.setInt(1,  id);


					ResultSet rs = statement.executeQuery();
					
					
					while (rs.next()) {
						
						Double price_per_hour = rs.getDouble("price_per_hour");


						return price_per_hour;

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return null;
		
		
		
	}
	
	

	public List<Employee> getAll() {
		List<Employee> books = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Employee");

					while (rs.next()) {

						Employee employee; 
						
						int id = rs.getInt("employee_id");

						String employeeName = rs.getString("employee_name");

						String employeeLastName = rs.getString("employee_lastName");

						String employeeLastAdress = rs.getString("employee_adress");
						
						int phoneNumber = rs.getInt("employee_phoneNumber");
						
						String note = rs.getString("note");
						
						Double pricePerHoure = rs.getDouble("price_per_hour");
						
						employee = new Employee(employeeName,employeeLastName,employeeLastAdress,phoneNumber,note,pricePerHoure);
						employee.setId(id);
						
						books.add(employee);
						
						
						
					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return books;

	}

	public boolean update(Employee employee) {
		
		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"UPDATE Employee SET employee_name=?, employee_lastName=?, employee_adress=?,"
						+ "employee_phoneNumber=?,note=?,price_per_hour=?  WHERE employee_id = ?")) {

					
					statement.setString(1, employee.getName());
					statement.setString(2, employee.getLastName());
					statement.setString(3, employee.getAdress());
					statement.setInt(4, employee.getTelephoneNumber());
					statement.setString(5, employee.getNote());
					statement.setDouble(6, employee.getPricePerHour());
					


					statement.setInt(7, employee.getId());

					

					int numRowsAffected = statement.executeUpdate();

					return numRowsAffected > 0;

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}
	}

	public Employee get(int id) {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"select * from Employee where employee_id= ?")) {

					statement.setInt(1,  id);


					ResultSet rs = statement.executeQuery();
					
					
					while (rs.next()) {
						
						Integer employee_id = rs.getInt("employee_id");
						String employee_name = rs.getString("employee_name");
						String employee_lastName = rs.getString("employee_lastName");
						String employee_adress = rs.getString("employee_adress");
						Integer employee_phoneNumber = rs.getInt("employee_phoneNumber");
						String note = rs.getString("note");
						Double price_per_hour = rs.getDouble("price_per_hour");
						
						Employee employeeDao =new Employee(employee_name,employee_lastName, employee_adress,employee_phoneNumber,note,price_per_hour);
						
						employeeDao.setId(employee_id);

						return employeeDao;

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return null;

	}
	
	
	public List<Employee> search(String phrase) {

		List<Employee> employees = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Employee WHERE employee_lastName LIKE '%" + phrase + "%'");

					while (rs.next()) {

						Employee employee; 
						
						int id = rs.getInt("employee_id");

						String employeeName = rs.getString("employee_name");

						String employeeLastName = rs.getString("employee_lastName");

						String employeeLastAdress = rs.getString("employee_adress");
						
						int phoneNumber = rs.getInt("employee_phoneNumber");
						
						String note = rs.getString("note");
						
						Double pricePerHoure = rs.getDouble("price_per_hour");
						
						employee = new Employee(employeeName,employeeLastName,employeeLastAdress,phoneNumber,note,pricePerHoure);
						employee.setId(id);
						
						employees.add(employee);
						
						
						
					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return employees;

	}

}
	
	

