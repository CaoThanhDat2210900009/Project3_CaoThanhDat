package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDNhaXuatBan;

public class NhaXuatBanDAO {
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

    public void addNhaXuatBan(CTDNhaXuatBan nxb) {
        String query = "INSERT INTO NhaXuatBan (ten, dia_chi, thong_tin_lien_he) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nxb.getTen());
            stmt.setString(2, nxb.getDiaChi());
            stmt.setString(3, nxb.getThongTinLienHe());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNhaXuatBan(int maNxb) {
        String query = "DELETE FROM NhaXuatBan WHERE ma_nxb = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNxb);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CTDNhaXuatBan> getAllNhaXuatBan() {
        List<CTDNhaXuatBan> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhaXuatBan";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDNhaXuatBan nxb = new CTDNhaXuatBan(
                        rs.getInt("ma_nxb"),
                        rs.getString("ten"),
                        rs.getString("dia_chi"),
                        rs.getString("thong_tin_lien_he")
                );
                danhSach.add(nxb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public CTDNhaXuatBan getNhaXuatBanByMa(int maNxb) {
        String query = "SELECT * FROM NhaXuatBan WHERE ma_nxb = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNxb);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDNhaXuatBan(
                            rs.getInt("ma_nxb"),
                            rs.getString("ten"),
                            rs.getString("dia_chi"),
                            rs.getString("thong_tin_lien_he")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateNhaXuatBan(CTDNhaXuatBan nxb) {
        String query = "UPDATE NhaXuatBan SET ten = ?, dia_chi = ?, thong_tin_lien_he = ? WHERE ma_nxb = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nxb.getTen());
            stmt.setString(2, nxb.getDiaChi());
            stmt.setString(3, nxb.getThongTinLienHe());
            stmt.setInt(4, nxb.getMaNxb());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}