/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbutil.ProductUtil;
import model.Inventory;
import model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductUtil productUtil;

    public void init() {
        productUtil = new ProductUtil();
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
                    insertProduct(request, response);
                    break;
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateProduct(request, response);
                    break;
                default:
                    listProducts(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> productList = productUtil.selectAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manage-products.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        Product existingProduct = productUtil.selectProduct(productID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Float original_price = Float.parseFloat(request.getParameter("original_price"));
        Float discount = Float.parseFloat(request.getParameter("discount"));
        Float discounted_price = Float.parseFloat(request.getParameter("discounted_price"));
        Byte[] image = null; // assuming no image is uploaded for this example
        Timestamp created_at = Timestamp.valueOf(LocalDateTime.now());
        int created_by = 1; // assuming the logged-in administrator's ID is 1 for this example
        Timestamp updated_at = Timestamp.valueOf(LocalDateTime.now());
        int updated_by = 1; // assuming the logged-in administrator's ID is 1 for this example
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        List<Inventory> inventories = new ArrayList<>(); // assuming no inventories are added for this example
        Product newProduct = new Product(name, description, image, original_price, discount, discounted_price, created_at, created_by, updated_at, updated_by, category_id, brand_id, inventories);
        productUtil.insertProduct(newProduct);
        response.sendRedirect("manage-products.jsp");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Byte[] image = null; // change this to your implementation for handling images
        Float original_price = Float.parseFloat(request.getParameter("original_price"));
        Float discount = Float.parseFloat(request.getParameter("discount"));
        Float discounted_price = Float.parseFloat(request.getParameter("discounted_price"));
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));

        // get the inventories from the request and create a new list
        List<Inventory> inventories = new ArrayList<>();
        // implementation for getting inventories from request goes here

        Product product = new Product(productID, name, description, image, original_price, discount, discounted_price, created_at, created_by, updated_at, updated_by, category_id, brand_id, inventories);
        productUtil.updateProduct(product);
        response.sendRedirect("manage-products.jsp");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        productUtil.deleteProduct(productID);
        response.sendRedirect("manage-products.jsp");
    }

}
