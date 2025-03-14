<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.nio.charset.StandardCharsets, java.util.List, DAO.TacGiaDAO, DAO.NhaXuatBanDAO, Model.CTDTacGia, Model.CTDNhaXuatBan" %>
<% 
    request.setCharacterEncoding("UTF-8"); 
    response.setCharacterEncoding("UTF-8"); 

    // Lấy danh sách thể loại (cố định)
    String[] theLoaiOptions = { "Văn học", "Khoa học", "Kinh tế", "Lịch sử", "Giáo dục", "Truyện thiếu nhi" };

    // Lấy danh sách tác giả từ database
    TacGiaDAO tacGiaDAO = new TacGiaDAO();
    List<CTDTacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();

    // Lấy danh sách nhà xuất bản từ database
    NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
    List<CTDNhaXuatBan> danhSachNXB = nhaXuatBanDAO.getAllNhaXuatBan();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sách</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<section class="form-container">
    <form class="form" action="addSach" method="post">
        <h2>Thêm Sách Mới</h2>

        <label for="tenSach">Tên Sách:</label>
        <input type="text" name="tenSach" required>

        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" required>

        <label for="namXuatBan">Năm Xuất Bản:</label>
        <input type="number" name="namXuatBan" required>

        <!-- Dropdown Thể Loại -->
        <label for="theLoai">Thể Loại:</label>
        <select name="theLoai" required>
            <% for (String theLoai : theLoaiOptions) { %>
                <option value="<%= theLoai %>"><%= theLoai %></option>
            <% } %>
        </select>

        <!-- Dropdown Mã Tác Giả -->
        <label for="maTacGia">Tác Giả:</label>
        <select name="maTacGia" required>
            <% for (CTDTacGia tacGia : danhSachTacGia) { %>
                <option value="<%= tacGia.getMaTacGia() %>">
                    <%= tacGia.getTen() %> (ID: <%= tacGia.getMaTacGia() %>)
                </option>
            <% } %>
        </select>

        <!-- Dropdown Mã Nhà Xuất Bản -->
        <label for="maNxb">Nhà Xuất Bản:</label>
        <select name="maNxb" required>
            <% for (CTDNhaXuatBan nxb : danhSachNXB) { %>
                <option value="<%= nxb.getMaNxb() %>">
                    <%= nxb.getTen() %> (ID: <%= nxb.getMaNxb() %>)
                </option>
            <% } %>
        </select>
		<label for="hinhAnh">Hình Ảnh:</label>
    	<input type="text" name="hinhAnh" required>
        <button type="submit">Thêm Sách</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/CTDlistSach.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
