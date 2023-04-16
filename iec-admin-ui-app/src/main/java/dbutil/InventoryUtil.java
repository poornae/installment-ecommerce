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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_INVENTORY_SQL = "INSERT INTO inventory" + " (name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_INVENTORY_BY_ID = "select name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id from inventory where inventoryID =?";
    private static final String SELECT_ALL_INVENTORIES = "select * from inventory";
    private static final String DELETE_INVENTORY_SQL = "delete from inventory where inventoryID = ?;";
    private static final String UPDATE_INVENTORY_SQL = "update inventory set name = ?, type = ?, available_quantity = ?, availability_status = ?, unit_cost_price = ?, unit_selling_price = ?, created_at =?, created_by =?, updated_at= ?, updated_by=?, product_id = ? where inventoryID = ?;";

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

//Create or insert inventory
    public void insertInventory(Inventory inventory) throws SQLException {
        System.out.println(INSERT_INVENTORY_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INVENTORY_SQL)) {
            preparedStatement.setString(1, inventory.getName());
            preparedStatement.setString(2, inventory.getType());
            preparedStatement.setInt(3, inventory.getAvailable_quantity());
            preparedStatement.setArray(4, connection.createArrayOf("boolean", inventory.getAvailability_status()));
            preparedStatement.setFloat(5, inventory.getUnit_cost_price());
            preparedStatement.setFloat(6, inventory.getUnit_selling_price());
            preparedStatement.setTimestamp(7, inventory.getCreated_at());
            preparedStatement.setInt(8, inventory.getCreated_by());
            preparedStatement.setTimestamp(9, inventory.getUpdated_at());
            preparedStatement.setInt(10, inventory.getUpdated_by());
            preparedStatement.setInt(11, inventory.getProduct_id());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select inventory by id
    public Inventory selectInventory(int inventoryID) {
        Inventory inventory = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INVENTORY_BY_ID);) {
            preparedStatement.setInt(1, inventoryID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int available_quantity = rs.getInt("available_quantity");
                Array availability_status_array = rs.getArray("availability_status");
                Boolean[] availability_status = (Boolean[]) availability_status_array.getArray();
                Float unit_cost_price = rs.getFloat("unit_cost_price");
                Float unit_selling_price = rs.getFloat("unit_selling_price");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int product_id = rs.getInt("product_id");

                // Create a new inventory object with the retrieved values
                inventory = new Inventory(inventoryID, name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return inventory;
    }

//Select all inventories
    public List<Inventory> selectAllInventories() {
        List<Inventory> inventories = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INVENTORIES)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int inventoryID = rs.getInt("inventoryID");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int available_quantity = rs.getInt("available_quantity");
                Array availability_status_array = rs.getArray("availability_status");
                Boolean[] availability_status = (Boolean[]) availability_status_array.getArray();
                Float unit_cost_price = rs.getFloat("unit_cost_price");
                Float unit_selling_price = rs.getFloat("unit_selling_price");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int product_id = rs.getInt("product_id");

                // Create a new inventory object with the retrieved values
                Inventory inventory = new Inventory(inventoryID, name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id);
                // Add the inventory to the list of inventories
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return inventories;
    }

//delete inventory
    public boolean deleteInventory(int inventoryID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_INVENTORY_SQL);) {
            statement.setInt(1, inventoryID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update inventory
    public boolean updateInventory(Inventory inventory) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_INVENTORY_SQL);) {
            statement.setString(1, inventory.getName());
            statement.setString(2, inventory.getType());
            statement.setInt(3, inventory.getAvailable_quantity());
            statement.setArray(4, connection.createArrayOf("boolean", inventory.getAvailability_status()));
            statement.setFloat(5, inventory.getUnit_cost_price());
            statement.setFloat(6, inventory.getUnit_selling_price());
            statement.setTimestamp(7, inventory.getCreated_at());
            statement.setInt(8, inventory.getCreated_by());
            statement.setTimestamp(9, inventory.getUpdated_at());
            statement.setInt(10, inventory.getUpdated_by());
            statement.setInt(11, inventory.getProduct_id());
            statement.setInt(12, inventory.getInventoryID());

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
