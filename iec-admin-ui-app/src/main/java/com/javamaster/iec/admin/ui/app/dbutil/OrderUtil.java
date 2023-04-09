/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.dbutil;

/**
 *
 * @author poornae
 */
import com.javamaster.iec.admin.ui.app.model.Order;
import com.javamaster.iec.admin.ui.app.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String SELECT_ORDER_BY_ID = "select orderID, order_date, order_total, order_status, updated_at, updated_by, customer_id from orders where orderID =?";
    private static final String SELECT_ALL_ORDERS = "select * from orders";
    private static final String UPDATE_ORDER_SQL = "update orders set order_date = ?, order_total = ?, order_status = ?, updated_at = ?, updated_by = ?, customer_id = ? where orderID = ?;";

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

//Select order by id
    public Order selectOrder(int orderID) {
        Order order = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, orderID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Date order_date = rs.getDate("order_date");
                Float order_total = rs.getFloat("order_total");
                String order_status = rs.getString("order_status");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");
                // Create an empty list of transactions
                List<Transaction> transactions = new ArrayList<>();
                // Create a new Order object with the retrieved values
                order = new Order(orderID, order_date, order_total, order_status, updated_at, updated_by, customer_id, transactions);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

//Select all orders
    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                Date order_date = rs.getDate("order_date");
                Float order_total = rs.getFloat("order_total");
                String order_status = rs.getString("order_status");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");
                // Create an empty list of transactions
                List<Transaction> transactions = new ArrayList<>();
                // Create a new Order object with the retrieved values
                Order order = new Order(orderID, order_date, order_total, order_status, updated_at, updated_by, customer_id, transactions);
                // Add the order to the list of orders
                orders.add(order);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orders;
    }

//update order
    public boolean updateOrder(Order order) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL);) {
            statement.setDate(1, order.getOrder_date());
            statement.setFloat(2, order.getOrder_total());
            statement.setString(3, order.getOrder_status());
            statement.setTimestamp(4, order.getUpdated_at());
            statement.setInt(5, order.getUpdated_by());
            statement.setInt(6, order.getCustomer_id());
            statement.setInt(7, order.getOrderID());

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
