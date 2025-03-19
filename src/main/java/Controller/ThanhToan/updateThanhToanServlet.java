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

@WebServlet("/Backend/ThanhToan/updateThanhToan")
public class updateThanhToanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ThanhToanDAO thanhToanDao;

    public void init() {
        thanhToanDao = new ThanhToanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
            CTDThanhToan thanhToan = thanhToanDao.getThanhToanByMa(maThanhToan);
            request.setAttribute("thanhToan", thanhToan);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Mã thanh toán không hợp lệ.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ThanhToan/CTDupdateThanhToan.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
            int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
            int maSach = Integer.parseInt(request.getParameter("maSach"));
            double soTien = Double.parseDouble(request.getParameter("soTien"));
            Date ngayThanhToan = Date.valueOf(request.getParameter("ngayThanhToan"));

            CTDThanhToan thanhToan = new CTDThanhToan(maThanhToan, maTacGia, maSach, soTien, ngayThanhToan);
            thanhToanDao.updateThanhToan(thanhToan);

            response.sendRedirect("CTDlistThanhToan.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu nhập không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ThanhToan/CTDupdateThanhToan.jsp");
            dispatcher.forward(request, response);
        }
    }
}
