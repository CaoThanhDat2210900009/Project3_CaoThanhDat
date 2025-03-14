package Controller.HopDong;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HopDongDAO;
import Model.CTDHopDong;

@WebServlet("/Backend/HopDong/updateHopDong")
public class UpdateHopDongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HopDongDAO hopDongDAO;

    public void init() {
        hopDongDAO = new HopDongDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maHopDong = Integer.parseInt(request.getParameter("maHopDong"));
        CTDHopDong hopDong = hopDongDAO.getHopDongByMa(maHopDong);
        request.setAttribute("hopDong", hopDong);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/HopDong/CTDupdateHopDong.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int maHopDong = Integer.parseInt(request.getParameter("maHopDong"));
        int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
        int maNxb = Integer.parseInt(request.getParameter("maNxb"));
        Date ngayKy = Date.valueOf(request.getParameter("ngayKy"));
        double tyLeHoanTac = Double.parseDouble(request.getParameter("tyLeHoanTac"));

        CTDHopDong hopDong = new CTDHopDong(maHopDong, maTacGia, maNxb, ngayKy, tyLeHoanTac);
        hopDongDAO.updateHopDong(hopDong);

        response.sendRedirect("CTDlistHopDong.jsp");
    }
}
