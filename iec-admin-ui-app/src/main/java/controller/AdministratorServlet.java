/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbutil.AdministratorUtil;
import model.Administrator;
import java.io.IOException;
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
public class AdministratorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdministratorUtil administratorUtil;

    public void init() {
        administratorUtil = new AdministratorUtil();
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
                    insertAdministrator(request, response);
                    break;
                case "/delete":
                    deleteAdministrator(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateAdministrator(request, response);
                    break;
                default:
                    listAdministrator(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAdministrator(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Administrator> listAdministrator = administratorUtil.selectAllAdministrators();
        request.setAttribute("listAdministrator", listAdministrator);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manage-users.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int adminID = Integer.parseInt(request.getParameter("adminID"));
        Administrator existingAdministrator = administratorUtil.selectAdministrator(adminID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("administator", existingAdministrator);
        dispatcher.forward(request, response);
    }

    private void insertAdministrator(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String created_at = request.getParameter("created_at");
        String updated_at = request.getParameter("updated_at");
        String last_login_at = request.getParameter("last_login_at");
        Administrator newAdmin = new Administrator(username, password, Timestamp.valueOf(created_at), Timestamp.valueOf(updated_at), Timestamp.valueOf(last_login_at));
        administratorUtil.insertAdministrator(newAdmin);
        response.sendRedirect("manage-users.jsp");
    }

    private void updateAdministrator(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int adminID = Integer.parseInt(request.getParameter("adminID"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        Timestamp last_login_at = Timestamp.valueOf(request.getParameter("last_login_at"));

        Administrator admin = new Administrator(adminID, username, password, created_at, updated_at, last_login_at);
        administratorUtil.updateAdministrator(admin);
        response.sendRedirect("manage-users.jsp");
    }

    private void deleteAdministrator(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int adminID = Integer.parseInt(request.getParameter("adminID"));
        administratorUtil.deleteAdministrator(adminID);
        response.sendRedirect("manage-users.jsp");
    }

}
