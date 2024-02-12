package pl.jaros.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY price";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String supplier = resultSet.getString("supplier");

                Product product = new Product(name, price, supplier);
                products.add(product);
            }
        }

        return products;
    }
}
