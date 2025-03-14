<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.HopDongDAO" %>
<%@ page import="Model.CTDHopDong" %>

<%
    int maHopDong = Integer.parseInt(request.getParameter("maHopDong"));
    HopDongDAO dao = new HopDongDAO();
    CTDHopDong hd = dao.getHopDongByMa(maHopDong);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Hợp Đồng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="updateHopDong" method="post">
        <h2>Cập Nhật Hợp Đồng</h2>

        <input type="hidden" name="maHopDong" value="<%= hd.getMaHopDong() %>">

        <label for="maTacGia">Mã Tác Giả:</label>
        <input type="number" name="maTacGia" value="<%= hd.getMaTacGia() %>" required>

        <label for="maNxb">Mã Nhà Xuất Bản:</label>
        <input type="number" name="maNxb" value="<%= hd.getMaNxb() %>" required>

        <label for="ngayKy">Ngày Ký:</label>
        <input type="date" name="ngayKy" value="<%= hd.getNgayKy() %>" required>

        <label for="tyLeHoanTac">Tỷ Lệ Hoàn Tác (%):</label>
        <input type="number" step="0.01" name="tyLeHoanTac" value="<%= hd.getTyLeHoanTac() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/HopDong/CTDlistHopDong.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
