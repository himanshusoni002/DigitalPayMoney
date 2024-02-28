<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>Register Page</title>
</head>

<body>
    <div class="container">

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

        <form action="verification" method="post" id="verificationForm">
            <label for="email">Enter OTP*</label>
            <input type="text" id="enterOtp" name="enterOtp" required>

            <br>
            <button type="submit" id="submitButton" >Submit</button>
        </form>
    </div>

</body>

</html>