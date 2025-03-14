package Controller.TacGia;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TacGiaDAO;
import Model.CTDTacGia;
@WebServlet("/Backend/TacGia/updateTacGia")
public class updateTacGiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TacGiaDAO tacGiaDao;

    public void init() {
        tacGiaDao = new TacGiaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
            CTDTacGia tacGia = tacGiaDao.getTacGiaByMaTacGia(maTacGia);
            request.setAttribute("tacGia", tacGia);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Mã tác giả không hợp lệ.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/TacGia/CTDupdateTacGia.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
            String ten = request.getParameter("ten");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String quocTich = request.getParameter("quocTich");
            String thongTinLienHe = request.getParameter("thongTinLienHe");
            String hinhAnh = request.getParameter("hinhAnh");

            CTDTacGia tacGia = new CTDTacGia(maTacGia, ten, ngaySinh, quocTich, thongTinLienHe, hinhAnh);
            tacGiaDao.updateTacGia(tacGia);

            response.sendRedirect("CTDlistTacGia.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu nhập không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/Sach/CTDupdateTacGia.jsp");
            dispatcher.forward(request, response);
        }
        }
    }

