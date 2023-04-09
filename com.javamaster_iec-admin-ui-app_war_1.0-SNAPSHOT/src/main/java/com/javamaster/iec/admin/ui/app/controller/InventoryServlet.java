/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.InventoryUtil;
import com.javamaster.iec.admin.ui.app.model.Inventory;
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
public class InventoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private InventoryUtil inventoryUtil;

    public void init() {
        inventoryUtil = new InventoryUtil();
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
                    insertInventory(request, response);
                    break;
                case "/delete":
                    deleteInventory(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateInventory(request, response);
                    break;
                default:
                    listInventories(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listInventories(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Inventory> listInventories = inventoryUtil.selectAllInventories();
        request.setAttribute("listInventories", listInventories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("inventory-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("inventory-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int inventoryID = Integer.parseInt(request.getParameter("inventoryID"));
        Inventory existingInventory = inventoryUtil.selectInventory(inventoryID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("inventory-form.jsp");
        request.setAttribute("inventory", existingInventory);
        dispatcher.forward(request, response);
    }

    private void insertInventory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int available_quantity = Integer.parseInt(request.getParameter("available_quantity"));
        String[] availability_status_array = request.getParameterValues("availability_status");
        Boolean[] availability_status = new Boolean[availability_status_array.length];
        for (int i = 0; i < availability_status_array.length; i++) {
            availability_status[i] = Boolean.valueOf(availability_status_array[i]);
        }
        Float unit_cost_price = Float.parseFloat(request.getParameter("unit_cost_price"));
        Float unit_selling_price = Float.parseFloat(request.getParameter("unit_selling_price"));
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        Inventory newInventory = new Inventory(name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id);
        inventoryUtil.insertInventory(newInventory);
        response.sendRedirect("list");
    }

    private void updateInventory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int inventoryID = Integer.parseInt(request.getParameter("inventoryID"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int available_quantity = Integer.parseInt(request.getParameter("available_quantity"));
        Boolean[] availability_status = {Boolean.parseBoolean(request.getParameter("availability_status"))};
        Float unit_cost_price = Float.parseFloat(request.getParameter("unit_cost_price"));
        Float unit_selling_price = Float.parseFloat(request.getParameter("unit_selling_price"));
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int product_id = Integer.parseInt(request.getParameter("product_id"));

        Inventory inventory = new Inventory(inventoryID, name, type, available_quantity, availability_status, unit_cost_price, unit_selling_price, created_at, created_by, updated_at, updated_by, product_id);
        inventoryUtil.updateInventory(inventory);
        response.sendRedirect("list");
    }

    private void deleteInventory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int inventoryID = Integer.parseInt(request.getParameter("inventoryID"));
        inventoryUtil.deleteInventory(inventoryID);
        response.sendRedirect("list");
    }
}
