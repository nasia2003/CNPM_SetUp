package domain;

public class MonHoc {
    private Integer ID;
    private String tenMonHoc;
    private Integer soTinChi;

    public MonHoc() {
    }

    public MonHoc(Integer ID, String tenMonHoc, Integer soTinChi) {
        this.ID = ID;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public Integer getID() {
        return ID;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }
}
