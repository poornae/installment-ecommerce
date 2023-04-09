/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.CustomerUtil;
import com.javamaster.iec.admin.ui.app.model.Customer;
import com.javamaster.iec.admin.ui.app.model.Loan;
import com.javamaster.iec.admin.ui.app.model.Order;
import com.javamaster.iec.admin.ui.app.model.Transaction;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerUtil customerUtil;

    public void init() {
        customerUtil = new CustomerUtil();
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
                case "/insert":
                    insertCustomer(request, response);
                    break;
                case "/delete":
                    deleteCustomer(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCustomer(request, response);
                    break;
                default:
                    listCustomers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomers = customerUtil.selectAllCustomers();
        request.setAttribute("listCustomers", listCustomers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        Customer existingCustomer = customerUtil.selectCustomer(customerID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String full_name = request.getParameter("full_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Date date_of_birth = Date.valueOf(request.getParameter("date_of_birth"));
        String nic_no = request.getParameter("nic_no");
        byte[] profile_image = request.getParameter("profile_image").getBytes();
        int contact_no = Integer.parseInt(request.getParameter("contact_no"));
        String address = request.getParameter("address");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        Timestamp last_login_at = Timestamp.valueOf(request.getParameter("last_login_at"));
        List<Loan> loans = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Customer newCustomer = new Customer(full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at, loans, orders, transactions);
        customerUtil.insertCustomer(newCustomer);
        response.sendRedirect("list");
    }


   private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        String full_name = request.getParameter("full_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Date date_of_birth = Date.valueOf(request.getParameter("date_of_birth"));
        String nic_no = request.getParameter("nic_no");
        byte[] profile_image = null; // modify accordingly
        int contact_no = Integer.parseInt(request.getParameter("contact_no"));
        String address = request.getParameter("address");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        Timestamp last_login_at = Timestamp.valueOf(request.getParameter("last_login_at"));
        List<Loan> loans = null; // modify accordingly
        List<Order> orders = null; // modify accordingly
        List<Transaction> transactions = null; // modify accordingly
        
        Customer customer = new Customer(customerID, full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at, loans, orders, transactions);
        customerUtil.updateCustomer(customer);
        response.sendRedirect("list");
    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        customerUtil.deleteCustomer(customerID);
        response.sendRedirect("list");
    }
}
