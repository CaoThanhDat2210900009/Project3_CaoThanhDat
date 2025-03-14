package Controller.HopDong;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HopDongDAO;

@WebServlet("/Backend/HopDong/deleteHopDong")
public class DeleteHopDongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HopDongDAO hopDongDAO;

    public void init() {
        hopDongDAO = new HopDongDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maHopDong = Integer.parseInt(request.getParameter("maHopDong"));
        hopDongDAO.deleteHopDong(maHopDong);

        response.sendRedirect("CTDlistHopDong.jsp");
    }
}
