<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.HopDongDAO" %>
<%@ page import="Model.CTDHopDong" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Hợp Đồng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <%@ include file="../header.jsp" %>

    <div class="list-container">
        <h2>Danh Sách Hợp Đồng</h2>
        <a href="CTDaddHopDong.jsp" class="add-btn">Thêm Hợp Đồng</a>

        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Mã Tác Giả</th>
                        <th>Mã NXB</th>
                        <th>Ngày Ký</th>
                        <th>Tỷ Lệ Hoàn Tác (%)</th>
                        <th>Hành Động</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        HopDongDAO dao = new HopDongDAO();
                        List<CTDHopDong> hdList = dao.getAllHopDong();

                        if (hdList != null && !hdList.isEmpty()) {
                            for (CTDHopDong hd : hdList) {
                    %>
                    <tr>
                        <td><%= hd.getMaHopDong() %></td>
                        <td><%= hd.getMaTacGia() %></td>
                        <td><%= hd.getMaNxb() %></td>
                        <td><%= hd.getNgayKy() %></td>
                        <td><%= hd.getTyLeHoanTac() %></td>
                        <td>
                            <a href="CTDupdateHopDong.jsp?maHopDong=<%= hd.getMaHopDong() %>" class="action-btn edit-btn">Sửa</a>
                            <a href="deleteHopDong?maHopDong=<%= hd.getMaHopDong() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6" style="text-align:center;">Không có hợp đồng nào để hiển thị.</td>
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
