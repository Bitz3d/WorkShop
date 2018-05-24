package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkShopDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static WorkShopDao instance;

	public static WorkShopDao getInstance() {

		if (instance == null) {

			instance = new WorkShopDao();

		}

		return instance;

	}

	private WorkShopDao() {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					statement.executeUpdate("CREATE TABLE IF NOT EXISTS books(\n" +

							"    id INT PRIMARY KEY AUTO_INCREMENT,\n" +

							"    title TEXT NOT NULL,\n" +

							"    author TEXT NOT NULL,\n" +

							"    isbn TEXT NOT NULL\n" +

							");");

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	public boolean save() {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(""
						+ "INSERT INTO books(user_name, user_lastName, dateOfBirh) VALUES(?, ?, ?)")) {

					


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

						"DELETE FROM books WHERE id = ?")) {

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

	public List<WorkShopDao> getAllBooks() {

		List<WorkShopDao> books = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM books");

					while (rs.next()) {

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return books;

	}

	public boolean update(WorkShopDao item) {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"UPDATE books SET title=?, author=?, isbn=? WHERE id = ?")) {

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

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"SELECT * FROM books WHERE id = ?")) {

					statement.setInt(1, id);

					ResultSet rs = statement.executeQuery();

					while (rs.next()) {

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}
		
		
		
		

		return null;

	}

	public List<WorkShopDao> search(String phrase) {

		List<WorkShopDao> books = new ArrayList<>();

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (PreparedStatement statement = connection.prepareStatement(

						"SELECT * FROM books WHERE title LIKE '%" + phrase + "%'")) {

					ResultSet rs = statement.executeQuery();

					while (rs.next()) {

					}

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return books;

	}

}
