<%-- 
    Document   : manage-loans
    Created on : Apr 7, 2023, 12:24:42 PM
    Author     : poornae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Bumble Bee &ndash; Loans</title>

        <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/loans.css"/>
        <link rel="stylesheet" href="assets/css/all.css"/>

        <!--<script src="assets/js/utils/utils.js"></script>-->
        <!--<script>if (!isAuth()) window.location = 'signin.html';</script>-->
    </head>
    <body>
        <div id="modal-toggle" class="modal-toggle closed"></div>
        <button class="hamburger-menu"><a class="hamburger"></a></button>
        <aside>
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
                <a href="manage-loans.jsp" class="active">
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
                <h2 class="section-title">Manage Loans</h2>
                
                <div class="toggle-reports" style="margin-bottom: 20px">
                    <button class="btn btn-toggled" onclick="toggleTab('loans-all', this)">
                        All
                    </button>
                    <button class="btn" onclick="toggleTab('loans-repaid', this)">
                        Repaid
                    </button>
                    <button class="btn" onclick="toggleTab('loans-unpaid', this)">
                        Not Repaid
                    </button>
                </div>
                
                <div>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "Excel" })" class="btn btn-download" style="height: 20px; padding: 4px 8px; font-size: 14px; margin-left:601px" download>Download as Excel</a>
                    <a href="@Url.Action("DownloadData", "Message", new { type = "CSV" })" class="btn btn-download" style="height: 20px; padding: 4px 8px; font-size: 14px;" download>Download as CSV</a>
                </div>

                <div id="loans-all" class="responsive-table">
                    <table>
                        <thead class="table-header">
                            <tr>
                                <th>Loan ID</th>
                                <th>Loan Amount</th>
                                <th>Loan Term</th>
                                <th>Installment Amount</th>
                                <th>Remaining Installment</th>
                                <th>Loan Start Date</th>
                                <th>Loan End Date</th>
                                <th>Loan Status</th>
                                <th>Customer ID</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody id="records-all" class="table-body"><tbody id="records-unpaid" class="table-body">
                            <tr class="table-row">
                                <td>L0001</td>
                                <td>15000</td>
                                <td>3</td>
                                <td>5000</td>
                                <td>2</td>
                                <td>2023-02-01</td>
                                <td>2023-05-01</td>
                                <td>Pending</td>
                                <td>TR0025</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                    <a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            <tr>
                                <td>L0002</td>
                                <td>15000</td>
                                <td>3</td>
                                <td>5000</td>
                                <td>2</td>
                                <td>2023-03-01</td>
                                <td>2023-06-01</td>
                                <td>Complete</td>
                                <td>TR0025</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                    <a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                        </tbody></tbody>
                    </table>
                </div>

                <div id="loans-repaid" class="responsive-table">
                    <table>
                        <thead class="table-header">
                            <tr>
                                <th>Loan ID</th>
                                <th>Loan Amount</th>
                                <th>Loan Term</th>
                                <th>Installment Amount</th>
                                <th>Remaining Installment</th>
                                <th>Loan Start Date</th>
                                <th>Loan End Date</th>
                                <th>Loan Status</th>
                                <th>Customer ID</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody id="records-repaid" class="table-body"></tbody>
                    </table>
                </div>

                <div id="loans-unpaid" class="responsive-table">
                    <table>
                        <thead class="table-header">
                            <tr>
                                <th>Loan ID</th>
                                <th>Loan Amount</th>
                                <th>Loan Term</th>
                                <th>Installment Amount</th>
                                <th>Remaining Installment</th>
                                <th>Loan Start Date</th>
                                <th>Loan End Date</th>
                                <th>Loan Status</th>
                                <th>Customer ID</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody id="records-unpaid" class="table-body">
                            <tr>
                                <td>L0001</td>
                                <td>15000</td>
                                <td>3</td>
                                <td>5000</td>
                                <td>2</td>
                                <td>2023-02-01</td>
                                <td>2023-05-01</td>
                                <td>Pending</td>
                                <td>TR0025</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                    <a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            <tr>
                                <td>L0002</td>
                                <td>15000</td>
                                <td>3</td>
                                <td>5000</td>
                                <td>2</td>
                                <td>2023-03-01</td>
                                <td>2023-06-01</td>
                                <td>Complete</td>
                                <td>TR0025</td>
                                <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div id="modal" class="modal report-modal closed">
                    <div class="modal-header">
                        <p class="modal-title">Loan Details</p>
                        <span id="modal-close">x</span>
                    </div>
                    <div class="modal-body">
                        <table>
                            <thead class="table-header">
                                <tr>
                                    <th>Loan ID</th>
                                    <th>Loan Amount</th>
                                    <th>Loan Term</th>
                                    <th>Installment Amount</th>
                                    <th>Remaining Installment</th>
                                    <th>Loan Start Date</th>
                                    <th>Loan End Date</th>
                                    <th>Loan Status</th>
                                    <th>Customer ID</th>
                                </tr>
                            </thead>
                            <tbody class="table-body">
                                <tr class="table-row">
                                    <td>L0001</td>
                                    <td>15000</td>
                                    <td>3</td>
                                    <td>5000</td>
                                    <td>2</td>
                                    <td>2023-02-01</td>
                                    <td>2023-05-01</td>
                                    <td>Pending</td>
                                    <td>TR0025</td>
                                    <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                        <a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>L0002</td>
                                    <td>15000</td>
                                    <td>3</td>
                                    <td>5000</td>
                                    <td>2</td>
                                    <td>2023-03-01</td>
                                    <td>2023-06-01</td>
                                    <td>Complete</td>
                                    <td>TR0025</td>
                                    <td><a href="javascript:void(0)" data-toggle="tooltip" title="Edit" style="color:green;" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" data-toggle="tooltip" title="Delete"  style="color:red;" class="btn btn-effect-ripple btn-xs btn-error"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <!--          <button class="modal-btn btn-repay">
                                    <a href="admin-repayment.html">Post Repayment</a>
                                  </button>-->
                    </div>
                </div>
            </section>
        </main>
    </body>
    <!--<script src="assets/js/script.js"></script>-->
    <!--<script src="assets/js/getLoans.js"></script>-->
</html>

<!--
  <tr>
    <td>Hashirama</td>
    <td>tydl0p3xj3</td>
    <td>May 23 2019</td>
    <td>N12,000</td>
    <td>8 months</td>
    <td>Not Repaid</td>
    <td>
      <div class="wrapper">
        <button id="" class="btn-action btn-info open-btn">
          <i class="fas fa-eye"></i> <span>view</span>
        </button>
      </div>
    </td>
  </tr>

  <button class="btn" onclick="toggleTab('loans-pending', this)">
          Pending
        </button>

  <div id="loans-pending" class="responsive-table">
        <table>
          <thead>
            <tr>
              <th>User</th>
              <th>Date Created</th>
              <th>Amount</th>
              <th>Status</th>
              <th>Repaid</th>
              <th></th>
            </tr>
          </thead>

          <tbody id="records-pending"></tbody>
        </table>
      </div>
-->
