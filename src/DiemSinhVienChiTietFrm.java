import domain.DiemSinhVienChiTiet;
import domain.SinhVien;
import domain.ThongKeKhaGioi;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class DiemSinhVienChiTietFrm extends JFrame {
    private JPanel panelDiemSinhVienChiTiet;
    private JButton btnQuayLai;
    private JTable tblDiemSinhVien;
    private JLabel labelName;
    private JLabel labelID;
    private JLabel labelSemester;
    private JLabel labelNameSV;
    private JLabel labelIDSV;
    private JLabel labelSemesterSV;
    private Integer ID_sv;

    public DiemSinhVienChiTietFrm(ThongKeKhaGioi SinhVien)
    {
        this.setContentPane(this.panelDiemSinhVienChiTiet);
        this.setTitle("Điểm chi tiết");
        this.setSize(900, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        labelNameSV.setText(SinhVien.getTen());
        labelIDSV.setText(SinhVien.getID().toString());
        labelSemesterSV.setText(SinhVien.getHocKi());

        QuanLyDAO quanLyDAO = QuanLyDAO.getInstance();
        List<DiemSinhVienChiTiet> now = quanLyDAO.getDiemSinhVienChiTiet(SinhVien.getID());
        createTable(now);
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiemSinhVienChiTietFrm.this.processWindowEvent(new java.awt.event.WindowEvent(DiemSinhVienChiTietFrm.this, java.awt.event.WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    private void createTable(List<DiemSinhVienChiTiet> now) {
        DefaultTableModel model = new DefaultTableModel(
                null,
                new String[]{"STT", "Mã môn học", "Tên môn học", "Số tín chỉ", "Điểm tổng kết"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        for(int i = 0; i < now.size(); i++)
        {
            DiemSinhVienChiTiet x = now.get(i);
            String[] tmp = {Integer.toString(i + 1), Integer.toString(x.getID()), x.getTenMonHoc(), x.getSoTinChi().toString(), x.getDiemTongKet().toString()};
            model.addRow(tmp);
        }

        tblDiemSinhVien.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblDiemSinhVien.setDefaultRenderer(Object.class, centerRenderer);
        tblDiemSinhVien.getTableHeader().setReorderingAllowed(false);

        tblDiemSinhVien.getColumn("Tên môn học").setPreferredWidth(400);
    }
}
