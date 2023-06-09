/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutil;

/**
 *
 * @author poornae
 */
import model.Customer;
import model.Loan;
import model.Order;
import model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "Chithmini1996";

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer" + "  (full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at from customer where customerID =?";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customer where customerID = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customer set full_name = ?,username= ?, password =?,email =?,date_of_birth = ?,nic_no= ?, profile_image =?,contact_no = ?,address= ?, created_at =?,updated_at= ?, last_login_at =? where customerID = ?;";

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

//Create or insert customer
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setString(1, customer.getFull_name());
            preparedStatement.setString(2, customer.getUsername());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setDate(5, customer.getDate_of_birth());
            preparedStatement.setString(6, customer.getNic_no());
            preparedStatement.setBytes(7, customer.getProfile_image());
            preparedStatement.setInt(8, customer.getContact_no());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.setTimestamp(10, customer.getCreated_at());
            preparedStatement.setTimestamp(11, customer.getUpdated_at());
            preparedStatement.setTimestamp(12, customer.getLast_login_at());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select Customer by id
    public Customer selectCustomer(int customerID) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, customerID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("customerID");
                String full_name = rs.getString("full_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date date_of_birth = rs.getDate("date_of_birth");
                String nic_no = rs.getString("nic_no");
                byte[] profile_image = rs.getBytes("profile_image");
                int contact_no = rs.getInt("contact_no");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");
                List<Loan> loans = null; // modify accordingly
                List<Order> orders = null; // modify accordingly
                List<Transaction> transactions = null; // modify accordingly
                customer = new Customer(id, full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at, loans, orders, transactions);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

//Select all customers
    public List<Customer> selectAllCustomers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customerID = rs.getInt("customerID");
                String full_name = rs.getString("full_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date date_of_birth = rs.getDate("date_of_birth");
                String nic_no = rs.getString("nic_no");
                byte[] profile_image = rs.getBytes("profile_image");
                int contact_no = rs.getInt("contact_no");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");
                List<Loan> loans = new ArrayList<>();
                List<Order> orders = new ArrayList<>();
                List<Transaction> transactions = new ArrayList<>();
                Customer customer = new Customer(customerID, full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at, loans, orders, transactions);
                customers.add(customer);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

//delete customer
    public boolean deleteCustomer(int customerID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
            statement.setInt(1, customerID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update customer
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
            statement.setString(1, customer.getFull_name());
            statement.setString(2, customer.getUsername());
            statement.setString(3, customer.getPassword());
            statement.setString(4, customer.getEmail());
            statement.setDate(5, customer.getDate_of_birth());
            statement.setString(6, customer.getNic_no());
            statement.setBytes(7, customer.getProfile_image());
            statement.setInt(8, customer.getContact_no());
            statement.setString(9, customer.getAddress());
            statement.setTimestamp(10, customer.getCreated_at());
            statement.setTimestamp(11, customer.getUpdated_at());
            statement.setTimestamp(12, customer.getLast_login_at());
            statement.setInt(13, customer.getCustomerID());

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
