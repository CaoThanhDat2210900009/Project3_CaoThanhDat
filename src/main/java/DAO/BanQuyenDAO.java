package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDBanQuyen;

public class BanQuyenDAO {
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

    public void addBanQuyen(CTDBanQuyen banQuyen) {
        String query = "INSERT INTO BanQuyen (ma_sach, ma_tac_gia, ngay_bat_dau, ngay_ket_thuc, loai_ban_quyen) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, banQuyen.getMaSach());
            stmt.setInt(2, banQuyen.getMaTacGia());
            stmt.setDate(3, new java.sql.Date(banQuyen.getNgayBatDau().getTime()));
            stmt.setDate(4, new java.sql.Date(banQuyen.getNgayKetThuc().getTime()));
            stmt.setString(5, banQuyen.getLoaiBanQuyen());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBanQuyen(int maBanQuyen) {
        String query = "DELETE FROM BanQuyen WHERE ma_ban_quyen = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maBanQuyen);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CTDBanQuyen> getAllBanQuyen() {
        List<CTDBanQuyen> danhSach = new ArrayList<>();
        String query = "SELECT * FROM BanQuyen";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDBanQuyen banQuyen = new CTDBanQuyen(
                        rs.getInt("ma_ban_quyen"),
                        rs.getInt("ma_sach"),
                        rs.getInt("ma_tac_gia"),
                        rs.getDate("ngay_bat_dau"),
                        rs.getDate("ngay_ket_thuc"),
                        rs.getString("loai_ban_quyen")
                );
                danhSach.add(banQuyen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public CTDBanQuyen getBanQuyenByMa(int maBanQuyen) {
        String query = "SELECT * FROM BanQuyen WHERE ma_ban_quyen = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maBanQuyen);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDBanQuyen(
                            rs.getInt("ma_ban_quyen"),
                            rs.getInt("ma_sach"),
                            rs.getInt("ma_tac_gia"),
                            rs.getDate("ngay_bat_dau"),
                            rs.getDate("ngay_ket_thuc"),
                            rs.getString("loai_ban_quyen")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBanQuyen(CTDBanQuyen banQuyen) {
        String query = "UPDATE BanQuyen SET ma_sach = ?, ma_tac_gia = ?, ngay_bat_dau = ?, ngay_ket_thuc = ?, loai_ban_quyen = ? WHERE ma_ban_quyen = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, banQuyen.getMaSach());
            stmt.setInt(2, banQuyen.getMaTacGia());
            stmt.setDate(3, new java.sql.Date(banQuyen.getNgayBatDau().getTime()));
            stmt.setDate(4, new java.sql.Date(banQuyen.getNgayKetThuc().getTime()));
            stmt.setString(5, banQuyen.getLoaiBanQuyen());
            stmt.setInt(6, banQuyen.getMaBanQuyen());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}