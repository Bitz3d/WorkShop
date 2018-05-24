package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.RafalWorkshop.Order;
import pl.RafalWorkshop.Vehicle;

public class OrderDao {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static OrderDao instance;

	public static OrderDao getInstance() {

		if (instance == null) {

			instance = new OrderDao();

		}

		return instance;

	}
	
	public boolean save(Date planningWorkingDate , Integer EmployeeId, String problemDescription, String orderStatus, Integer vehicleId) {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"INSERT INTO Orders(order_date, plannig_working_date, who_will_fix, problem_description, order_status, vehicle_to_fix) VALUES(?,?,?,?,?,?)")) {

					
					statement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
					java.sql.Date sd = new java.sql.Date(planningWorkingDate.getTime());
					statement.setDate(2, sd);
					statement.setInt(3, EmployeeId);
					statement.setString(4, problemDescription);
					statement.setString(5, orderStatus);
					statement.setInt(6, vehicleId);

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

						"DELETE FROM Orders WHERE order_id = ?")) {

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

	public List<Order> getAll() {
		List<Order> orders = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Orders");

					while (rs.next()) {

						Order order = new Order();

						int order_id = rs.getInt("order_id");

						Date orderDate = rs.getDate("order_date");

						Date planningWorkingDate = rs.getDate("plannig_working_date");

						Date startOfWork = rs.getDate("start_of_work");

						Integer employeeId = rs.getInt("who_will_fix");

						String problemDescription = rs.getString("problem_description");

						String afterFixDescription = rs.getString("after_fix_description");
						String status = rs.getString("order_status");
						Integer vehicleId = rs.getInt("vehicle_to_fix");
						Double totalCost = rs.getDouble("total_cost");
						Double partsCost = rs.getDouble("parts_cost");
						Double laborHouresToFix = rs.getDouble("laborHouresToFix");

						order.setId(order_id);
						order.setOrderDate(orderDate);
						order.setPlannigWorkingDate(planningWorkingDate);
						order.setStartOfWork(startOfWork);
						order.setEmployeeID(employeeId);
						order.setProblemDescription(problemDescription);
						order.setAfterFixDescription(afterFixDescription);
						order.setStatus(status);
						order.setVehicleID(vehicleId);
						order.setTotalCost(totalCost);
						order.setPartsCost(partsCost);
						order.setLaborHouresToFix(laborHouresToFix);

						orders.add(order);

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return orders;

	}

	public boolean update(Date planningWorkingDate, Date startOfWork , Integer EmployeeId, String problemDescription, 
						  String afterFixDescription,String orderStatus, Integer vehicleId,Double partsCost,Double laborHouresToFix,Integer orderId) {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"UPDATE Orders SET plannig_working_date=?, start_of_work=?, who_will_fix=?, problem_description=?, "
						+ "after_fix_description=?, order_status=?, vehicle_to_fix=?, parts_cost=?, laborHouresToFix=?, total_cost=? where order_id=?")) {

					

					java.sql.Date sd = new java.sql.Date(planningWorkingDate.getTime());
					statement.setDate(1, sd);
					statement.setDate(2, new java.sql.Date(startOfWork.getTime()));
					statement.setInt(3, EmployeeId);
					statement.setString(4, problemDescription);
					statement.setString(5, afterFixDescription);
					statement.setString(6, orderStatus);
					statement.setInt(7, vehicleId);
					statement.setDouble(8, partsCost);
					statement.setDouble(9, laborHouresToFix);
					statement.setDouble(10, (partsCost+(laborHouresToFix*EmployeeDao.getEmployeePricePerHoure(EmployeeId))));

					statement.setDouble(11, orderId);
					
					statement.executeUpdate();
					
					return true;
					
				}

			}

		} catch (Exception ex) {

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
