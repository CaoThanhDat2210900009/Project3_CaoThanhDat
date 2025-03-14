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

@WebServlet("/Backend/NhaXuatBan/add")
public class AddNhaXuatBanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaXuatBanDAO nxbDAO;

    public void init() {
        nxbDAO = new NhaXuatBanDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thongTinLienHe = request.getParameter("thongTinLienHe");

        CTDNhaXuatBan newNxb = new CTDNhaXuatBan(0, ten, diaChi, thongTinLienHe);
        nxbDAO.addNhaXuatBan(newNxb);

        response.sendRedirect("CTDlistNXB.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CTDaddNXB.jsp");
        dispatcher.forward(request, response);
    }
}
