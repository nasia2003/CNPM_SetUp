package domain;

import java.util.Date;

public class ThongKeKhaGioi extends SinhVien {
    private Float diemTBHocKi;
    private Integer tongTinChi;
    private String hocKi;

    public ThongKeKhaGioi(Integer ID, String matKhau, String ten, Date ngaySinh, String khoa, String queQuan, String diaChi, Float diemTBHocKi, Integer tongTinChi, String hocKi) {
        super(ID, matKhau, ten, ngaySinh, khoa, queQuan, diaChi);
        this.diemTBHocKi = diemTBHocKi;
        this.tongTinChi = tongTinChi;
        this.hocKi = hocKi;
    }

    public Float getDiemTBHocKi() {
        return diemTBHocKi;
    }

    public void setDiemTBHocKi(Float diemTBHocKi) {
        this.diemTBHocKi = diemTBHocKi;
    }

    public Integer getTongTinChi() {
        return tongTinChi;
    }

    public void setTongTinChi(Integer tongTinChi) {
        this.tongTinChi = tongTinChi;
    }

    public String getHocKi() {
        return hocKi;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }
}
