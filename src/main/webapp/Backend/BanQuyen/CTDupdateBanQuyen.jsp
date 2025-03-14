<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.BanQuyenDAO, DAO.SachDAO, DAO.TacGiaDAO, Model.CTDBanQuyen, Model.CTDSach, Model.CTDTacGia, java.util.List" %>

<% 
    int maBanQuyen = Integer.parseInt(request.getParameter("maBanQuyen"));

    BanQuyenDAO banQuyenDAO = new BanQuyenDAO();
    CTDBanQuyen banQuyen = banQuyenDAO.getBanQuyenByMa(maBanQuyen);

    SachDAO sachDAO = new SachDAO();
    TacGiaDAO tacGiaDAO = new TacGiaDAO();

    List<CTDSach> danhSachSach = sachDAO.getAllSach();
    List<CTDTacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Bản Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/suaxoa.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<h2>Cập Nhật Bản Quyền</h2>
<form action="updateBanQuyen" method="post">

    <input type="hidden" name="maBanQuyen" value="<%= banQuyen.getMaBanQuyen() %>">

    <label>Mã Sách:</label>
    <select name="maSach" required>
        <% for (CTDSach s : danhSachSach) { %>
            <option value="<%= s.getMaSach() %>" <%= (s.getMaSach() == banQuyen.getMaSach()) ? "selected" : "" %> >
                <%= s.getTenSach() %> (ID: <%= s.getMaSach() %>)
            </option>
        <% } %>
    </select>

    <label>Mã Tác Giả:</label>
    <select name="maTacGia" required>
        <% for (CTDTacGia tg : danhSachTacGia) { %>
            <option value="<%= tg.getMaTacGia() %>" <%= (tg.getMaTacGia() == banQuyen.getMaTacGia()) ? "selected" : "" %> >
                <%= tg.getTen() %> (ID: <%= tg.getMaTacGia() %>)
            </option>
        <% } %>
    </select>

    <label>Ngày Bắt Đầu:</label>
    <input type="date" name="ngayBatDau" value="<%= banQuyen.getNgayBatDau() %>" required>

    <label>Ngày Kết Thúc:</label>
    <input type="date" name="ngayKetThuc" value="<%= banQuyen.getNgayKetThuc() %>" required>

    <label>Loại Bản Quyền:</label>
    <select name="loaiBanQuyen">
        <option value="Độc quyền" <%= "Độc quyền".equals(banQuyen.getLoaiBanQuyen()) ? "selected" : "" %>>Độc quyền</option>
        <option value="Không độc quyền" <%= "Không độc quyền".equals(banQuyen.getLoaiBanQuyen()) ? "selected" : "" %>>Không độc quyền</option>
    </select>

    <button type="submit">Cập Nhật</button>
</form>

<a href="${pageContext.request.contextPath}/Backend/BanQuyen/CTDlistBanQuyen.jsp" class="back-link">Về Danh Sách</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
