package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class UserDao implements IDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "Workshop";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?useSSL=false&characterEncoding=utf8";

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	private static UserDao instance;

	public static UserDao getInstance() {

		if (instance == null) {

			instance = new UserDao();

		}

		return instance;

	}
	
	private UserDao() {

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
	
	

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WorkShopDao> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(WorkShopDao item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WorkShopDao get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkShopDao> search(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}

}
