<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhà Xuất Bản</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="addNhaXuatBan" method="post">
        <h2>Thêm Nhà Xuất Bản Mới</h2>

        <label for="ten">Tên:</label>
        <input type="text" name="ten" required>

        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi" required>

        <label for="thongTinLienHe">Thông Tin Liên Hệ:</label>
        <input type="text" name="thongTinLienHe" required>

        <button type="submit">Thêm Nhà Xuất Bản</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhaXuatBan/CTDlistNXB.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
