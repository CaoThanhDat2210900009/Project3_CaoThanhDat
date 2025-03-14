package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TriTueDAO")
public class TriTueDAO extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/project3_caothanhdat_2210900009"; 
    private String username = "root"; 
    private String password = ""; 

    public Connection connect() throws SQLException {
        try {
            // Đăng ký Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
}
