<%-- 
    Document   : manage-customers
    Created on : Apr 7, 2023, 12:21:11 PM
    Author     : poornae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Bumble Bee &ndash; Customers</title>

        <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/admin-view.css"/>
        <link rel="stylesheet" href="assets/css/all.css"/>

        <!--<script src="assets/js/utils/utils.js"></script>-->
        <!--  <script>if (!isAuth()) window.location = 'login.jsp';</script>-->
    </head>
    <body>
        <aside>
            <div class="modal-toggle"></div>
            <button class="hamburger-menu"><a class="hamburger"></a></button>
            <div class="asidebar-logo">
                <a href="dashboard.jsp">
                    <img src="assets/img/logo.png" alt="logo" class="logo">
                </a>
            </div><br><br><br><br><br>
            <nav class="navbar-menu">
                <a href="dashboard.jsp">
                    <i class="fa-solid fa-chart-pie"></i>Dashboard
                </a>
                <a href="manage-customers.jsp" class="active">
                    <i class="fa-solid fa-users"></i>Manage Customers
                </a>
                <a href="manage-orders.jsp">
                    <i class="fa-solid fa-cart-shopping"></i>Manage Orders
                </a>
                <a href="manage-transactions.jsp">
                    <i class="fa-solid fa-money-check"></i>Manage Transactions
                </a>
                <a href="manage-loans.jsp">
                    <i class="fa-solid fa-sack-dollar"></i>Manage Loans
                </a>
                <a href="manage-products.jsp">
                    <i class="fa-solid fa-basket-shopping"></i>Manage Products
                </a>
                <a href="manage-categories.jsp">
                    <i class="fa-solid fa-store"></i>Manage Product Categories
                </a>
                <a href="manage-brands.jsp">
                    <i class="fa-solid fa-copyright"></i>Manage Product Brands
                </a>
                <a href="manage-inventory.jsp">
                    <i class="fa-solid fa-warehouse"></i>Manage Inventory
                </a>
                <a href="manage-users.jsp">
                    <i class="fa-solid fa-users-gear"></i>Manage System Users
                </a>
                <a href="system-settings.jsp">
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
                <a href="@Url.Action("DownloadData", "Message", new { type = "Excel" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px; margin-left: 420px" download>Download as Excel</a>
                <a href="@Url.Action("DownloadData", "Message", new { type = "CSV" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px;" download>Download as CSV</a>
                <div class="responsive-table">
                    <table id="customer-table">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Customer ID</th>
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
                        <tbody id="customer-list">
                        <tr>
                            <th><img src="assets/img/user.jpg" alt="logo" class="logo" style="width: 50px; height: 50px"></th>
                            <td>CO0001</td>
                            <td>Tom Fellington</td>
                            <td>tom@outlook.com</td>
                            <td>1995-11-01</td>
                            <td>199523345V</td>
                            <td>0778999890</td>
                            <td>Colombo</td>
                            <td>2023-03-01</td>
                            <td>2023-02-01</td>
                            <td>2023-02-01</td>
                            <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a></td>
                        </tr>
                        <tr>
                            <th><img src="assets/img/user.jpg" alt="logo" class="logo" style="width: 50px; height: 50px; "></th>
                            <td>C00002</td>
                            <td>Peter Parker</td>
                            <td>peter@outlook.com</td>
                            <td>1980-11-01</td>
                            <td>802334555V</td>
                            <td>0770567890</td>
                            <td>Colombo</td>
                            <td>2023-05-01</td>
                            <td>2023-02-01</td>
                            <td>2023-03-01</td>
                            <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>
    </body>
    <!--<script src="assets/js/script.js"></script>-->
    <!--<script src="assets/js/getUsers.js"></script>-->
</html>
