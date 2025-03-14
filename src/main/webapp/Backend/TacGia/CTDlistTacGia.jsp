<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.TacGiaDAO" %>
<%@ page import="Model.CTDTacGia" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Tác Giả</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<%@ include file="../header.jsp" %>

<div class="list-container">
    <h2>Danh Sách Tác Giả</h2>
    <a href="CTDaddTacGia.jsp" class="add-btn">Thêm Tác Giả</a>

    <div class="table-wrapper">
        <table>
            <thead>
    <tr>
        <th>Mã Tác Giả</th>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Quốc Tịch</th>
        <th>Thông Tin Liên Hệ</th>
        <th>Hình Ảnh</th> <!-- Thêm cột hình ảnh -->
        <th>Hành Động</th>
    </tr>
</thead>
<tbody>
    <%
        TacGiaDAO dao = new TacGiaDAO();
        List<CTDTacGia> tacGiaList = dao.getAllTacGia();
        if (tacGiaList != null && !tacGiaList.isEmpty()) {
            for (CTDTacGia tacGia : tacGiaList) {
    %>
    <tr>
        <td><%= tacGia.getMaTacGia() %></td>
        <td><%= tacGia.getTen() %></td>
        <td><%= tacGia.getNgaySinh() %></td>
        <td><%= tacGia.getQuocTich() %></td>
        <td><%= tacGia.getThongTinLienHe() %></td>
        <td>
            <img src="${pageContext.request.contextPath}/images/<%= tacGia.getHinhAnh() %>" alt="Hình ảnh tác giả" width="100" height="100">
        </td>
        <td>
            <a href="CTDupdateTacGia.jsp?maTacGia=<%= tacGia.getMaTacGia() %>" class="action-btn edit-btn">Sửa</a>
            <a href="deleteTacGia?maTacGia=<%= tacGia.getMaTacGia() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="7" style="text-align:center;">Không có tác giả nào để hiển thị.</td>
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
