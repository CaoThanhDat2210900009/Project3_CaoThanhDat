<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NhaXuatBanDAO" %>
<%@ page import="Model.CTDNhaXuatBan" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhà Xuất Bản</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <%@ include file="../header.jsp" %>

    <div class="list-container">
        <h2>Danh Sách Nhà Xuất Bản</h2>
        <a href="CTDaddNXB.jsp" class="add-btn">Thêm Nhà Xuất Bản</a>

        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên Nhà Xuất Bản</th>
                        <th>Địa Chỉ</th>
                        <th>Thông Tin Liên Hệ</th>
                        <th>Hành Động</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        NhaXuatBanDAO dao = new NhaXuatBanDAO();
                        List<CTDNhaXuatBan> nxbList = dao.getAllNhaXuatBan();

                        if (nxbList != null && !nxbList.isEmpty()) {
                            for (CTDNhaXuatBan nxb : nxbList) {
                    %>
                    <tr>
                        <td><%= nxb.getMaNxb() %></td>
                        <td><%= nxb.getTen() %></td>
                        <td><%= nxb.getDiaChi() %></td>
                        <td><%= nxb.getThongTinLienHe() %></td>
                        <td>
                            <a href="updateNhaXuatBan?maNxb=<%= nxb.getMaNxb() %>" class="action-btn edit-btn">Sửa</a>
                            <a href="deleteNhaXuatBan?maNxb=<%= nxb.getMaNxb() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="5" style="text-align:center;">Không có nhà xuất bản nào để hiển thị.</td>
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
