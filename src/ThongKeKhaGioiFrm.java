import domain.ThongKeKhaGioi;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeKhaGioiFrm extends JFrame {
    private JPanel PanelThongKeKhaGioi;
    private JLabel labelThongKeKhaGioiFrm;
    private JTable tblSinhVienKhaGioi;
    private JScrollPane ScrollPanel;
    private JButton btnQuayLai;

    private JFrame currentFrame;

    public ThongKeKhaGioiFrm() {
        this.setContentPane(this.PanelThongKeKhaGioi);
        this.setTitle("Thống kê sinh viên khá giỏi");
        this.setSize(900, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        currentFrame = this;
        QuanLyDAO quanLyDAO = QuanLyDAO.getInstance();
        List<ThongKeKhaGioi> now = quanLyDAO.getListSinhVienKhaGioi();
        createTable(now);

        tblSinhVienKhaGioi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tblSinhVienKhaGioi.rowAtPoint(e.getPoint());

                currentFrame.setVisible(false);

                DiemSinhVienChiTietFrm DSVCTF = new DiemSinhVienChiTietFrm(now.get(row));
                DSVCTF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThongKeKhaGioiFrm.this.processWindowEvent(new java.awt.event.WindowEvent(ThongKeKhaGioiFrm.this, java.awt.event.WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    private void createTable(List<ThongKeKhaGioi> now) {
        DefaultTableModel model = new DefaultTableModel(
                null,
                new String[]{"STT", "Mã sinh viên", "Tên sinh viên", "Khóa học", "Học kì", "Tổng tín chỉ", "Điểm trung bình"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        if(now.isEmpty())
        {
            labelThongKeKhaGioiFrm.setText("Chưa có danh sách sinh viên khá giỏi!");
            return;
        }
        for(int i = 0; i < now.size(); i++)
        {
            ThongKeKhaGioi x = now.get(i);
            String[] tmp = {Integer.toString(i + 1), Integer.toString(x.getID()), x.getTen(), x.getKhoa(), x.getHocKi(), Integer.toString(x.getTongTinChi()), x.getDiemTBHocKi().toString()};
            model.addRow(tmp);
        }
        tblSinhVienKhaGioi.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblSinhVienKhaGioi.setDefaultRenderer(Object.class, centerRenderer);
        tblSinhVienKhaGioi.getTableHeader().setReorderingAllowed(false);
    }
}
