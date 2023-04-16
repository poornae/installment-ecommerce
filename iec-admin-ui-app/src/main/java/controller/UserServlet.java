/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbutil.UserUtil;
import model.User;
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
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserUtil userUtil;

    public void init() {
        userUtil = new UserUtil();
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
                    insertUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> userList = userUtil.selectAllUsers();
        request.setAttribute("userList", userList);
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
        int userID = Integer.parseInt(request.getParameter("userID"));
        User existingUser = userUtil.selectUser(userID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int contact_no = Integer.parseInt(request.getParameter("contact_no"));
        String role = request.getParameter("role");
        String permission = request.getParameter("permission");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        Timestamp last_login_at = Timestamp.valueOf(request.getParameter("last_login_at"));

        User newUser = new User(username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at);
        userUtil.insertUser(newUser);
        response.sendRedirect("manage-users.jsp");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int contact_no = Integer.parseInt(request.getParameter("contact_no"));
        String role = request.getParameter("role");
        String permission = request.getParameter("permission");
        Timestamp created_at = Timestamp.valueOf(request.getParameter("created_at"));
        int created_by = Integer.parseInt(request.getParameter("created_by"));
        Timestamp updated_at = Timestamp.valueOf(request.getParameter("updated_at"));
        int updated_by = Integer.parseInt(request.getParameter("updated_by"));
        Timestamp last_login_at = Timestamp.valueOf(request.getParameter("last_login_at"));

        User user = new User(userID, username, password, email, contact_no, role, permission, created_at, created_by, updated_at, updated_by, last_login_at);
        userUtil.updateUser(user);
        response.sendRedirect("manage-users.jsp");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        userUtil.deleteUser(userID);
        response.sendRedirect("manage-users.jsp");
    }
}
