<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.CTDAdmin" %>
<%
    CTDAdmin admin = (CTDAdmin) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header-footer.css">
</head>
<body>
<header class="main-header">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/Backend/index.jsp">Quản Lý Bản Quyền</a>
    </div>
    <nav class="nav-links">
        <a href="${pageContext.request.contextPath}/Backend/BanQuyen/CTDlistBanQuyen.jsp">Bản Quyền</a>
        <a href="${pageContext.request.contextPath}/Backend/HopDong/CTDlistHopDong.jsp">Hợp Đồng</a>
        <a href="${pageContext.request.contextPath}/Backend/NhaXuatBan/CTDlistNXB.jsp">Nhà Xuất Bản</a>
        <a href="${pageContext.request.contextPath}/Backend/Sach/CTDlistSach.jsp">Sách</a>
        <a href="${pageContext.request.contextPath}/Backend/TacGia/CTDlistTacGia.jsp">Tác Giả</a>

        <% if (admin != null) { %>
            <span>Chào, <%= admin.getTaiKhoan() %> | <a href="${pageContext.request.contextPath}/AdminLogout">Đăng Xuất</a></span>
        <% } else { %>
            <a href="${pageContext.request.contextPath}/Backend/login.jsp">Đăng Nhập</a>
        <% } %>
    </nav>
</header>
</body>
</html>
