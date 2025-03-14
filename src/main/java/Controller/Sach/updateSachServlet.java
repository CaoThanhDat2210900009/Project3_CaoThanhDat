package Controller.Sach;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SachDAO;
import Model.CTDSach;

@WebServlet("/Backend/Sach/updateSach")
public class updateSachServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SachDAO sachDao;

    public void init() {
        sachDao = new SachDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSach = Integer.parseInt(request.getParameter("maSach"));
        CTDSach sach = sachDao.getSachByMaSach(maSach);
        request.setAttribute("sach", sach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/Sach/CTDupdateSach.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int maSach = Integer.parseInt(request.getParameter("maSach"));
            String tenSach = request.getParameter("tenSach");
            String isbn = request.getParameter("isbn");
            int namXuatBan = Integer.parseInt(request.getParameter("namXuatBan"));
            String theLoai = request.getParameter("theLoai");
            int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
            int maNxb = Integer.parseInt(request.getParameter("maNxb"));
            String hinhAnh = request.getParameter("hinhAnh"); // Xử lý ảnh

            CTDSach sach = new CTDSach(maSach, tenSach, isbn, namXuatBan, theLoai, maTacGia, maNxb, hinhAnh);
            sachDao.updateSach(sach);

            response.sendRedirect("CTDlistSach.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu nhập không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/Sach/CTDupdateSach.jsp");
            dispatcher.forward(request, response);
        }
    }
}