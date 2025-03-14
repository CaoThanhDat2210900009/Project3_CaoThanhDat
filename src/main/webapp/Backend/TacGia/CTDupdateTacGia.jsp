<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.TacGiaDAO" %>
<%@ page import="Model.CTDTacGia" %>

<%
    int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
    TacGiaDAO dao = new TacGiaDAO();
    CTDTacGia tacGia = dao.getTacGiaByMaTacGia(maTacGia);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Tác Giả</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="updateTacGia" method="post">
        <h2>Cập Nhật Tác Giả</h2>

        <input type="hidden" name="maTacGia" value="<%= tacGia.getMaTacGia() %>">

        <label for="ten">Tên:</label>
        <input type="text" name="ten" value="<%= tacGia.getTen() %>" required>

        <label for="ngaySinh">Ngày Sinh:</label>
        <input type="date" name="ngaySinh" value="<%= tacGia.getNgaySinh() %>" required>

        <label for="quocTich">Quốc Tịch:</label>
        <input type="text" name="quocTich" value="<%= tacGia.getQuocTich() %>" required>

        <label for="thongTinLienHe">Thông Tin Liên Hệ:</label>
        <input type="text" name="thongTinLienHe" value="<%= tacGia.getThongTinLienHe() %>" required>

        <label for="hinhAnh">Hình Ảnh:</label>
        <input type="text" name="hinhAnh" value="<%= tacGia.getHinhAnh() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/TacGia/CTDlistTacGia.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>

</body>
</html>
