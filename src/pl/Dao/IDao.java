package pl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public interface IDao {
	

	public boolean save();
	public boolean delete(int id);
	public List<WorkShopDao> getAll();
	public boolean update(WorkShopDao item);
	public WorkShopDao get(int id);
	List<WorkShopDao> search(String phrase);
	
	
}
