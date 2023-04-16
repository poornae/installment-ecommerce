/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutil;

/**
 *
 * @author poornae
 */
import model.Brand;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_BRANDS_SQL = "INSERT INTO brand" + "  (name, created_at, created_by, updated_at, updated_by, products) VALUES "
            + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_BRAND_BY_ID = "select name, created_at, created_by, updated_at, updated_by, products from brand where brandID =?";
    private static final String SELECT_ALL_BRANDS = "select * from brand";
    private static final String DELETE_BRANDS_SQL = "delete from brand where brandID = ?;";
    private static final String UPDATE_BRANDS_SQL = "update brand set name = ?, created_at =?, created_by =?, updated_at= ?, updated_by=?, products =? where brandID = ?;";

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

//Create or insert brand
    public void insertBrand(Brand brand) throws SQLException {
        System.out.println(INSERT_BRANDS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BRANDS_SQL)) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setTimestamp(2, brand.getCreated_at());
            preparedStatement.setInt(3, brand.getCreated_by());
            preparedStatement.setTimestamp(4, brand.getUpdated_at());
            preparedStatement.setInt(5, brand.getUpdated_by());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select brand by id
    public Brand selectBrand(int brandID) {
        Brand brand = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BRAND_BY_ID);) {
            preparedStatement.setInt(1, brandID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                // Create an empty list of products
                List<Product> products = new ArrayList<>();
                // Create a new Brand object with the retrieved values
                brand = new Brand(brandID, name, created_at, created_by, updated_at, updated_by, products);   
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return brand;
    }

//Select all brands
    public List<Brand> selectAllBrands() {
        List<Brand> brands = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BRANDS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int brandID = rs.getInt("brandID");
                String name = rs.getString("name");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                // Create an empty list of products
                List<Product> products = new ArrayList<>();
                // Create a new Brand object with the retrieved values
                Brand brand = new Brand(brandID, name, created_at, created_by, updated_at, updated_by, products);
                // Add the brand to the list of brands
                brands.add(brand);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return brands;
    }

//delete brand
    public boolean deleteBrand(int brandID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BRANDS_SQL);) {
            statement.setInt(1, brandID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update brand
    public boolean updateBrand(Brand brand) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BRANDS_SQL);) {
            statement.setString(1, brand.getName());
            statement.setTimestamp(2, brand.getCreated_at());
            statement.setInt(3, brand.getCreated_by());
            statement.setTimestamp(4, brand.getUpdated_at());
            statement.setInt(5, brand.getUpdated_by());
            statement.setInt(6, brand.getBrandID());

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
