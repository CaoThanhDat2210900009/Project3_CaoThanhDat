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

@WebServlet("/Backend/TacGia/addTacGia")
public class addTacGiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TacGiaDAO tacGiaDao;

    public void init() {
        tacGiaDao = new TacGiaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            String ten = request.getParameter("ten");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String quocTich = request.getParameter("quocTich");
            String thongTinLienHe = request.getParameter("thongTinLienHe");
            String hinhAnh = request.getParameter("hinhAnh");

            CTDTacGia newTacGia = new CTDTacGia(0, ten, ngaySinh, quocTich, thongTinLienHe, hinhAnh);
            tacGiaDao.addTacGia(newTacGia);

            response.sendRedirect("CTDlistTacGia.jsp");
        } catch (IllegalArgumentException | NullPointerException e) {
            request.setAttribute("error", "Dữ liệu nhập không hợp lệ. Vui lòng kiểm tra lại.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/TacGia/CTDaddTacGia.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/TacGia/CTDaddTacGia.jsp");
        dispatcher.forward(request, response);
    }
}