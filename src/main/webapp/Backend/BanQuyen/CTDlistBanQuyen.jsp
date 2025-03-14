<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.BanQuyenDAO" %>
<%@ page import="Model.CTDBanQuyen" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Bản Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <%@ include file="../header.jsp" %>
    
    <div class="list-container">
        <h2>Danh Sách Bản Quyền</h2>
        <a href="CTDaddBanQuyen.jsp" class="add-btn">Thêm Bản Quyền</a>
        
        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Mã Sách</th>
                        <th>Mã Tác Giả</th>
                        <th>Ngày Bắt Đầu</th>
                        <th>Ngày Kết Thúc</th>
                        <th>Loại Bản Quyền</th>
                        <th>Hành Động</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        BanQuyenDAO dao = new BanQuyenDAO();
                        List<CTDBanQuyen> banQuyenList = dao.getAllBanQuyen();
                        if(banQuyenList != null && !banQuyenList.isEmpty()){
                            for(CTDBanQuyen banQuyen : banQuyenList){
                    %>
                    <tr>
                        <td><%= banQuyen.getMaBanQuyen() %></td>
                        <td><%= banQuyen.getMaSach() %></td>
                        <td><%= banQuyen.getMaTacGia() %></td>
                        <td><%= banQuyen.getNgayBatDau() %></td>
                        <td><%= banQuyen.getNgayKetThuc() %></td>
                        <td><%= banQuyen.getLoaiBanQuyen() %></td>
                        <td>
                            <a href="updateBanQuyen?maBanQuyen=<%= banQuyen.getMaBanQuyen() %>" class="action-btn edit-btn">Sửa</a>
                            <a href="deleteBanQuyen?maBanQuyen=<%= banQuyen.getMaBanQuyen() %>" class="action-btn delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7" style="text-align:center;">Không có bản quyền nào để hiển thị.</td>
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
