<%-- 
    Document   : index
    Created on : Apr 5, 2023, 1:18:00 PM
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
  <title>Bumble Bee &mdash; Buy First & Pay Later</title>

  <link rel="shortcut icon" type="x-icon" href="assets/img/logo2.svg">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/index.css">
  
  <script src="assets/js/utils/utils.js"></script>
</head>
<body>
  <header>
    <div class="modal-toggle"></div>
    <nav class="navbar">
      <div class="navbar-logo">
        <a href="./" >
            <img src="assets/img/logo.png" alt="logo" class="logo">
        </a>
      </div>

      <button class="hamburger-menu"><a class="hamburger"></a></button>
      <ul class="navbar-menu">
        <li class="navbar-link">
          <a href="signup.jsp" class="btn-transparent" id="signup">SIGN UP</a>
        </li>
      </ul>
    </nav>
  </header>

  <main>
    <section class="hero">
        <h1 class="hero-title">Tired of waiting for payday?<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We got you covered!</h1>
      <p class="hero-paragraph">
        Shop now and pay later with Bumble Bee - the online loan provider for purchases up to 15,000 LKR. <br>Enjoy stress-free shopping with our easy repayment options and 3 interest-free installments. <br>Download our mobile app to learn more!
      </p>

      <div class="hero-callout">
        <a href="signup.jsp" class="btn btn-home" id="hero-text">
          <span>Get Started </span>
        </a>
      </div><br>
      <a href="#scrollHere" class="hero-down"><i class="fas fa-sort-down"></i></a>
    </section>

    <section class="how-to" id="scrollHere">
      <h2 class="section-title">How to use</h2>
      <p class="section-callout">
        Follow these 3 easy steps for a hassle-free shopping experience!
      </p>

      <div class="features">
        <div class="column feature-item">
          <span class="icon-circle">1</span>
          <p class="feature-text">
            Download the "Bumble Bee" app or visit our website to create an account. It only takes a few minutes!
          </p>
        </div>

        <div class="column feature-item">
          <span class="icon-circle">2</span>
          <p class="feature-text">
            Browse your favorite products and add them to your shopping cart. At checkout, select "Bumble Bee" as your payment method.
          </p>
        </div>

        <div class="column feature-item">
          <span class="icon-circle">3</span>
          <p class="feature-text">
            Choose your preferred payment plan - you can pay in full or split your purchase into 3 interest-free monthly installments.
          </p>
        </div>
      </div>
    </section>

    <section class="featured-reports sectioned">
      <h2 class="section-title">Key Features</h2>
      <div class="features">
        <div class="column feature-item">
          <p class="icon-circle"><i class="fas fa-bell"></i></p>
          <p class="feature-text">
            Users will be able to create an account quickly and easily. This includes providing basic personal information and financial details to qualify for loans.
          </p>
        </div>

        <div class="column feature-item">
          <p class="icon-circle"><i class="fas fa-sort-down"></i></p>
          <p class="feature-text">
            The app will offer flexible payment options, either to pay in full or split payments into 3 installments. Users can select a plan that works for their budget and repayment schedule.
          </p>
        </div>

        <div class="column feature-item">
          <p class="icon-circle"><i class="fas fa-smile"></i></p>
          <p class="feature-text">
            The app will offer customer support at all times to help users with any questions or issues they may have. 
          </p>
        </div>
      </div>
    </section>
  </main>

  <footer>
    <h4>Stay Connected</h4>
    <nav>
      <a href="#"><i class="fab fa-linkedin"></i></a>
      <a href="#"><i class="fab fa-twitter"></i></a>
      <a href="#"><i class="fab fa-facebook-square"></i></a>
    </nav>
    <p>&COPY; 2023 Bumble Bee with ❤ Poorna</p>
  </footer>
</body>
<script src="assets/js/script.js"></script>
</html>
