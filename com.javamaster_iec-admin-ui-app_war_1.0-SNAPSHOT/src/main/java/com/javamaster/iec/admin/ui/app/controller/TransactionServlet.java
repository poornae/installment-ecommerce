/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.TransactionUtil;
import com.javamaster.iec.admin.ui.app.model.Transaction;
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
public class TransactionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransactionUtil transactionUtil;

    public void init() {
        transactionUtil = new TransactionUtil();
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
                    updateTransaction(request, response);
                    break;
                default:
                    listTransactions(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTransactions(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Transaction> transactionList = transactionUtil.selectAllTransactions();
        request.setAttribute("transactionList", transactionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("transaction-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int transactionID = Integer.parseInt(request.getParameter("transactionID"));
        Transaction existingTransaction = transactionUtil.selectTransaction(transactionID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("transaction-form.jsp");
        request.setAttribute("transaction", existingTransaction);
        dispatcher.forward(request, response);
    }

    private void updateTransaction(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int transactionID = Integer.parseInt(request.getParameter("transactionID"));
        Date transaction_date = Date.valueOf(request.getParameter("transaction_date"));
        Float transaction_amount = Float.parseFloat(request.getParameter("transaction_amount"));
        String payment_method = request.getParameter("payment_method");
        String payment_status = request.getParameter("payment_status");
        String promo_code = request.getParameter("promo_code");
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int loan_id = Integer.parseInt(request.getParameter("loan_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));

        Transaction transaction = new Transaction(transactionID, transaction_date, transaction_amount, payment_method, payment_status, promo_code, updated_at, updated_by, customer_id, loan_id, order_id);
        transactionUtil.updateTransaction(transaction);
        response.sendRedirect("list");
    }

}
