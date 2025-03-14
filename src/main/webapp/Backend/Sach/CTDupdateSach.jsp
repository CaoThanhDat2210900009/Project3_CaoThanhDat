<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Sách</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>

<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="updateSach" method="post">
        <h2>Cập Nhật Sách</h2>

        <input type="hidden" name="maSach" value="${sach.maSach}">

        <label for="tenSach">Tên Sách:</label>
        <input type="text" name="tenSach" value="${sach.tenSach}" required>

        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" value="${sach.isbn}" required>

        <label for="namXuatBan">Năm Xuất Bản:</label>
        <input type="number" name="namXuatBan" value="${sach.namXuatBan}" required>

        <label for="theLoai">Thể Loại:</label>
        <input type="text" name="theLoai" value="${sach.theLoai}" required>

        <label for="maTacGia">Mã Tác Giả:</label>
        <input type="number" name="maTacGia" value="${sach.maTacGia}" required>

        <label for="maNxb">Mã Nhà Xuất Bản:</label>
        <input type="number" name="maNxb" value="${sach.maNxb}" required>

        <label for="hinhAnh">Hình Ảnh:</label>
        <input type="text" name="hinhAnh" value="${sach.hinhAnh}" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/Sach/CTDlistSach.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
