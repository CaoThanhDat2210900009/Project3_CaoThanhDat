<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Hợp Đồng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="addHopDong" method="post">
        <h2>Thêm Hợp Đồng Mới</h2>

        <label for="maTacGia">Mã Tác Giả:</label>
        <input type="number" name="maTacGia" required>

        <label for="maNxb">Mã Nhà Xuất Bản:</label>
        <input type="number" name="maNxb" required>

        <label for="ngayKy">Ngày Ký:</label>
        <input type="date" name="ngayKy" required>

        <label for="tyLeHoanTac">Tỷ Lệ Hoàn Tác (%):</label>
        <input type="number" step="0.01" name="tyLeHoanTac" required>

        <button type="submit">Thêm Hợp Đồng</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/HopDong/CTDlistHopDong.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
