<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.SachDAO" %>
<%@ page import="Model.CTDSach" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sách</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<%@ include file="../header.jsp" %>

<div class="list-container">
    <h2>Danh Sách Sách</h2>
    <a href="CTDaddSach.jsp" class="add-btn">Thêm Sách</a>

    <div class="table-wrapper">
        <table>
            <thead>
    <tr>
        <th>Mã Sách</th>
        <th>Tên Sách</th>
        <th>ISBN</th>
        <th>Năm Xuất Bản</th>
        <th>Thể Loại</th>
        <th>Mã Tác Giả</th>
        <th>Mã NXB</th>
        <th>Hình Ảnh</th> <!-- Thêm cột hiển thị hình ảnh -->
        <th>Hành Động</th>
    </tr>
</thead>
<tbody>
    <%
        SachDAO dao = new SachDAO();
        List<CTDSach> sachList = dao.getAllSach();
        if (sachList != null && !sachList.isEmpty()) {
            for (CTDSach sach : sachList) {
    %>
    <tr>
        <td><%= sach.getMaSach() %></td>
        <td><%= sach.getTenSach() %></td>
        <td><%= sach.getIsbn() %></td>
        <td><%= sach.getNamXuatBan() %></td>
        <td><%= sach.getTheLoai() %></td>
        <td><%= sach.getMaTacGia() %></td>
        <td><%= sach.getMaNxb() %></td>
        <td>
            <img src="${pageContext.request.contextPath}/images/<%= sach.getHinhAnh() %>" alt="Hình ảnh sách" width="100" height="100">
        </td>
        <td>
            <a href="updateSach?maSach=<%= sach.getMaSach() %>" class="action-btn edit-btn">Sửa</a>
            <a href="deleteSach?maSach=<%= sach.getMaSach() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="9" style="text-align:center;">Không có sách nào để hiển thị.</td>
    </tr>
    <%
        }
    %>
</tbody>

        </table>
    </div>
</div>

<%@ include file="../footer.jsp" %>

</body>
</html>
