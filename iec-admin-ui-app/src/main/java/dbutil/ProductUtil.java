/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutil;

/**
 *
 * @author poornae
 */
import model.Inventory;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO product"
            + "  (name, description, image, original_price, discount, discounted_price, created_at, created_by, updated_at, updated_by, category_id, brand_id) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE productID = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE productID = ?";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET name = ?, description = ?, image = ?, original_price = ?, discount = ?, discounted_price = ?, created_at = ?, created_by = ?, updated_at = ?, updated_by = ?, category_id = ?, brand_id = ? WHERE productID = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

//Create or insert product
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setObject(3, product.getImage());
            preparedStatement.setFloat(4, product.getOriginal_price());
            preparedStatement.setFloat(5, product.getDiscount());
            preparedStatement.setFloat(6, product.getDiscounted_price());
            preparedStatement.setTimestamp(7, product.getCreated_at());
            preparedStatement.setInt(8, product.getCreated_by());
            preparedStatement.setTimestamp(9, product.getUpdated_at());
            preparedStatement.setInt(10, product.getUpdated_by());
            preparedStatement.setInt(11, product.getCategory_id());
            preparedStatement.setInt(12, product.getBrand_id());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select product by id
    public Product selectProduct(int productID) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, productID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Byte[] image = (Byte[]) rs.getObject("image");
                Float original_price = rs.getFloat("original_price");
                Float discount = rs.getFloat("discount");
                Float discounted_price = rs.getFloat("discounted_price");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int category_id = rs.getInt("category_id");
                int brand_id = rs.getInt("brand_id");
                // Create an empty list of inventories
                List<Inventory> inventories = new ArrayList<>();
                // Create a new Product object with the retrieved values
                product = new Product(productID, name, description, image, original_price, discount, discounted_price, created_at, created_by, updated_at, updated_by, category_id, brand_id, inventories);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

//Select all products
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Byte[] image = (Byte[]) rs.getObject("image");
                Float original_price = rs.getFloat("original_price");
                Float discount = rs.getFloat("discount");
                Float discounted_price = rs.getFloat("discounted_price");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int category_id = rs.getInt("category_id");
                int brand_id = rs.getInt("brand_id");
                // Create an empty list of inventories
                List<Inventory> inventories = new ArrayList<>();
                // Create a new Product object with the retrieved values
                Product product = new Product(productID, name, description, image, original_price, discount, discounted_price, created_at, created_by, updated_at, updated_by, category_id, brand_id, inventories);
                // Add the product to the list of products
                products.add(product);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

//delete product
    public boolean deleteProduct(int productID) throws SQLException {
    boolean rowDeleted;
    try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
        statement.setInt(1, productID);
        rowDeleted = statement.executeUpdate() > 0;
    }
    return rowDeleted;
}


//update product
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setObject(3, product.getImage());
            statement.setFloat(4, product.getOriginal_price());
            statement.setFloat(5, product.getDiscount());
            statement.setFloat(6, product.getDiscounted_price());
            statement.setTimestamp(7, product.getCreated_at());
            statement.setInt(8, product.getCreated_by());
            statement.setTimestamp(9, product.getUpdated_at());
            statement.setInt(10, product.getUpdated_by());
            statement.setInt(11, product.getCategory_id());
            statement.setInt(12, product.getBrand_id());
            statement.setInt(13, product.getProductID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
