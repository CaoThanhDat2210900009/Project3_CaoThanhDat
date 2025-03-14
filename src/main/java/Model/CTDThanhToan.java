package Model;

import java.sql.Date;

public class CTDThanhToan {
	private int maThanhToan;
    private int maTacGia;
    private int maSach;
    private double soTien;
    private Date ngayThanhToan;

    // Constructor
    public CTDThanhToan(int maThanhToan, int maTacGia, int maSach, double soTien, Date ngayThanhToan) {
        this.maThanhToan = maThanhToan;
        this.maTacGia = maTacGia;
        this.maSach = maSach;
        this.soTien = soTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    // Getters và Setters
    public int getMaThanhToan() { return maThanhToan; }
    public void setMaThanhToan(int maThanhToan) { this.maThanhToan = maThanhToan; }
    public int getMaTacGia() { return maTacGia; }
    public void setMaTacGia(int maTacGia) { this.maTacGia = maTacGia; }
    public int getMaSach() { return maSach; }
    public void setMaSach(int maSach) { this.maSach = maSach; }
    public double getSoTien() { return soTien; }
    public void setSoTien(double soTien) { this.soTien = soTien; }
    public Date getNgayThanhToan() { return ngayThanhToan; }
    public void setNgayThanhToan(Date ngayThanhToan) { this.ngayThanhToan = ngayThanhToan; }
}
