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
  <script src="https://kit.fontawesome.com/809f681f36.js" crossorigin="anonymous"></script>
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
          <a href="register.jsp" class="btn-transparent" id="signup">REGISTER</a>
        </li>
      </ul>
    </nav>
  </header>

  <main>
    <section class="hero">
        <h1 class="hero-title">Tired of waiting for payday?<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We got you covered!</h1>
      <p class="hero-paragraph">
        Shop now and pay later with Bumble Bee - the online loan provider for purchases up to 15,000 LKR. <br>Enjoy stress-free shopping with our 3 interest-free payment plan option. <br>Download our mobile app to learn more!
      </p>

      <div class="hero-callout">
        <a href="register.jsp" class="btn btn-home" id="hero-text">
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
            Download the "Bumble Bee" app or visit our website to create an account.
          </p>
        </div>

        <div class="column feature-item">
          <span class="icon-circle">2</span>
          <p class="feature-text">
            Shop on our mobile app, add to cart the items you wish to purchase, and pay with Bumble Bee at checkout.
          </p>
        </div>

        <div class="column feature-item">
          <span class="icon-circle">3</span>
          <p class="feature-text">
            Key in the Bumble Bee credentials followed by your card details and complete the purchase.
          </p>
        </div>
      </div>
    </section>

    <section class="featured-reports sectioned">
      <h2 class="section-title">Key Features</h2>
      <div class="features">
        <div class="column feature-item">
          <p class="icon-circle"><i class="fa-solid fa-users"></i></p>
          <p class="feature-text">
            You will be able to create an account quickly and easily with their basic personal information and financial details to qualify for the loan.
          </p>
        </div>

        <div class="column feature-item">
          <p class="icon-circle"><i class="fa-solid fa-hand-holding-dollar"></i></p>
          <p class="feature-text">
            The app will offer flexible payment options, either to pay in full or split amount into 3 installments according to your budget.
          </p>
        </div>

        <div class="column feature-item">
          <p class="icon-circle"><i class="fa-solid fa-headset"></i></p>
          <p class="feature-text">
            Our app provides 24/7 customer support to assist you with any queries or concerns you may have while using the app. 
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
