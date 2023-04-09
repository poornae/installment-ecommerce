/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.dbutil;

/**
 *
 * @author poornae
 */
import com.javamaster.iec.admin.ui.app.model.Administrator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.registry.infomodel.User;

public class AdministratorUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_ADMINISTRATORS_SQL = "INSERT INTO administrator" + "  (username, password, created_at, updated_at, last_login_at) VALUES "
            + " (?, ?, ?, ?, ?);";

    private static final String SELECT_ADMINISTRATOR_BY_ID = "select username, password, created_at, updated_at, last_login_at from administrator where adminID =?";
    private static final String SELECT_ALL_ADMINISTRATORS = "select * from administrator";
    private static final String DELETE_ADMINISTRATORS_SQL = "delete from administrator where adminID = ?;";
    private static final String UPDATE_ADMINISTRATORS_SQL = "update administrator set username = ?,password= ?, created_at =?,updated_at =?,last_login_at = ? where adminID = ?;";

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

//Create or insert admin
    public void insertAdministrator(Administrator administrator) throws SQLException {
        System.out.println(INSERT_ADMINISTRATORS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMINISTRATORS_SQL)) {
            preparedStatement.setString(1, administrator.getUsername());
            preparedStatement.setString(2, administrator.getPassword());
            preparedStatement.setTimestamp(3, administrator.getCreated_at());
            preparedStatement.setTimestamp(4, administrator.getUpdated_at());
            preparedStatement.setTimestamp(5, administrator.getLast_login_at());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select admin by id
    public Administrator selectAdministrator(int adminID) {
        Administrator administrator = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMINISTRATOR_BY_ID);) {
            preparedStatement.setInt(1, adminID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                Timestamp created_at = rs.getTimestamp("created_at");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");

                administrator = new Administrator(adminID, username, password, created_at, updated_at, last_login_at);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return administrator;
    }

//Select all admins
    public List< Administrator> selectAllAdministrators() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Administrator> administrators = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINISTRATORS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int adminID = rs.getInt("adminID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Timestamp created_at = rs.getTimestamp("created_at");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");
                administrators.add(new Administrator(adminID, username, password, created_at, updated_at, last_login_at));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return administrators;
    }

//delete admin
    public boolean deleteAdministrator(int adminID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ADMINISTRATORS_SQL);) {
            statement.setInt(1, adminID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update admin
    public boolean updateAdministrator(Administrator administrator) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ADMINISTRATORS_SQL);) {
            statement.setString(1, administrator.getUsername());
            statement.setString(2, administrator.getPassword());
            statement.setTimestamp(3, administrator.getCreated_at());
            statement.setTimestamp(4, administrator.getUpdated_at());
            statement.setTimestamp(5, administrator.getLast_login_at());

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
