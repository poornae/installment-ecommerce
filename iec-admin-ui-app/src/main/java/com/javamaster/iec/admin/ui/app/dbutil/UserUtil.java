/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.dbutil;

/**
 *
 * @author poornae
 */
import com.javamaster.iec.admin.ui.app.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at) VALUES "
            + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at from user where userID =?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String DELETE_USERS_SQL = "delete from user where userID = ?;";
    private static final String UPDATE_USERS_SQL = "update user set username = ?, password = ?, email = ?, contact_no = ?, role = ?, permission = ?, created_at =?, created_by =?, updated_at= ?, updated_by=?, last_login_at =? where userID = ?;";

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

//Create or insert user
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getContact_no());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPermission());
            preparedStatement.setTimestamp(7, user.getCreated_at());
            preparedStatement.setInt(8, user.getCreated_by());
            preparedStatement.setTimestamp(9, user.getUpdated_at());
            preparedStatement.setInt(10, user.getUpdated_by());
            preparedStatement.setTimestamp(11, user.getLast_login_at());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Select user by id
    public User selectUser(int userID) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, userID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int contact_no = rs.getInt("contact_no");
                String role = rs.getString("role");
                String permission = rs.getString("permission");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");

                // Create a new user object with the retrieved values
                user = new User(userID, username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

//Select all users
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int contact_no = rs.getInt("contact_no");
                String role = rs.getString("role");
                String permission = rs.getString("permission");
                Timestamp created_at = rs.getTimestamp("created_at");
                int created_by = rs.getInt("created_by");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                Timestamp last_login_at = rs.getTimestamp("last_login_at");

                // Create a new user object with the retrieved values
                User user = new User(userID, username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at);
                // Add the user to the list of users
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

//delete user
    public boolean deleteUser(int userID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, userID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//update user
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getContact_no());
            statement.setString(5, user.getRole());
            statement.setString(6, user.getPermission());
            statement.setTimestamp(7, user.getCreated_at());
            statement.setInt(8, user.getCreated_by());
            statement.setTimestamp(9, user.getUpdated_at());
            statement.setInt(10, user.getUpdated_by());
            statement.setTimestamp(11, user.getLast_login_at());
            statement.setInt(12, user.getUserID());

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
