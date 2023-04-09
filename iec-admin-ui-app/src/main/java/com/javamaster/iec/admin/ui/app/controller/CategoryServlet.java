/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.CategoryUtil;
import com.javamaster.iec.admin.ui.app.model.Category;
import com.javamaster.iec.admin.ui.app.model.Product;
import java.io.IOException;
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
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryUtil categoryUtil;

    public void init() {
        categoryUtil = new CategoryUtil();
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
                    insertCategory(request, response);
                    break;
                case "/delete":
                    deleteCategory(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCategory(request, response);
                    break;
                default:
                    listCategories(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listCategories = categoryUtil.selectAllCategories();
        request.setAttribute("listCategories", listCategories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        Category existingCategory = categoryUtil.selectCategory(categoryID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category-form.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String created_at = request.getParameter("created_at");
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        String updated_at = request.getParameter("updated_at");
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        List<Product> products = new ArrayList<>();
        Category newCategory = new Category(name, Timestamp.valueOf(created_at), created_by, Timestamp.valueOf(updated_at), updated_by, products);
        categoryUtil.insertCategory(newCategory);
        response.sendRedirect("list");
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        String name = request.getParameter("name");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));

        Category category = new Category(categoryID, name, created_at, created_by, updated_at, updated_by, null);
        categoryUtil.updateCategory(category);
        response.sendRedirect("list");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        categoryUtil.deleteCategory(categoryID);
        response.sendRedirect("list");
    }
}
