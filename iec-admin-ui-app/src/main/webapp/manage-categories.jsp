<%-- 
    Document   : manage-categories
    Created on : Apr 7, 2023, 12:22:48 PM
    Author     : poornae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Bumble Bee &ndash; Categories</title>

        <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/admin-view.css"/>
        <link rel="stylesheet" href="assets/css/all.css"/>
        <link rel="stylesheet" href="assets/css/buttons.css"/>

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
                <a href="manage-customers.jsp">
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
                <a href="manage-categories.jsp" class="active">
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
                <h2 class="section-title" style="margin-bottom: 30px">Manage Product Categories</h2>

                <div>
                    <a href="" class="btn btn-create-record">+ Create</a>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "Excel" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px; margin-left: 530px" download>Download as Excel</a>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "CSV" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px;" download>Download as CSV</a>
                </div>

                <div class="responsive-table">
                    <table id="category-table">
                        <thead class="table-header">
                            <tr>
                                <th>Category ID</th>
                                <th>Category Name</th>
                                <th>Created By</th>
                                <th>Created At</th>
                                <th>Updated By</th>
                                <th>Updated At</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody id="category-list" class="table-body">
                            <tr class="table-row">
                                <td>PO0001</td>
                                <td>Clothing</td>
                                <td>U0001</td>
                                <td>2023-04-01</td>
                                <td>U0003</td>
                                <td>2023-04-01</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a></td>
                            </tr>
                            <tr>
                                <td>P00001</td>
                                <td>Nike</td>
                                <td>U0001</td>
                                <td>2023-04-01</td>
                                <td>U0003</td>
                                <td>2023-04-01</td>
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
