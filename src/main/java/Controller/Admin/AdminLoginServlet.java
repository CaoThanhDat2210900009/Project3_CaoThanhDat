package Controller.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import Model.CTDAdmin;

@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");

        AdminDAO adminDAO = new AdminDAO();
        CTDAdmin admin = adminDAO.kiemTraDangNhap(taiKhoan, matKhau);

        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            response.sendRedirect("Backend/index.jsp");
        } else {
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("Backend/login.jsp").forward(request, response);
        }
    }
}
