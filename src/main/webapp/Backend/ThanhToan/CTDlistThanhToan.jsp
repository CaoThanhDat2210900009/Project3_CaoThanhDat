<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, DAO.ThanhToanDAO, Model.CTDThanhToan" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Giao Dịch Thanh Toán</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <%@ include file="../header.jsp" %>
    
    <div class="list-container">
        <h2>Danh Sách Giao Dịch Thanh Toán</h2>
        <a href="CTDaddThanhToan.jsp" class="add-btn">Thêm Giao Dịch</a>
        
        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Mã Sách</th>
                        <th>Mã Tác Giả</th>
                        <th>Số Tiền</th>
                        <th>Ngày Thanh Toán</th>
                        <th>Hành Động</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ThanhToanDAO dao = new ThanhToanDAO();
                        List<CTDThanhToan> thanhToanList = dao.getAllThanhToan();
                        if(thanhToanList != null && !thanhToanList.isEmpty()){
                            for(CTDThanhToan thanhToan : thanhToanList){
                    %>
                    <tr>
                        <td><%= thanhToan.getMaThanhToan() %></td>
                        <td><%= thanhToan.getMaSach() %></td>
                        <td><%= thanhToan.getMaTacGia() %></td>
                        <td><%= thanhToan.getSoTien() %></td>
                        <td><%= thanhToan.getNgayThanhToan() %></td>
                        <td>
                            <a href="updateThanhToan?maThanhToan=<%= thanhToan.getMaThanhToan() %>" class="action-btn edit-btn">Sửa</a>
                            <a href="deleteThanhToan?maThanhToan=<%= thanhToan.getMaThanhToan() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6" style="text-align:center;">Không có giao dịch thanh toán nào để hiển thị.</td>
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
