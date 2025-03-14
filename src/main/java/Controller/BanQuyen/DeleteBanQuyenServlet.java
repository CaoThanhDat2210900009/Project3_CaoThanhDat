package Controller.BanQuyen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BanQuyenDAO;

@WebServlet("/Backend/BanQuyen/deleteBanQuyen")
public class DeleteBanQuyenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BanQuyenDAO banQuyenDao;

    public void init() {
        banQuyenDao = new BanQuyenDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBanQuyen = Integer.parseInt(request.getParameter("maBanQuyen"));
        banQuyenDao.deleteBanQuyen(maBanQuyen);
        response.sendRedirect("CTDlistBanQuyen.jsp");
    }
}
