package Model;
import java.util.Date;
public class CTDBanQuyen {
	private int maBanQuyen;
    private int maSach;
    private int maTacGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String loaiBanQuyen;

    
    // Constructor
    public CTDBanQuyen(int maBanQuyen, int maSach, int maTacGia, Date ngayBatDau, Date ngayKetThuc, String loaiBanQuyen) {
        this.maBanQuyen = maBanQuyen;
        this.maSach = maSach;
        this.maTacGia = maTacGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiBanQuyen = loaiBanQuyen;
    }

    // Getters và Setters
    public int getMaBanQuyen() { return maBanQuyen; }
    public void setMaBanQuyen(int maBanQuyen) { this.maBanQuyen = maBanQuyen; }
    public int getMaSach() { return maSach; }
    public void setMaSach(int maSach) { this.maSach = maSach; }
    public int getMaTacGia() { return maTacGia; }
    public void setMaTacGia(int maTacGia) { this.maTacGia = maTacGia; }
    public Date getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(Date ngayBatDau) { this.ngayBatDau = ngayBatDau; }
    public Date getNgayKetThuc() { return ngayKetThuc; }
    public void setNgayKetThuc(Date ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }
    public String getLoaiBanQuyen() { return loaiBanQuyen; }
    public void setLoaiBanQuyen(String loaiBanQuyen) { this.loaiBanQuyen = loaiBanQuyen; }
}
