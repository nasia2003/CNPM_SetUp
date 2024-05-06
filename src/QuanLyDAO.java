import domain.DiemSinhVienChiTiet;
import domain.ThongKeKhaGioi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDAO {
    private static QuanLyDAO instance;
    private Connection con;
    public QuanLyDAO() {
        String dbUrl = "jdbc:mysql://localhost:3306/CNPM";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "12345";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QuanLyDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyDAO();
        }
        return instance;
    }
    public List<ThongKeKhaGioi> getListSinhVienKhaGioi() {
        String sql = "SELECT\n" +
                "    sv.*,\n" +
                "    SUM(mh.SoTinChi) AS TongSoTinChi,\n" +
                "    sv_mh.HocKi,\n" +
                "    ROUND((SUM((kq.DiemChuyenCan * lhp.HeSo1 + kq.DiemGiuaKi * lhp.HeSo2 + kq.DiemCuoiKi * lhp.HeSo3) * mh.SoTinChi) / SUM(mh.SoTinChi)), 2) AS DiemTrungBinh\n" +
                "FROM SinhVien sv\n" +
                "JOIN SV_LHP sv_lhp ON sv.ID = sv_lhp.SinhVienID\n" +
                "JOIN LopHocPhan lhp ON lhp.ID = sv_lhp.LopHocPhanID\n" +
                "JOIN MonHoc mh ON mh.ID = lhp.MonHocID\n" +
                "JOIN SV_MH sv_mh ON sv_mh.SinhVienID = sv.ID AND sv_mh.MonHocID = mh.ID\n" +
                "JOIN KetQua kq ON kq.SV_LHP_ID = sv_lhp.ID\n" +
                "GROUP BY sv.ID, sv_mh.HocKi\n" +
                "HAVING DiemTrungBinh >= 8\n" +
                "ORDER BY DiemTrungBinh DESC;";
        List<ThongKeKhaGioi> res = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("ID");
                String matKhau = rs.getString("MatKhau");
                String ten = rs.getString("Ten");
                Date ngaySinh = rs.getDate("NgaySinh");
                String khoa = rs.getString("Khoa");
                String queQuan = rs.getString("QueQuan");
                String diaChi = rs.getString("DiaChi");
                Integer tongTinChi = rs.getInt("TongSoTinChi");
                String hocKi = rs.getString("HocKi");
                Float diemTBHocKi = rs.getFloat("DiemTrungBinh");
                ThongKeKhaGioi thongKeKhaGioi = new ThongKeKhaGioi(ID, matKhau, ten, ngaySinh, khoa, queQuan, diaChi, diemTBHocKi, tongTinChi, hocKi);
                res.add(thongKeKhaGioi);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<DiemSinhVienChiTiet> getDiemSinhVienChiTiet(Integer SinhVienID)
    {
        String sql = "SELECT \n" +
                "    mh.*,\n" +
                "    ROUND(kq.DiemChuyenCan * lhp.HeSo1 + kq.DiemGiuaKi * lhp.HeSo2 + kq.DiemCuoiKi * lhp.HeSo3) AS DiemTongKet\n" +
                "FROM SinhVien sv\n" +
                "JOIN SV_LHP sv_lhp ON sv.ID = sv_lhp.SinhVienID\n" +
                "JOIN LopHocPhan lhp ON lhp.ID = sv_lhp.LopHocPhanID\n" +
                "JOIN MonHoc mh ON mh.ID = lhp.MonHocID\n" +
                "JOIN SV_MH sv_mh ON sv_mh.SinhVienID = sv.ID AND sv_mh.MonHocID = mh.ID\n" +
                "JOIN KetQua kq ON kq.SV_LHP_ID = sv_lhp.ID\n" +
                "where sv.ID = " + SinhVienID.toString();
        List<DiemSinhVienChiTiet> res = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer monHocID = rs.getInt("ID");
                Integer soTinChi = rs.getInt("SoTinChi");
                String tenMonHoc = rs.getString("TenMonHoc");
                Float diemTongKet = rs.getFloat("DiemTongKet");
                DiemSinhVienChiTiet diemSinhVienChiTiet = new DiemSinhVienChiTiet(monHocID, tenMonHoc, soTinChi, diemTongKet);
                res.add(diemSinhVienChiTiet);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
