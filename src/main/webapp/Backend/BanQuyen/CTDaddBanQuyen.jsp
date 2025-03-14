<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, DAO.SachDAO, DAO.TacGiaDAO, Model.CTDSach, Model.CTDTacGia" %>

<% 
    SachDAO sachDAO = new SachDAO();
    TacGiaDAO tacGiaDAO = new TacGiaDAO();

    List<CTDSach> danhSachSach = sachDAO.getAllSach();
    List<CTDTacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Bản Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>



<h2>Thêm Bản Quyền Mới</h2>
<form action="addBanQuyen" method="post">

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

    <label>Ngày Bắt Đầu:</label>
    <input type="date" name="ngayBatDau" required>

    <label>Ngày Kết Thúc:</label>
    <input type="date" name="ngayKetThuc" required>

    <label>Loại Bản Quyền:</label>
    <select name="loaiBanQuyen">
        <option value="Độc quyền">Độc quyền</option>
        <option value="Không độc quyền">Không độc quyền</option>
    </select>

    <button type="submit">Thêm</button>
</form>

<a href="${pageContext.request.contextPath}/Backend/BanQuyen/CTDlistBanQuyen.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>

</body>
</html>
