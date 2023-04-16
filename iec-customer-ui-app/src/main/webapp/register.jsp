<%-- 
    Document   : register
    Created on : Apr 5, 2023, 1:24:38 PM
    Author     : poornae
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Bumble Bee &mdash; Sign Up</title>

        <link rel="shortcut icon" type="x-icon" href="assets/img/logo2.svg">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/register.css">

        <!--Sweet Alert-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
    </head>

    <style>input[type="date"]::-webkit-calendar-picker-indicator {
            filter: invert(1);
        }</style>
    <body>
        <header>
            <a href="./">
                <img src="assets/img/logo.png" alt="logo" class="logo">
            </a>
        </header>

        <main>
            <h2 class="section-title">Create your Account</h2>
            <section class="container">
                <form class="form-container" method="POST" id="form">
                    <label for="firstName">First Name <span>*</span></label>
                    <input type="text" name="firstName" class="form-element" id="firstName" placeholder="Your First Name" minlength="3" required>

                    <label for="lastName">Last Name <span>*</span></label>
                    <input type="text" name="lastName" class="form-element" id="lastName" placeholder="Your Last Name" minlength="3" required>

                    <label for="address">Home Address <span>*</span></label>
                    <input type="text" name="address" class="form-element" id="address" placeholder="Your Home Address" required>

                    <label for="email">Email Address <span>*</span></label>
                    <input type="email" name="email" class="form-element" id="email" placeholder="Your Email Address" required>

                    <label for="dob">Date of Birth <span>*</span></label>
                    <input type="date" name="dob" class="form-element" id="dob" placeholder="Date of Birth" required>

                    <label for="contact_no">Contact No <span>*</span></label>
                    <input type="text" name="contact_no" class="form-element" id="contact_no" minlength="10" maxlength="10" placeholder="Contact No" required>

                    <label for="nic">NIC No<span>*</span></label>
                    <input type="text" name="nic" class="form-element" id="nic" minlength="10" maxlength="12" placeholder="NIC No" required>
                    
                    <label for="userName">Username <span>*</span></label>
                    <input type="text" name="userName" class="form-element" id="userName" placeholder="Your Username" minlength="3" required>

                    <label for="password">Password <span>*</span></label>
                    <input type="password" name="password" class="form-element" id="password" placeholder="Your Password" minlength="6" required>

                    <label for="confirmpassword">Confirm Password <span>*</span></label>
                    <input type="confirmpassword" name="confirmpassword" class="form-element" id="confirmpassword" placeholder="Confirm Password" minlength="6" required>

                    <button type="submit" class="btn btn-primary" id="btn-submit">Sign Up for Free</button>
                </form>

                <p>Already a User? <span><a href="index.jsp">Go Back</a></span></p>
            </section>

            <div class="spinner-dots">
                <div class="spinner-dot"></div>
                <div class="spinner-dot"></div>
            </div>
        </main>
    </body>
    <!-- Link to authenticateUser.js file -->
    <script src="assets/js/authenticateUser.js"></script>
    
    <!-- Link to submitForm.js file -->
    <script src="assets/js/submitForm.js"></script>
</html>
