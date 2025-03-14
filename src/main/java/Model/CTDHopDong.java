package Model;

import java.sql.Date;

public class CTDHopDong {
	private int maHopDong;
    private int maTacGia;
    private int maNxb;
    private Date ngayKy;
    private double tyLeHoanTac;

    // Constructor
    public CTDHopDong(int maHopDong, int maTacGia, int maNxb, Date ngayKy, double tyLeHoanTac) {
        this.maHopDong = maHopDong;
        this.maTacGia = maTacGia;
        this.maNxb = maNxb;
        this.ngayKy = ngayKy;
        this.tyLeHoanTac = tyLeHoanTac;
    }

    // Getters và Setters
    public int getMaHopDong() { return maHopDong; }
    public void setMaHopDong(int maHopDong) { this.maHopDong = maHopDong; }
    public int getMaTacGia() { return maTacGia; }
    public void setMaTacGia(int maTacGia) { this.maTacGia = maTacGia; }
    public int getMaNxb() { return maNxb; }
    public void setMaNxb(int maNxb) { this.maNxb = maNxb; }
    public Date getNgayKy() { return ngayKy; }
    public void setNgayKy(Date ngayKy) { this.ngayKy = ngayKy; }
    public double getTyLeHoanTac() { return tyLeHoanTac; }
    public void setTyLeHoanTac(double tyLeHoanTac) { this.tyLeHoanTac = tyLeHoanTac; }
}
