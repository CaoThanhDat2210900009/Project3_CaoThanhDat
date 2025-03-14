package Model;

public class CTDAdmin {
    private int maAdmin;
    private String taiKhoan;
    private String matKhau;

    // Constructor không tham số
    public CTDAdmin() {}

    // Constructor đầy đủ tham số
    public CTDAdmin(int maAdmin, String taiKhoan, String matKhau) {
        this.maAdmin = maAdmin;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    // Getters và Setters
    public int getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(int maAdmin) {
        this.maAdmin = maAdmin;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}