/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.controller;

import com.javamaster.iec.admin.ui.app.dbutil.BrandUtil;
import com.javamaster.iec.admin.ui.app.model.Brand;
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
public class BrandServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BrandUtil brandUtil;

    public void init() {
        brandUtil = new BrandUtil();
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
                    insertBrand(request, response);
                    break;
                case "/delete":
                    deleteBrand(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBrand(request, response);
                    break;
                default:
                    listBrand(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Brand> listBrand = brandUtil.selectAllBrands();
        request.setAttribute("listBrand", listBrand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int brandID = Integer.parseInt(request.getParameter("brandID"));
        Brand existingBrand = brandUtil.selectBrand(brandID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        request.setAttribute("brand", existingBrand);
        dispatcher.forward(request, response);
    }

    private void insertBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));

        List<Product> products = new ArrayList<>(); // create an empty list of products for the brand

        Brand newBrand = new Brand(name, created_at, created_by, updated_at, updated_by, products);
        brandUtil.insertBrand(newBrand);
        response.sendRedirect("list");
    }

    private void updateBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int brandID = Integer.parseInt(request.getParameter("brandID"));
        String name = request.getParameter("name");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));

        List<Product> products = new ArrayList<>(); // create an empty list of products for the brand

        Brand book = new Brand(brandID, name, created_at, created_by, updated_at, updated_by, products);
        brandUtil.updateBrand(book);
        response.sendRedirect("list");
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int brandID = Integer.parseInt(request.getParameter("brandID"));
        brandUtil.deleteBrand(brandID);
        response.sendRedirect("list");

    }
}
