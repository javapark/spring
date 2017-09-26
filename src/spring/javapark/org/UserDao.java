package spring.javapark.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "mysql");

		String sql = "insert into users(id, name, password)values(?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3,  user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
}
