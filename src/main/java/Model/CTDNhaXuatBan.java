package Model;

public class CTDNhaXuatBan {
	    private int maNxb;
	    private String ten;
	    private String diaChi;
	    private String thongTinLienHe;

	    // Constructor
	    public CTDNhaXuatBan(int maNxb, String ten, String diaChi, String thongTinLienHe) {
	        this.maNxb = maNxb;
	        this.ten = ten;
	        this.diaChi = diaChi;
	        this.thongTinLienHe = thongTinLienHe;
	    }

	    // Getters và Setters
	    public int getMaNxb() { return maNxb; }
	    public void setMaNxb(int maNxb) { this.maNxb = maNxb; }
	    public String getTen() { return ten; }
	    public void setTen(String ten) { this.ten = ten; }
	    public String getDiaChi() { return diaChi; }
	    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
	    public String getThongTinLienHe() { return thongTinLienHe; }
	    public void setThongTinLienHe(String thongTinLienHe) { this.thongTinLienHe = thongTinLienHe; }
	}


