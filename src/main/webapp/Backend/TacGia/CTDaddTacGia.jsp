<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Tác Giả</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="addTacGia" method="post">
        <h2>Thêm Tác Giả Mới</h2>

        <label for="ten">Tên:</label>
        <input type="text" name="ten" required>

        <label for="ngaySinh">Ngày Sinh:</label>
        <input type="date" name="ngaySinh" required>

        <label for="quocTich">Quốc Tịch:</label>
        <input type="text" name="quocTich" required>

        <label for="thongTinLienHe">Thông Tin Liên Hệ:</label>
        <input type="text" name="thongTinLienHe" required>
        <label for="hinhAnh">Hình Ảnh:</label>
    	<input type="text" name="hinhAnh" required>

        <button type="submit">Thêm Tác Giả</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/TacGia/CTDlistTacGia.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
