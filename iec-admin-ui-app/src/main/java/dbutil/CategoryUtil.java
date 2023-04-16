/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutil;

/**
 *
 * @author poornae
 */
import model.Category;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_CATERGORIES_SQL = "INSERT INTO category" + "  (name, created_at, created_by, updated_at, updated_by, products) VALUES "
            + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CATERGORY_BY_ID = "select name, created_at, created_by, updated_at, updated_by, products from category where categoryID =?";
    private static final String SELECT_ALL_CATERGORIES = "select * from category";
    private static final String DELETE_CATERGORIES_SQL = "delete from category where categoryID = ?;";
    private static final String UPDATE_CATERGORIES_SQL = "update category set name = ?, created_at =?, created_by =?, updated_at= ?, updated_by=?, products =? where categoryID = ?;";

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

//Create or insert Category
    public void insertCategory(Category category) throws SQLException {
        System.out.println(INSERT_CATERGORIES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATERGORIES_SQL)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setTimestamp(2, category.getCreated_at());
            preparedStatement.setInt(3, category.getCreated_by());
            preparedStatement.setTimestamp(4, category.getUpdated_at());
            preparedStatement.setInt(5, category.getUpdated_by());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select category by id
    public Category selectCategory(int categoryID) {
        Category category = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATERGORY_BY_ID);) {
            preparedStatement.setInt(1, categoryID);
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
                // Create a new Category object with the retrieved values
                category = new Category(categoryID, name, created_at, created_by, updated_at, updated_by, products);   
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

//Select all categories
    public List<Category> selectAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATERGORIES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("categoryID");
                String name = rs.getString("name");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                // Create an empty list of products
                List<Product> products = new ArrayList<>();
                // Create a new Category object with the retrieved values
                Category category = new Category(categoryID, name, created_at, created_by, updated_at, updated_by, products);
                // Add the Category to the list of categories
                categories.add(category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }

//delete category
    public boolean deleteCategory(int categoryID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CATERGORIES_SQL);) {
            statement.setInt(1, categoryID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update category
    public boolean updateCategory(Category category) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CATERGORIES_SQL);) {
            statement.setString(1, category.getName());
            statement.setTimestamp(2, category.getCreated_at());
            statement.setInt(3, category.getCreated_by());
            statement.setTimestamp(4, category.getUpdated_at());
            statement.setInt(5, category.getUpdated_by());
            statement.setInt(6, category.getCategoryID());

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
