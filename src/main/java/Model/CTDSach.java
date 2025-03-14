package Model;

public class CTDSach {
    private int maSach;
    private String tenSach;
    private String isbn;
    private int namXuatBan;
    private String theLoai;
    private int maTacGia;
    private int maNxb;
    private String hinhAnh; // Đường dẫn hình ảnh

    // Constructor
    public CTDSach(int maSach, String tenSach, String isbn, int namXuatBan, String theLoai, int maTacGia, int maNxb, String hinhAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.isbn = isbn;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.maTacGia = maTacGia;
        this.maNxb = maNxb;
        this.hinhAnh = hinhAnh;
    }

    // Getters và Setters
    public int getMaSach() { return maSach; }
    public void setMaSach(int maSach) { this.maSach = maSach; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }
    public String getTheLoai() { return theLoai; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }
    public int getMaTacGia() { return maTacGia; }
    public void setMaTacGia(int maTacGia) { this.maTacGia = maTacGia; }
    public int getMaNxb() { return maNxb; }
    public void setMaNxb(int maNxb) { this.maNxb = maNxb; }
    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
}
