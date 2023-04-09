/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.OrderUtil;
import com.javamaster.iec.admin.ui.app.model.Order;
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
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OrderUtil orderUtil;

    public void init() {
        orderUtil = new OrderUtil();
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
                    updateOrder(request, response);
                    break;
                default:
                    listOrders(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listOrders = orderUtil.selectAllOrders();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("inventory-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        Order existingOrder = orderUtil.selectOrder(orderID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-form.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        Date order_date = Date.valueOf(request.getParameter("order_date"));
        Float order_total = Float.parseFloat(request.getParameter("order_total"));
        String order_status = request.getParameter("order_status");
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));

        // Assuming that the transactions are being updated separately, we can set the transactions field to null
        List<Transaction> transactions = null;

        Order order = new Order(orderID, order_date, order_total, order_status, updated_at, updated_by, customer_id, transactions);
        orderUtil.updateOrder(order);
        response.sendRedirect("list");
    }
}
