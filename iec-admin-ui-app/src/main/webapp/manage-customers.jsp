<%-- 
    Document   : manage-customers
    Created on : Apr 5, 2023, 9:55:16 PM
    Author     : poornae
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="tables.Customer"%>
<%@page import="tables.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>Bumble Bee &ndash; Customers</title>

  <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="assets/css/admin-view.css"/>
  
  <!--<script src="assets/js/utils/utils.js"></script>-->
<!--  <script>if (!isAuth()) window.location = 'login.jsp';</script>-->
</head>
<body>
  <aside>
    <div class="modal-toggle"></div>
    <button class="hamburger-menu"><a class="hamburger"></a></button>
    <div class="asidebar-logo">
      <a href="./">
        <img src="assets/img/logo.png" alt="logo" class="logo">
      </a>
    </div><br><br><br><br><br>
    <nav class="navbar-menu">
      <a href="dashboard.html">
        <i class="fa-solid fa-chart-pie"></i>Dashboard
      </a>
      <a href="manage-customers.html" class="active">
        <i class="fa-solid fa-users"></i>Manage Customers
      </a>
      <a href="manage-orders.html">
        <i class="fa-solid fa-cart-shopping"></i>Manage Orders
      </a>
      <a href="manage-transactions.html">
        <i class="fa-solid fa-money-check"></i>Manage Transactions
      </a>
      <a href="manage-loans.html">
        <i class="fa-solid fa-sack-dollar"></i>Manage Loans
      </a>
      <a href="manage-products.html">
        <i class="fa-solid fa-basket-shopping"></i>Manage Products
      </a>
      <a href="manage-categories.html">
        <i class="fa-solid fa-store"></i>Manage Product Categories
      </a>
      <a href="manage-brands.html">
        <i class="fa-solid fa-copyright"></i>Manage Product Brands
      </a>
      <a href="manage-inventory.html">
        <i class="fa-solid fa-warehouse"></i>Manage Inventory
      </a>
      <a href="manage-users.html">
       <i class="fa-solid fa-users-gear"></i>Manage System Users
      </a>
      <a href="system-settings.html">
        <i class="fa-solid fa-gears"></i>System Settings
      </a>
    </nav>
  </aside>

  <header>
    <nav>
      <a href="login.jsp" id="signout"><i class="fas fa-sign-out-alt"></i></a>
    </nav>
  </header>

  <main>
    <section class="container">
      <h2 class="section-title">Manage Customers</h2>
      <div class="responsive-table">
        <table id="customer-table">
          <thead>
            <tr>
              <th>Customer ID</th>
              <th>Image</th>
              <th>Full Name</th>
              <th>Email</th>
              <th>DOB</th>
              <th>NIC No</th>
              <th>Contact No</th>
              <th>Address</th>
              <th>Last Login At</th>
              <th>Created At</th>
              <th>Updated At</th>
              <th></th>
            </tr>
          </thead>
          
 <tbody>
  <% 
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Establish a connection to the database
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceDB", "root", "password");

      // Execute SQL queries
      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM customer";
      ResultSet rs = stmt.executeQuery(sql);

      // Process the result set
      while (rs.next()) {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getString("customer_id"));
        customer.setProfileImage(rs.getString("image"));
        customer.setFullName(rs.getString("full_name"));
        customer.setEmail(rs.getString("email"));
        customer.setDob(rs.getString("dob"));
        customer.setNicNo(rs.getString("nic_no"));
        customer.setContactNo(rs.getString("contact_no"));
        customer.setAddress(rs.getString("address"));
  <tr>
    <td><%= customer.getCustomerId() %></td>
    <td><img src="<%= customer.getImage() %>" alt="customer image" width="50" height="50"></td>
    <td><%= customer.getFullName() %></td>
    <td><%= customer.getEmail() %></td>
    <td><%= customer.getDob() %></td>
    <td><%= customer.getNicNo() %></td>
    <td><%= customer.getContactNo() %></td>
    <td><%= customer.getAddress() %></td>
    <td><%= customer.getLastLoginAt() %></td>
    <td><%= customer.getCreatedAt() %></td>
    <td><%= customer.getUpdatedAt() %></td>
    <td><a href="#">Edit</a></td>
  </tr>
  <% 
      }

      // Close the connection
      conn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  %>
</tbody>
            
            %>
          <tbody id="customer-list"></tbody>
        </table>
      </div>
    </section>
  </main>
</body>
<!--<script src="assets/js/script.js"></script>-->
<!--<script src="assets/js/getUsers.js"></script>-->
</html>
