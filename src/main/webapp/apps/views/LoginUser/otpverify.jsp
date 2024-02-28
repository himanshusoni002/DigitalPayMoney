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
  </style>
</head>

<body>

  <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
  %>

  <c:if test="${not empty userId }">
    <%
        response.sendRedirect("/home");
    %>
  </c:if>

  <div class="container">

    <form action="otpverify" method="post">
        <h2>Login with OTP</h2>
        <button type="button" onclick="goBackToStep2()">Back</button>
        <label for="otp">OTP:</label>
        <input type="text" id="otp" name="otp" required>

        <button type="submit">Login</button>
    </form>
  </div>

  <script>
   
    function goBackToStep2() {
      document.getElementById('otpForm').style.display = 'none';
      document.getElementById('passwordForm').style.display = 'block';
    }
  </script>

</body>

</html>