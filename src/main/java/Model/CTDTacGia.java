package Model;

import java.util.Date;

//Model cho bảng TacGia
public class CTDTacGia {
 private int maTacGia;
 private String ten;
 private Date ngaySinh;
 private String quocTich;
 private String thongTinLienHe;
 private String hinhAnh; // Đường dẫn hình ảnh

 // Constructor
 public CTDTacGia(int maTacGia, String ten, Date ngaySinh, String quocTich, String thongTinLienHe, String hinhAnh) {
     this.maTacGia = maTacGia;
     this.ten = ten;
     this.ngaySinh = ngaySinh;
     this.quocTich = quocTich;
     this.thongTinLienHe = thongTinLienHe;
     this.hinhAnh = hinhAnh;
 }

 // Getters và Setters
 public int getMaTacGia() { return maTacGia; }
 public void setMaTacGia(int maTacGia) { this.maTacGia = maTacGia; }
 public String getTen() { return ten; }
 public void setTen(String ten) { this.ten = ten; }
 public Date getNgaySinh() { return ngaySinh; }
 public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }
 public String getQuocTich() { return quocTich; }
 public void setQuocTich(String quocTich) { this.quocTich = quocTich; }
 public String getThongTinLienHe() { return thongTinLienHe; }
 public void setThongTinLienHe(String thongTinLienHe) { this.thongTinLienHe = thongTinLienHe; }
 public String getHinhAnh() { return hinhAnh; }
 public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
}