package domain;

import java.util.Date;

public class SinhVien {
    private Integer ID;
    private String matKhau;
    private String ten;
    private Date ngaySinh;
    private String khoa;
    private String queQuan;
    private String diaChi;


    public SinhVien() {
        super();
    }

    public SinhVien(Integer ID, String matKhau, String ten, Date ngaySinh, String khoa, String queQuan, String diaChi) {
        this.ID = ID;
        this.matKhau = matKhau;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.khoa = khoa;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
    }

    public Integer getID() {
        return ID;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
