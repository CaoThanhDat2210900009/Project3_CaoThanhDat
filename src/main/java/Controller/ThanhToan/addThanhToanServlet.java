package Controller.ThanhToan;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ThanhToanDAO;
import Model.CTDThanhToan;

@WebServlet("/Backend/ThanhToan/addThanhToan")
public class addThanhToanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ThanhToanDAO thanhToanDao;

    public void init() {
        thanhToanDao = new ThanhToanDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
            int maSach = Integer.parseInt(request.getParameter("maSach"));
            double soTien = Double.parseDouble(request.getParameter("soTien"));
            Date ngayThanhToan = Date.valueOf(request.getParameter("ngayThanhToan"));

            CTDThanhToan newThanhToan = new CTDThanhToan(0, maTacGia, maSach, soTien, ngayThanhToan);
            thanhToanDao.addThanhToan(newThanhToan);

            response.sendRedirect("CTDlistThanhToan.jsp");
        } catch (IllegalArgumentException | NullPointerException e) {
            request.setAttribute("error", "Dữ liệu nhập không hợp lệ. Vui lòng kiểm tra lại.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ThanhToan/CTDaddThanhToan.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ThanhToan/CTDaddThanhToan.jsp");
        dispatcher.forward(request, response);
    }
}
