package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDThanhToan;

public class ThanhToanDAO {
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

    // Thêm một giao dịch thanh toán mới
    public void addThanhToan(CTDThanhToan thanhToan) {
        String query = "INSERT INTO ThanhToan (ma_tac_gia, ma_sach, so_tien, ngay_thanh_toan) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, thanhToan.getMaTacGia());
            stmt.setInt(2, thanhToan.getMaSach());
            stmt.setDouble(3, thanhToan.getSoTien());
            stmt.setDate(4, new java.sql.Date(thanhToan.getNgayThanhToan().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa một giao dịch thanh toán
    public void deleteThanhToan(int maThanhToan) {
        String query = "DELETE FROM ThanhToan WHERE ma_thanh_toan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maThanhToan);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả các giao dịch thanh toán
    public List<CTDThanhToan> getAllThanhToan() {
        List<CTDThanhToan> danhSach = new ArrayList<>();
        String query = "SELECT * FROM ThanhToan";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDThanhToan thanhToan = new CTDThanhToan(
                        rs.getInt("ma_thanh_toan"),
                        rs.getInt("ma_tac_gia"),
                        rs.getInt("ma_sach"),
                        rs.getDouble("so_tien"),
                        rs.getDate("ngay_thanh_toan")
                );
                danhSach.add(thanhToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin giao dịch thanh toán theo mã
    public CTDThanhToan getThanhToanByMa(int maThanhToan) {
        String query = "SELECT * FROM ThanhToan WHERE ma_thanh_toan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maThanhToan);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDThanhToan(
                            rs.getInt("ma_thanh_toan"),
                            rs.getInt("ma_tac_gia"),
                            rs.getInt("ma_sach"),
                            rs.getDouble("so_tien"),
                            rs.getDate("ngay_thanh_toan")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin giao dịch thanh toán
    public void updateThanhToan(CTDThanhToan thanhToan) {
        String query = "UPDATE ThanhToan SET ma_tac_gia = ?, ma_sach = ?, so_tien = ?, ngay_thanh_toan = ? WHERE ma_thanh_toan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, thanhToan.getMaTacGia());
            stmt.setInt(2, thanhToan.getMaSach());
            stmt.setDouble(3, thanhToan.getSoTien());
            stmt.setDate(4, new java.sql.Date(thanhToan.getNgayThanhToan().getTime()));
            stmt.setInt(5, thanhToan.getMaThanhToan());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
