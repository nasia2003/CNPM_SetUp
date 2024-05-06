package domain;

public class DiemSinhVienChiTiet extends MonHoc {
    private Float diemTongKet;

    public DiemSinhVienChiTiet(Integer ID, String tenMonHoc, Integer soTinChi, Float diemTongKet) {
        super(ID, tenMonHoc, soTinChi);
        this.diemTongKet = diemTongKet;
    }

    public Float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(Float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }
}
