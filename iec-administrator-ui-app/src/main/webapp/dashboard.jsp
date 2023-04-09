<%-- 
    Document   : dashboard
    Created on : Apr 7, 2023, 12:16:27 PM
    Author     : poornae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Bumble Bee &ndash; Dashboard</title>

        <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
        <script src="assets/js/main.js"></script>
        <link rel="stylesheet" href="assets/css/admin-view.css"/>
        <link rel="stylesheet" href="assets/css/dashboard.css"/>

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
                <a href="dashboard.jsp" class="active">
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
                <h2 class="section-title">Dashboard</h2>

                <!-- ======================= Cards ================== -->
                <div class="cardBox">
                    <div class="card">
                        <div>
                            <div class="numbers">1,504</div>
                            <div class="cardName">Daily Views</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="eye-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">80</div>
                            <div class="cardName">Sales</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="cart-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">284</div>
                            <div class="cardName">Comments</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="chatbubbles-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">Rs7,842</div>
                            <div class="cardName">Earning</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="cash-outline"></ion-icon>
                        </div>
                    </div>
                </div>

                <!-- ================ Order Details List ================= -->
                <div class="details">
                    <div class="recentOrders">
                        <div class="cardHeader">
                            <h3 style="color: var(--blue)">Recent Orders</h3>
                            <a href="manage-orders.jsp" class="btn">View All</a>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <td>Name</td>
                                    <td>Price</td>
                                    <td>Payment</td>
                                    <td>Status</td>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Star Refrigerator</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status delivered">Delivered</span></td>
                                </tr>

                                <tr>
                                    <td>Dell Laptop</td>
                                    <td>$110</td>
                                    <td>Due</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>

                                <tr>
                                    <td>Apple Watch</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status return">Return</span></td>
                                </tr>

                                <tr>
                                    <td>Addidas Shoes</td>
                                    <td>$620</td>
                                    <td>Due</td>
                                    <td><span class="status inProgress">In Progress</span></td>
                                </tr>

                                <tr>
                                    <td>Star Refrigerator</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status delivered">Delivered</span></td>
                                </tr>

                                <tr>
                                    <td>Dell Laptop</td>
                                    <td>$110</td>
                                    <td>Due</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>

                                <tr>
                                    <td>Apple Watch</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status return">Return</span></td>
                                </tr>

                                <tr>
                                    <td>Addidas Shoes</td>
                                    <td>$620</td>
                                    <td>Due</td>
                                    <td><span class="status inProgress">In Progress</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <!-- ================= New Customers ================ -->
                    <div class="recentCustomers">
                        <div class="cardHeader">
                            <h3 style="color: var(--blue)">Recent Customers</h2>
                                <a href="manage-customers.jsp" class="btn" style="width:74px">View All</a>
                        </div>

                        <table>
                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>David <br> <span>Italy</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>Amit <br> <span>India</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>David <br> <span>Italy</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>Amit <br> <span>India</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>David <br> <span>Italy</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>Amit <br> <span>India</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer01.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>David <br> <span>Italy</span></h4>
                                </td>
                            </tr>

                            <tr>
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                                </td>
                                <td>
                                    <h4>Amit <br> <span>India</span></h4>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>






                <!--      <div class="responsive-table">
                        <table id="user-table">
                          <thead>
                            <tr>
                              <th>First Name</th>
                              <th>Last Name</th>
                              <th>Home Address</th>
                              <th>Status</th>
                              <th></th>
                            </tr>
                          </thead>
                
                          <tbody id="user-list"></tbody>
                        </table>
                      </div>-->
            </section>
        </main>
    </body>
    <!--<script src="assets/js/script.js"></script>-->
    <!--<script src="assets/js/getUsers.js"></script>-->
</html>
