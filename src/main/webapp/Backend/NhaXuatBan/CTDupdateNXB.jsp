<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NhaXuatBanDAO" %>
<%@ page import="Model.CTDNhaXuatBan" %>

<%
    int maNxb = Integer.parseInt(request.getParameter("maNxb"));
    NhaXuatBanDAO dao = new NhaXuatBanDAO();
    CTDNhaXuatBan nxb = dao.getNhaXuatBanByMa(maNxb);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Nhà Xuất Bản</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="updateNhaXuatBan" method="post">
        <h2>Cập Nhật Nhà Xuất Bản</h2>

        <input type="hidden" name="maNxb" value="<%= nxb.getMaNxb() %>">

        <label for="ten">Tên:</label>
        <input type="text" name="ten" value="<%= nxb.getTen() %>" required>

        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi" value="<%= nxb.getDiaChi() %>" required>

        <label for="thongTinLienHe">Thông Tin Liên Hệ:</label>
        <input type="text" name="thongTinLienHe" value="<%= nxb.getThongTinLienHe() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhaXuatBan/CTDlistNXB.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
