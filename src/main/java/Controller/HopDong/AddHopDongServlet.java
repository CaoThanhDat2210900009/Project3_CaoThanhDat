package Controller.HopDong;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HopDongDAO;
import Model.CTDHopDong;

@WebServlet("/Backend/HopDong/addHopDong")
public class AddHopDongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HopDongDAO hopDongDAO;

    public void init() {
        hopDongDAO = new HopDongDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int maTacGia = Integer.parseInt(request.getParameter("maTacGia"));
        int maNxb = Integer.parseInt(request.getParameter("maNxb"));
        Date ngayKy = Date.valueOf(request.getParameter("ngayKy"));
        double tyLeHoanTac = Double.parseDouble(request.getParameter("tyLeHoanTac"));

        CTDHopDong newHopDong = new CTDHopDong(0, maTacGia, maNxb, ngayKy, tyLeHoanTac);
        hopDongDAO.addHopDong(newHopDong);

        response.sendRedirect("CTDlistHopDong.jsp");
    }
}
