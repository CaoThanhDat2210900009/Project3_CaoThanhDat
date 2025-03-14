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

@WebServlet("/Backend/BanQuyen/updateBanQuyen")
public class UpdateBanQuyenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BanQuyenDAO banQuyenDao;

    public void init() {
        banQuyenDao = new BanQuyenDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBanQuyen = Integer.parseInt(request.getParameter("maBanQuyen"));
        CTDBanQuyen banQuyen = banQuyenDao.getBanQuyenByMa(maBanQuyen);
        request.setAttribute("banQuyen", banQuyen);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/BanQuyen/CTDupdateBanQuyen.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maBanQuyen = Integer.parseInt(request.getParameter("maBanQuyen"));
        int maSach = Integer.parseInt(request.getParameter("maSach"));
        int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
        Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
        String loaiBanQuyen = request.getParameter("loaiBanQuyen");

        CTDBanQuyen banQuyen = new CTDBanQuyen(maBanQuyen, maSach, maTacGia, ngayBatDau, ngayKetThuc, loaiBanQuyen);
        banQuyenDao.updateBanQuyen(banQuyen);

        response.sendRedirect("CTDlistBanQuyen.jsp");
    }
}


