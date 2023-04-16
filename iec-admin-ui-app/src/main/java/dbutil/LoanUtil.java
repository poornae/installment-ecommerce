/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutil;

/**
 *
 * @author poornae
 */
import model.Loan;
import model.Transaction;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanUtil {

    String jdbcURL = "jdbc:mysql://localhost:3306/ecommercedb";
    String jdbcUsername = "root";
    String jdbcPassword = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";

    private static final String SELECT_LOAN_BY_ID = "select * from loan where loanID =?";
    private static final String SELECT_ALL_LOANS = "select * from loan";
    private static final String SELECT_TRANSACTIONS_BY_LOAN_ID = "select * FROM transaction where loan_id = ?";
    private static final String UPDATE_LOAN_SQL = "update loan set loan_amount = ?, loan_term = ?, installment_amount = ?, remaining_installment = ?, late_payment = ?, loan_start_date = ?, loan_end_date = ?, loan_status = ?, updated_at =?, updated_by =?, customer_id =? where loanID = ?;";

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

    public List<Transaction> selectAllTransactionsByLoanId(int loanId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction WHERE loan_id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loanId);
            ResultSet rs = pstmt.executeQuery();
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
            // handle exception
        }
        return transactions;
    }

//Select loan by id
    public Loan selectLoan(int loanID) {
        Loan loan = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOAN_BY_ID);) {
            preparedStatement.setInt(1, loanID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Float loan_amount = rs.getFloat("loan_amount");
                String loan_term = rs.getString("loan_term");
                Float installment_amount = rs.getFloat("installment_amount");
                int remaining_installment = rs.getInt("remaining_installment");
                Float late_payment = rs.getFloat("late_payment");
                Date loan_start_date = rs.getDate("loan_start_date");
                Date loan_end_date = rs.getDate("loan_end_date");
                String loan_status = rs.getString("loan_status");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");

                // Retrieve the transactions for the loan
                List<Transaction> transactions = new ArrayList<>();
                PreparedStatement transactionStatement = connection.prepareStatement(SELECT_TRANSACTIONS_BY_LOAN_ID);
                transactionStatement.setInt(1, loanID);
                ResultSet transactionRs = transactionStatement.executeQuery();
                while (transactionRs.next()) {
                    int transactionID = transactionRs.getInt("transaction_id");
                    Float amount = transactionRs.getFloat("amount");
                    Date transaction_date = transactionRs.getDate("transaction_date");
                }

                // Create a new loan object with the retrieved values and transactions
                loan = new Loan(loanID, loan_amount, loan_term, installment_amount, remaining_installment, late_payment, loan_start_date, loan_end_date, loan_status, updated_at, updated_by, customer_id, transactions);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loan;
    }

//Select all loans
    public List<Loan> selectAllLoans() {
        List<Loan> loans = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOANS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int loanID = rs.getInt("loanID");
                Float loan_amount = rs.getFloat("loan_amount");
                String loan_term = rs.getString("loan_term");
                Float installment_amount = rs.getFloat("installment_amount");
                int remaining_installment = rs.getInt("remaining_installment");
                Float late_payment = rs.getFloat("late_payment");
                Date loan_start_date = rs.getDate("loan_start_date");
                Date loan_end_date = rs.getDate("loan_end_date");
                String loan_status = rs.getString("loan_status");
                Timestamp updated_at = rs.getTimestamp("updated_at");
                int updated_by = rs.getInt("updated_by");
                int customer_id = rs.getInt("customer_id");
                List<Transaction> transactions = selectAllTransactionsByLoanId(loanID); // assuming a function to retrieve transactions by loan ID

                // Create a new Loan object with the retrieved values
                Loan loan = new Loan(loanID, loan_amount, loan_term, installment_amount, remaining_installment, late_payment, loan_start_date, loan_end_date, loan_status, updated_at, updated_by, customer_id, transactions);
                // Add the loan to the list of loans
                loans.add(loan);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loans;
    }

//update loan
    public boolean updateLoan(Loan loan) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_LOAN_SQL);) {
            statement.setFloat(1, loan.getLoan_amount());
            statement.setString(2, loan.getLoan_term());
            statement.setFloat(3, loan.getInstallment_amount());
            statement.setInt(4, loan.getRemaining_installment());
            statement.setFloat(5, loan.getLate_payment());
            statement.setDate(6, loan.getLoan_start_date());
            statement.setDate(7, loan.getLoan_end_date());
            statement.setString(8, loan.getLoan_status());
            statement.setTimestamp(9, loan.getUpdated_at());
            statement.setInt(10, loan.getUpdated_by());
            statement.setInt(11, loan.getCustomer_id());
            statement.setInt(12, loan.getLoanID());

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
