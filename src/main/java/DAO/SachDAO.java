package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDSach;

public class SachDAO {
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

    public void addSach(CTDSach sach) {
        String query = "INSERT INTO Sach (ten_sach, isbn, nam_xuat_ban, the_loai, ma_tac_gia, ma_nxb, hinh_anh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTenSach());
            stmt.setString(2, sach.getIsbn());
            stmt.setInt(3, sach.getNamXuatBan());
            stmt.setString(4, sach.getTheLoai());
            stmt.setInt(5, sach.getMaTacGia());
            stmt.setInt(6, sach.getMaNxb());
            stmt.setString(7, sach.getHinhAnh()); // Lưu đường dẫn ảnh hoặc dữ liệu ảnh dạng base64
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSach(int maSach) {
        String query = "DELETE FROM Sach WHERE ma_sach = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSach);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CTDSach> getAllSach() {
        List<CTDSach> danhSach = new ArrayList<>();
        String query = "SELECT * FROM Sach";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDSach sach = new CTDSach(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("isbn"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getString("the_loai"),
                        rs.getInt("ma_tac_gia"),
                        rs.getInt("ma_nxb"),
                        rs.getString("hinh_anh")
                );
                danhSach.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public CTDSach getSachByMaSach(int maSach) {
        String query = "SELECT * FROM Sach WHERE ma_sach = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSach);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDSach(
                            rs.getInt("ma_sach"),
                            rs.getString("ten_sach"),
                            rs.getString("isbn"),
                            rs.getInt("nam_xuat_ban"),
                            rs.getString("the_loai"),
                            rs.getInt("ma_tac_gia"),
                            rs.getInt("ma_nxb"),
                            rs.getString("hinh_anh")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSach(CTDSach sach) {
        String query = "UPDATE Sach SET ten_sach = ?, isbn = ?, nam_xuat_ban = ?, the_loai = ?, ma_tac_gia = ?, ma_nxb = ?, hinh_anh = ? WHERE ma_sach = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTenSach());
            stmt.setString(2, sach.getIsbn());
            stmt.setInt(3, sach.getNamXuatBan());
            stmt.setString(4, sach.getTheLoai());
            stmt.setInt(5, sach.getMaTacGia());
            stmt.setInt(6, sach.getMaNxb());
            stmt.setString(7, sach.getHinhAnh());
            stmt.setInt(8, sach.getMaSach());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}