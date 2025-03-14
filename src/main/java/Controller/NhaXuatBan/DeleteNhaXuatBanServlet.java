package Controller.NhaXuatBan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NhaXuatBanDAO;

@WebServlet("/Backend/NhaXuatBan/deleteNhaXuatBan")
public class DeleteNhaXuatBanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhaXuatBanDAO nxbDAO;

    public void init() {
        nxbDAO = new NhaXuatBanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNxb = Integer.parseInt(request.getParameter("maNxb"));
        nxbDAO.deleteNhaXuatBan(maNxb);

        response.sendRedirect("CTDlistNXB.jsp");
    }
}
