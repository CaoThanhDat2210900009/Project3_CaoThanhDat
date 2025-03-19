<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, DAO.ThanhToanDAO, DAO.SachDAO, DAO.TacGiaDAO, Model.CTDThanhToan, Model.CTDSach, Model.CTDTacGia" %>

<%
    ThanhToanDAO thanhToanDAO = new ThanhToanDAO();
    SachDAO sachDAO = new SachDAO();
    TacGiaDAO tacGiaDAO = new TacGiaDAO();

    List<CTDSach> danhSachSach = sachDAO.getAllSach();
    List<CTDTacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Giao Dịch Thanh Toán</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<h2>Thêm Giao Dịch Thanh Toán Mới</h2>
<form action="addThanhToan" method="post">

    <label>Mã Sách:</label>
    <select name="maSach" required>
        <% for (CTDSach s : danhSachSach) { %>
            <option value="<%= s.getMaSach() %>"><%= s.getTenSach() %> (ID: <%= s.getMaSach() %>)</option>
        <% } %>
    </select>

    <label>Mã Tác Giả:</label>
    <select name="maTacGia" required>
        <% for (CTDTacGia tg : danhSachTacGia) { %>
            <option value="<%= tg.getMaTacGia() %>"><%= tg.getTen() %> (ID: <%= tg.getMaTacGia() %>)</option>
        <% } %>
    </select>

    <label>Số Tiền:</label>
    <input type="number" name="soTien" required min="0" step="0.01">

    <label>Ngày Thanh Toán:</label>
    <input type="date" name="ngayThanhToan" required>

    <button type="submit">Thêm</button>
</form>

<a href="${pageContext.request.contextPath}/Backend/ThanhToan/CTDlistThanhToan.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>

</body>
</html>
