<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.SachDAO" %>
<%@ page import="Model.CTDSach" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sách</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sach.css">
</head>
<body>

    <%@ include file="../WebNguoiDung/CTDheader.jsp" %>

<div class="list-container">
    <h2>Danh Sách Sách</h2>

    <div class="book-cards">
        <%
            SachDAO dao = new SachDAO();
            List<CTDSach> sachList = dao.getAllSach();
            if (sachList != null && !sachList.isEmpty()) {
                for (CTDSach sach : sachList) {
        %>
        <div class="book-card">
            <div class="book-image">
                <img src="${pageContext.request.contextPath}/images/<%= sach.getHinhAnh() %>" alt="Hình ảnh sách" width="150" height="150">
            </div>
            <div class="book-info">
                <h3><%= sach.getTenSach() %></h3>
                <p><strong>ISBN:</strong> <%= sach.getIsbn() %></p>
                <p><strong>Năm Xuất Bản:</strong> <%= sach.getNamXuatBan() %></p>
                <p><strong>Thể Loại:</strong> <%= sach.getTheLoai() %></p>
                <p><strong>Mã Tác Giả:</strong> <%= sach.getMaTacGia() %></p>
                <p><strong>Mã NXB:</strong> <%= sach.getMaNxb() %></p>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p>Không có sách nào để hiển thị.</p>
        <%
            }
        %>
    </div>
</div>

    <%@ include file="../WebNguoiDung/CTDfooter.jsp" %>

</body>
</html>
