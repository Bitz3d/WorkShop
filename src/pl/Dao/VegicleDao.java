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
import pl.RafalWorkshop.Vehicle;


public class VegicleDao{

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static VegicleDao instance;

	public static VegicleDao getInstance() {

		if (instance == null) {

			instance = new VegicleDao();

		}

		return instance;

	}
	
	
	
	public boolean save( String model, String trademark, Integer productionYear, String registrationNumber, Date date, Integer id ) {
		

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"INSERT INTO Vehicles(model, trademark, productionYear, registration_number, technical_reviw, customer_id) "
								+ "VALUES(?, ?, ?,?,?,?)")) {

					
					statement.setString(1, model);
					statement.setString(2, trademark);
					statement.setInt(3, productionYear);
					statement.setString(4, registrationNumber);
					java.sql.Date sd = new java.sql.Date(date.getTime());
					statement.setDate(5, sd);
					statement.setInt(6, id);
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

						"DELETE FROM Vehicles WHERE vehicle_id = ?")) {

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


	public List<Vehicle> getAll() {
		List<Vehicle> vehicles = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Vehicles");

					while (rs.next()) {

						Vehicle vehicle; 
						
						int id = rs.getInt("vehicle_id");

						String model = rs.getString("model");

						String trademark = rs.getString("trademark");

						Integer productionYear = rs.getInt("productionYear");
						
						String registrationNumber = rs.getString("registration_number");
						
						Date technical_reviw = rs.getDate("technical_reviw");
						
						Integer customerId = rs.getInt("customer_id");
						
						vehicle = new Vehicle(model, trademark, productionYear, registrationNumber, technical_reviw);
						vehicle.setCustomerID(customerId);
						vehicle.setId(id);
						
						vehicles.add(vehicle);

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return vehicles;

		
	}

	public boolean update(Vehicle vehicle) {
		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"UPDATE Vehicles SET model=?, trademark=?, productionYear=?,"
						+ "registration_number=?,technical_reviw=?, customer_id=? WHERE vehicle_id = ?")) {

					
					statement.setString(1, vehicle.getModel());
					statement.setString(2, vehicle.getTrademark());
					statement.setInt(3, vehicle.getProdutionear());
					statement.setString(4, vehicle.getRegistrationNumber());
					statement.setDate(5, new java.sql.Date(vehicle.getTechnicalReview().getTime()));
					statement.setInt(6, vehicle.getCustomerID());
					statement.setInt(7, vehicle.getId());

					

					int numRowsAffected = statement.executeUpdate();

					return numRowsAffected > 0;

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
