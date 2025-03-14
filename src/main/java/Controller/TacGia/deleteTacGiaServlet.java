package Controller.TacGia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TacGiaDAO;

@WebServlet("/Backend/TacGia/deleteTacGia")
public class deleteTacGiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TacGiaDAO tacGiaDao;

    public void init() {
        tacGiaDao = new TacGiaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
        tacGiaDao.deleteTacGia(maTacGia);

        response.sendRedirect("CTDlistTacGia.jsp");
    }
}
