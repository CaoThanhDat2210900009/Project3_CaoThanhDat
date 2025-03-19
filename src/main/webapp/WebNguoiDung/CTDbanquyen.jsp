<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.BanQuyenDAO" %>
<%@ page import="DAO.SachDAO" %>
<%@ page import="DAO.TacGiaDAO" %>
<%@ page import="Model.CTDBanQuyen" %>
<%@ page import="Model.CTDSach" %>
<%@ page import="Model.CTDTacGia" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Bản Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nxb_bq.css">
</head>
<body>
    <%@ include file="../WebNguoiDung/CTDheader.jsp" %>
    
    <div class="list-container">
        <h2>Danh Sách Bản Quyền</h2>

        <div class="banquyen-cards">
            <%
                BanQuyenDAO banQuyenDao = new BanQuyenDAO();
                SachDAO sachDao = new SachDAO();
                TacGiaDAO tacGiaDao = new TacGiaDAO();
                List<CTDBanQuyen> banQuyenList = banQuyenDao.getAllBanQuyen();

                if (banQuyenList != null && !banQuyenList.isEmpty()) {
                    for (CTDBanQuyen banQuyen : banQuyenList) {
                        // Lấy thông tin sách và tác giả dựa trên ID
                        CTDSach sach = sachDao.getSachByMaSach(banQuyen.getMaSach());
                        CTDTacGia tacGia = tacGiaDao.getTacGiaByMaTacGia(banQuyen.getMaTacGia());
            %>
            <div class="banquyen-card">
                <div class="banquyen-info">
                    <h3>Tên Sách: <%= sach != null ? sach.getTenSach() : "Chưa có thông tin" %></h3>
                    <p><strong>Tên Tác Giả:</strong> <%= tacGia != null ? tacGia.getTen() : "Chưa có thông tin" %></p>
                    <p><strong>Ngày Bắt Đầu:</strong> <%= banQuyen.getNgayBatDau() %></p>
                    <p><strong>Ngày Kết Thúc:</strong> <%= banQuyen.getNgayKetThuc() %></p>
                    <p><strong>Loại Bản Quyền:</strong> <%= banQuyen.getLoaiBanQuyen() %></p>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <p>Không có bản quyền nào để hiển thị.</p>
            <%
                }
            %>
        </div>
    </div>

    <%@ include file="../WebNguoiDung/CTDfooter.jsp" %>
</body>
</html>
