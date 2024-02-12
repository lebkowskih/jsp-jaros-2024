package pl.jaros.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.*;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost/jsp-jaros";
    private static final String USERNAME = "jaros";
    private static final String PASSWORD = "zaq1@WSX";

    public void insert(Product product) throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "INSERT INTO products (name, price, supplier) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getSupplier());

            statement.executeUpdate();
        }
    }
}
