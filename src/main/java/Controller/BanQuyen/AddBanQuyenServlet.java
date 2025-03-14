package Controller.BanQuyen;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BanQuyenDAO;
import Model.CTDBanQuyen;

@WebServlet("/Backend/BanQuyen/addBanQuyen")
public class AddBanQuyenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BanQuyenDAO banQuyenDao;

    public void init() {
        banQuyenDao = new BanQuyenDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maSach = Integer.parseInt(request.getParameter("maSach"));
        int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
        Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
        String loaiBanQuyen = request.getParameter("loaiBanQuyen");

        CTDBanQuyen newBanQuyen = new CTDBanQuyen(0, maSach, maTacGia, ngayBatDau, ngayKetThuc, loaiBanQuyen);
        banQuyenDao.addBanQuyen(newBanQuyen);

        response.sendRedirect("CTDlistBanQuyen.jsp");
    }
}