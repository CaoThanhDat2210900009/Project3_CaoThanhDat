<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.ThanhToanDAO, DAO.SachDAO, DAO.TacGiaDAO, Model.CTDThanhToan, Model.CTDSach, Model.CTDTacGia, java.util.List" %>

<%
    int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));

    ThanhToanDAO thanhToanDAO = new ThanhToanDAO();
    CTDThanhToan thanhToan = thanhToanDAO.getThanhToanByMa(maThanhToan);

    SachDAO sachDAO = new SachDAO();
    TacGiaDAO tacGiaDAO = new TacGiaDAO();

    List<CTDSach> danhSachSach = sachDAO.getAllSach();
    List<CTDTacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Giao Dịch Thanh Toán</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<h2>Cập Nhật Giao Dịch Thanh Toán</h2>
<form action="updateThanhToan" method="post">

    <input type="hidden" name="maThanhToan" value="<%= thanhToan.getMaThanhToan() %>">

    <label>Mã Sách:</label>
    <select name="maSach" required>
        <% for (CTDSach s : danhSachSach) { %>
            <option value="<%= s.getMaSach() %>" <%= (s.getMaSach() == thanhToan.getMaSach()) ? "selected" : "" %> >
                <%= s.getTenSach() %> (ID: <%= s.getMaSach() %>)
            </option>
        <% } %>
    </select>

    <label>Mã Tác Giả:</label>
    <select name="maTacGia" required>
        <% for (CTDTacGia tg : danhSachTacGia) { %>
            <option value="<%= tg.getMaTacGia() %>" <%= (tg.getMaTacGia() == thanhToan.getMaTacGia()) ? "selected" : "" %> >
                <%= tg.getTen() %> (ID: <%= tg.getMaTacGia() %>)
            </option>
        <% } %>
    </select>

    <label>Số Tiền:</label>
    <input type="number" name="soTien" value="<%= thanhToan.getSoTien() %>" required min="0" step="0.01">

    <label>Ngày Thanh Toán:</label>
    <input type="date" name="ngayThanhToan" value="<%= thanhToan.getNgayThanhToan() %>" required>

    <button type="submit">Cập Nhật</button>
</form>

<a href="${pageContext.request.contextPath}/Backend/ThanhToan/CTDlistThanhToan.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
