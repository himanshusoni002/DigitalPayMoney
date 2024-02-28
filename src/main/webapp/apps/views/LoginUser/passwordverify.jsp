<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Login Page</title>

    <style>
      .otp-section {
        display: none;
      }

      .styled-paragraph {
      background-color: white;
      color: black;
      border-radius: 60px;
      padding: 5px;
    }
    </style>
  </head>

  <body>
<!-- 
    <%
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      response.setHeader("Expires", "0");
    %> -->

    <!-- <c:if test="${not empty userId }">
      <%
          response.sendRedirect("/home");
      %>
    </c:if> -->

    <div class="container">

      <form action="passwordverify" method="post">
        <h2>Login</h2> <br>
        <label for="enteredEmail">Entered Email:</label>
        <div class="styled-paragraph">
          <p>${One}</p>
        </div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>

        
      </form>
      <form action="otpforLogin" method="post">
        <button>Login with OTP</button>
      </form>
    </div>
  </body>

  </html>