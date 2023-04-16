/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbutil.LoanUtil;
import model.Loan;
import model.Transaction;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author poornae
 */
@WebServlet("/")
public class LoanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoanUtil loanUtil;

    public void init() {
        loanUtil = new LoanUtil();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateLoan(request, response);
                    break;
                default:
                    listLoans(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLoans(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Loan> listLoans = loanUtil.selectAllLoans();
        request.setAttribute("listLoans", listLoans);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manage-loans.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loan-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int loanID = Integer.parseInt(request.getParameter("loanID"));
        Loan existingLoan = loanUtil.selectLoan(loanID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loan-form.jsp");
        request.setAttribute("loan", existingLoan);
        dispatcher.forward(request, response);
    }

    private void updateLoan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int loanID = Integer.parseInt(request.getParameter("loanID"));
        Float loan_amount = Float.parseFloat(request.getParameter("loan_amount"));
        String loan_term = request.getParameter("loan_term");
        Float installment_amount = Float.parseFloat(request.getParameter("installment_amount"));
        int remaining_installment = Integer.parseInt(request.getParameter("remaining_installment"));
        Float late_payment = Float.parseFloat(request.getParameter("late_payment"));
        Date loan_start_date = Date.valueOf(request.getParameter("loan_start_date"));
        Date loan_end_date = Date.valueOf(request.getParameter("loan_end_date"));
        String loan_status = request.getParameter("loan_status");
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        List<Transaction> transactions = null; // You can update this according to your implementation

        Loan loan = new Loan(loanID, loan_amount, loan_term, installment_amount, remaining_installment, late_payment, loan_start_date, loan_end_date, loan_status, updated_at, updated_by, customer_id, transactions);
        loanUtil.updateLoan(loan);
        response.sendRedirect("manage-loans.jsp");
    }
}
