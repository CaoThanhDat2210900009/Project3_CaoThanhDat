<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập Admin</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <section class="form-container">
        <form class="form" action="${pageContext.request.contextPath}/AdminLogin" method="post">
            <h2>Đăng Nhập</h2>
            <label for="taiKhoan">Tài Khoản:</label>
            <input type="text" name="taiKhoan" required>

            <label for="matKhau">Mật Khẩu:</label>
            <input type="password" name="matKhau" required>

            <button type="submit">Đăng Nhập</button>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
            <% } %>
        </form>
    </section>
</body>
</html>
