package Controller.Sach;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SachDAO;

@WebServlet("/Backend/Sach/deleteSach")
public class deleteSachServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SachDAO sachDao;

    public void init() {
        sachDao = new SachDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSach = Integer.parseInt(request.getParameter("maSach"));
        sachDao.deleteSach(maSach);

        response.sendRedirect("CTDlistSach.jsp");
    }
}
