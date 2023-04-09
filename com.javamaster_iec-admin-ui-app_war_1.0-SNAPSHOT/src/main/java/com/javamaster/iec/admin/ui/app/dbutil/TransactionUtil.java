/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.dbutil;

/**
 *
 * @author poornae
 */
import com.javamaster.iec.admin.ui.app.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String SELECT_TRANSACTION_BY_ID = "SELECT * FROM transaction WHERE transactionID = ?";
    private static final String SELECT_ALL_TRANSACTIONS = "SELECT * FROM transaction";
    private static final String UPDATE_TRANSACTION_SQL = "UPDATE transaction SET transaction_date = ?, transaction_amount = ?, payment_method = ?, payment_status = ?, promo_code = ?, updated_at = ?, updated_by = ?, customer_id = ?, loan_id = ?, order_id = ? WHERE transactionID = ?";

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

//Select transaction by id
    public Transaction selectTransaction(int transactionID) {
        Transaction transaction = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSACTION_BY_ID);) {
            preparedStatement.setInt(1, transactionID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Date transaction_date = rs.getDate("transaction_date");
                Float transaction_amount = rs.getFloat("transaction_amount");
                String payment_method = rs.getString("payment_method");
                String payment_status = rs.getString("payment_status");
                String promo_code = rs.getString("promo_code");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");
                int loan_id = rs.getInt("loan_id");
                int order_id = rs.getInt("order_id");
                transaction = new Transaction(transactionID, transaction_date, transaction_amount, payment_method, payment_status, promo_code, updated_at, updated_by, customer_id, loan_id, order_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return transaction;
    }

//Select all transactions
    public List<Transaction> selectAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTIONS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int transactionID = rs.getInt("transactionID");
                Date transaction_date = rs.getDate("transaction_date");
                Float transaction_amount = rs.getFloat("transaction_amount");
                String payment_method = rs.getString("payment_method");
                String payment_status = rs.getString("payment_status");
                String promo_code = rs.getString("promo_code");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");
                int loan_id = rs.getInt("loan_id");
                int order_id = rs.getInt("order_id");
                Transaction transaction = new Transaction(transactionID, transaction_date, transaction_amount, payment_method, payment_status, promo_code, updated_at, updated_by, customer_id, loan_id, order_id);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return transactions;
    }

//update transaction
    public boolean updateTransaction(Transaction transaction) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TRANSACTION_SQL);) {
            statement.setDate(1, transaction.getTransaction_date());
            statement.setFloat(2, transaction.getTransaction_amount());
            statement.setString(3, transaction.getPayment_method());
            statement.setString(4, transaction.getPayment_status());
            statement.setString(5, transaction.getPromo_code());
            statement.setTimestamp(6, transaction.getUpdated_at());
            statement.setInt(7, transaction.getUpdated_by());
            statement.setInt(8, transaction.getCustomer_id());
            statement.setInt(9, transaction.getLoan_id());
            statement.setInt(10, transaction.getOrder_id());
            statement.setInt(11, transaction.getTransactionID());

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
