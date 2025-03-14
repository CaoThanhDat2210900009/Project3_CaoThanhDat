package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.CTDHopDong;

public class HopDongDAO {
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

    public void addHopDong(CTDHopDong hopDong) {
        String query = "INSERT INTO HopDong (ma_tac_gia, ma_nxb, ngay_ky, ty_le_hoan_tac) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, hopDong.getMaTacGia());
            stmt.setInt(2, hopDong.getMaNxb());
            stmt.setDate(3, hopDong.getNgayKy());
            stmt.setDouble(4, hopDong.getTyLeHoanTac());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHopDong(int maHopDong) {
        String query = "DELETE FROM HopDong WHERE ma_hop_dong = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maHopDong);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CTDHopDong> getAllHopDong() {
        List<CTDHopDong> danhSach = new ArrayList<>();
        String query = "SELECT * FROM HopDong";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CTDHopDong hopDong = new CTDHopDong(
                        rs.getInt("ma_hop_dong"),
                        rs.getInt("ma_tac_gia"),
                        rs.getInt("ma_nxb"),
                        rs.getDate("ngay_ky"),
                        rs.getDouble("ty_le_hoan_tac")
                );
                danhSach.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public CTDHopDong getHopDongByMa(int maHopDong) {
        String query = "SELECT * FROM HopDong WHERE ma_hop_dong = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maHopDong);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CTDHopDong(
                            rs.getInt("ma_hop_dong"),
                            rs.getInt("ma_tac_gia"),
                            rs.getInt("ma_nxb"),
                            rs.getDate("ngay_ky"),
                            rs.getDouble("ty_le_hoan_tac")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateHopDong(CTDHopDong hopDong) {
        String query = "UPDATE HopDong SET ma_tac_gia = ?, ma_nxb = ?, ngay_ky = ?, ty_le_hoan_tac = ? WHERE ma_hop_dong = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, hopDong.getMaTacGia());
            stmt.setInt(2, hopDong.getMaNxb());
            stmt.setDate(3, hopDong.getNgayKy());
            stmt.setDouble(4, hopDong.getTyLeHoanTac());
            stmt.setInt(5, hopDong.getMaHopDong());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}