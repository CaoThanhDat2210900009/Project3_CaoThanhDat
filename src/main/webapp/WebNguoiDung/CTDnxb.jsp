<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NhaXuatBanDAO" %>
<%@ page import="Model.CTDNhaXuatBan" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhà Xuất Bản</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nxb_bq.css">
</head>
<body>
    <%@ include file="../WebNguoiDung/CTDheader.jsp" %>

    <div class="list-container">
        <h2>Danh Sách Nhà Xuất Bản</h2>

        <div class="nxb-cards">
            <%
                NhaXuatBanDAO dao = new NhaXuatBanDAO();
                List<CTDNhaXuatBan> nxbList = dao.getAllNhaXuatBan();
                if (nxbList != null && !nxbList.isEmpty()) {
                    for (CTDNhaXuatBan nxb : nxbList) {
            %>
            <div class="nxb-card">
                <div class="nxb-info">
                    <h3><%= nxb.getTen() %></h3>
                    <p><strong>Địa Chỉ:</strong> <%= nxb.getDiaChi() %></p>
                    <p><strong>Thông Tin Liên Hệ:</strong> <%= nxb.getThongTinLienHe() %></p>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <p>Không có nhà xuất bản nào để hiển thị.</p>
            <%
                }
            %>
        </div>
    </div>

    <%@ include file="../WebNguoiDung/CTDfooter.jsp" %>
</body>
</html>
