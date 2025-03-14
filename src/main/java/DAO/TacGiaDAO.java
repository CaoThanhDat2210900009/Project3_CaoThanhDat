package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDTacGia;

public class TacGiaDAO {
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

    public void addTacGia(CTDTacGia tacGia) {
        String query = "INSERT INTO TacGia (ten, ngay_sinh, quoc_tich, thong_tin_lien_he, hinh_anh) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tacGia.getTen());
            stmt.setDate(2, new java.sql.Date(tacGia.getNgaySinh().getTime()));
            stmt.setString(3, tacGia.getQuocTich());
            stmt.setString(4, tacGia.getThongTinLienHe());
            stmt.setString(5, tacGia.getHinhAnh());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTacGia(int maTacGia) {
        String query = "DELETE FROM TacGia WHERE ma_tac_gia = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maTacGia);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CTDTacGia> getAllTacGia() {
        List<CTDTacGia> danhSach = new ArrayList<>();
        String query = "SELECT * FROM TacGia";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDTacGia tacGia = new CTDTacGia(
                        rs.getInt("ma_tac_gia"),
                        rs.getString("ten"),
                        rs.getDate("ngay_sinh"),
                        rs.getString("quoc_tich"),
                        rs.getString("thong_tin_lien_he"),
                        rs.getString("hinh_anh")
                );
                danhSach.add(tacGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public CTDTacGia getTacGiaByMaTacGia(int maTacGia) {
        String query = "SELECT * FROM TacGia WHERE ma_tac_gia = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maTacGia);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDTacGia(
                            rs.getInt("ma_tac_gia"),
                            rs.getString("ten"),
                            rs.getDate("ngay_sinh"),
                            rs.getString("quoc_tich"),
                            rs.getString("thong_tin_lien_he"),
                            rs.getString("hinh_anh")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTacGia(CTDTacGia tacGia) {
        String query = "UPDATE TacGia SET ten = ?, ngay_sinh = ?, quoc_tich = ?, thong_tin_lien_he = ?, hinh_anh = ? WHERE ma_tac_gia = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tacGia.getTen());
            stmt.setDate(2, new java.sql.Date(tacGia.getNgaySinh().getTime()));
            stmt.setString(3, tacGia.getQuocTich());
            stmt.setString(4, tacGia.getThongTinLienHe());
            stmt.setString(5, tacGia.getHinhAnh());
            stmt.setInt(6, tacGia.getMaTacGia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}