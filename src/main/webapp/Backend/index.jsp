<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%
    // Kiểm tra xem admin đã đăng nhập hay chưa
    CTDAdmin Admin = (CTDAdmin) session.getAttribute("admin");
    if (admin == null) {
        // Nếu chưa đăng nhập, chuyển hướng về trang login
        response.sendRedirect(request.getContextPath() + "/Backend/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Chủ - Quản Lý Bản Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <section class="hero">
        <h1>Chào Mừng Bạn Đến Với Hệ Thống Quản Lý Bản Quyền</h1>
        <p>Hệ thống giúp quản lý bản quyền tác giả, hợp đồng xuất bản, nhà xuất bản, sách và tác giả một cách dễ dàng và chuyên nghiệp.</p>
        <a href="Backend/BanQuyen/CTDlistBanQuyen.jsp" class="btn-primary">Quản lý bản quyền</a>
    </section>

    <section class="features">
        <div class="feature-box">
            <h2>Quản Lý Bản Quyền</h2>
            <p>Theo dõi và kiểm soát bản quyền tác phẩm một cách hiệu quả.</p>
        </div>
        <div class="feature-box">
            <h2>Hợp Đồng Xuất Bản</h2>
            <p>Quản lý các hợp đồng giữa tác giả và nhà xuất bản.</p>
        </div>
        <div class="feature-box">
            <h2>Nhà Xuất Bản</h2>
            <p>Thông tin chi tiết về các nhà xuất bản đối tác.</p>
        </div>
        <div class="feature-box">
            <h2>Quản Lý Sách</h2>
            <p>Kiểm soát danh sách sách đã đăng ký bản quyền.</p>
        </div>
    </section>

<%@ include file="footer.jsp" %>
</body>
</html>
