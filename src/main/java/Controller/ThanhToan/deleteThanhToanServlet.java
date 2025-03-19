package Controller.ThanhToan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ThanhToanDAO;

@WebServlet("/Backend/ThanhToan/deleteThanhToan")
public class deleteThanhToanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ThanhToanDAO thanhToanDao;

    public void init() {
        thanhToanDao = new ThanhToanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
        thanhToanDao.deleteThanhToan(maThanhToan);

        response.sendRedirect("CTDlistThanhToan.jsp");
    }
}
