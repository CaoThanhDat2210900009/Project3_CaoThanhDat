package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.CTDAdmin;


public class AdminDAO {
	private String url = "jdbc:mysql://localhost:3306/project3_caothanhdat_2210900009";
    private String username = "root";
    private String password = "";

    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
    public CTDAdmin kiemTraDangNhap(String taiKhoan, String matKhau) {
        String query = "SELECT * FROM Admin WHERE tai_khoan = ? AND mat_khau = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, taiKhoan);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CTDAdmin(rs.getInt("ma_admin"), rs.getString("tai_khoan"), rs.getString("mat_khau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
