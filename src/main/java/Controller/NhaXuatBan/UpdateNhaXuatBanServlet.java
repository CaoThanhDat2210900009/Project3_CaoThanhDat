package Controller.NhaXuatBan;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NhaXuatBanDAO;
import Model.CTDNhaXuatBan;

@WebServlet("/Backend/NhaXuatBan/updateNhaXuatBan")
public class UpdateNhaXuatBanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaXuatBanDAO nxbDAO;

    public void init() {
        nxbDAO = new NhaXuatBanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNxb = Integer.parseInt(request.getParameter("maNxb"));
        CTDNhaXuatBan nxb = nxbDAO.getNhaXuatBanByMa(maNxb);
        request.setAttribute("nxb", nxb);

        RequestDispatcher dispatcher = request.getRequestDispatcher("CTDupdateNXB.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maNxb = Integer.parseInt(request.getParameter("maNxb"));
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thongTinLienHe = request.getParameter("thongTinLienHe");

        CTDNhaXuatBan updatedNxb = new CTDNhaXuatBan(maNxb, ten, diaChi, thongTinLienHe);
        nxbDAO.updateNhaXuatBan(updatedNxb);

        response.sendRedirect("CTDlistNXB.jsp");
    }
}
