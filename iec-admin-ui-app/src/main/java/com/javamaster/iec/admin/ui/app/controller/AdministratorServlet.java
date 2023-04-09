/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.AdministratorUtil;
import com.javamaster.iec.admin.ui.app.model.Administrator;
import java.io.IOException;
import java.sql.SQLException;
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
public class AdministratorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerUtil customerUtil;

    public AdministratorServlet() {
        this.customerUtil = new customerUtil();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
            try {
                insertCustomer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "/delete":
                try {
                deleteCustomer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "/edit":
            try {
                showEditForm(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "/update":
            try {
                updateCustomer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            default:
            try {
                listCustomer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        }

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Customer> listCustomer = customerUtil.selectAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
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
        String date_of_birth = request.getParameter("date_of_birth");
        String nic_no = request.getParameter("nic_no");
        String profile_image = request.getParameter("profile_image");
        String contact_no = request.getParameter("contact_no");
        String address = request.getParameter("address");
        String created_at = request.getParameter("created_at");
        String updated_at = request.getParameter("updated_at");
        String last_login_at = request.getParameter("last_login_at");
        Customer newCustomer = new Customer(full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at);
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
        String date_of_birth = request.getParameter("date_of_birth");
        String nic_no = request.getParameter("nic_no");
        String profile_image = request.getParameter("profile_image");
        String contact_no = request.getParameter("contact_no");
        String address = request.getParameter("address");
        String created_at = request.getParameter("created_at");
        String updated_at = request.getParameter("updated_at");
        String last_login_at = request.getParameter("last_login_at");

        Customer book = new Customer(customerID, full_name, username, password, email, date_of_birth, nic_no, profile_image, contact_no, address, created_at, updated_at, last_login_at);
        customerUtil.updateCustomer(book);
        response.sendRedirect("list");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        customerUtil.deleteCustomer(customerID);
        response.sendRedirect("list");

    }
}
