<%-- 
    Document   : manage-products
    Created on : Apr 7, 2023, 12:25:56 PM
    Author     : poornae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Bumble Bee &ndash; Products</title>

        <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/admin-view.css"/>
        <link rel="stylesheet" href="assets/css/all.css"/>
        <link rel="stylesheet" href="assets/css/buttons.css"/>

        <!--<script src="assets/js/utils/utils.js"></script>-->
        <!--  <script>if (!isAuth()) window.location = 'login.jsp';</script>-->
    </head>
    <body>
        <!--   <div class="create-popup-form">
            <form>
              <label for="product-name">Product Name</label>
              <input type="text" id="product-name" name="product-name">
        
              <label for="description">Description</label>
              <textarea id="description" name="description"></textarea>
        
              <label for="price">Price</label>
              <input type="number" id="price" name="price">
        
              <button type="submit">Create</button>
            </form>
            </div> -->

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
                <a href="manage-products.jsp" class="active">
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
                <h2 class="section-title" style="margin-bottom: 30px">Manage Products</h2>

                <div>
                    <a href="" class="btn btn-create-record">+ Create</a>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "Excel" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px; margin-left: 528px" download>Download as Excel</a>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "CSV" })" class="btn btn-download" style="padding: 4px 8px; font-size: 14px;" download>Download as CSV</a>
                </div>

                <div class="responsive-table">
                    <table id="product-table">
                        <thead class="table-header">
                            <tr>
                                <th>Product ID</th>
                                <th>Product Image</th>
                                <th>Product Name</th>
                                <th>Description</th>
                                <th>Original Price</th>
                                <th>Discount</th>
                                <th>Discounted Price</th>
                                <th>Inventory ID</th>
                                <th>Availability Status</th>
                                <th>Available Quantity</th>
                                <th>Category ID</th>
                                <th>Brand ID</th>
                                <th>Created At</th>
                                <th>Updated At</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody id="product-list" class="table-body">
                            <tr class="table-row">
                                <td>P0001</td>
                                <td><img src="assets/img/choco.jpg" alt="logo" class="logo" width="50" height="50" style="border-radius: 50%"></td>
                                <td>Chocolate</td>
                                <td>Sweet</td>
                                <td>400</td>
                                <td>100</td>
                                <td>300</td>
                                <td>400</td>
                                <td>100</td>
                                <td>300</td>
                                <td>100</td>
                                <td>300</td>
                                <td>100</td>
                                <td>300</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" ><i class="fa fa-pencil"></i></a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" ><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            <tr>
                                <td>P0002</td>
                                <td><img src="assets/img/shoes.jpg" alt="logo" class="logo" width="50" height="50" style="border-radius: 50%"></td>
                                <td>Shoes</td>
                                <td>Original</td>
                                <td>4000</td>
                                <td>100</td>
                                <td>3900</td>
                                <td>400</td>
                                <td>100</td>
                                <td>300</td>
                                <td>100</td>
                                <td>300</td>
                                <td>100</td>
                                <td>300</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" ><i class="fa fa-pencil"></i></a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" ><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>
    </body>

    <script src="~/js/universal/jquery.js"></script>
    <script src="~/Scripts/jquery-3.3.1.min.js"></script>
    <!--<script src="assets/js/script.js"></script>-->
    <!--<script src="assets/js/getUsers.js"></script>-->
</html>

