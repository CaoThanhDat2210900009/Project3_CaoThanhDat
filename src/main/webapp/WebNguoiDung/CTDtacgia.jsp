<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.TacGiaDAO" %>
<%@ page import="Model.CTDTacGia" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Tác Giả</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tacgia.css">
</head>
<body>

    <%@ include file="../WebNguoiDung/CTDheader.jsp" %>
<div class="list-container">
    <h2>Danh Sách Tác Giả</h2>

    <div class="author-cards">
        <%
            TacGiaDAO dao = new TacGiaDAO();
            List<CTDTacGia> tacGiaList = dao.getAllTacGia();
            if (tacGiaList != null && !tacGiaList.isEmpty()) {
                for (CTDTacGia tacGia : tacGiaList) {
        %>
        <div class="author-card">
            <div class="author-image">
                <img src="${pageContext.request.contextPath}/images/<%= tacGia.getHinhAnh() %>" alt="Hình ảnh tác giả" width="150" height="150">
            </div>
            <div class="author-info">
                <h3><%= tacGia.getTen() %></h3>
                <p><strong>Ngày Sinh:</strong> <%= tacGia.getNgaySinh() %></p>
                <p><strong>Quốc Tịch:</strong> <%= tacGia.getQuocTich() %></p>
                <p><strong>Thông Tin Liên Hệ:</strong> <%= tacGia.getThongTinLienHe() %></p>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p>Không có tác giả nào để hiển thị.</p>
        <%
            }
        %>
    </div>
</div>

    <%@ include file="../WebNguoiDung/CTDfooter.jsp" %>
</body>
</html>
