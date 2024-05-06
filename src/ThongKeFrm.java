import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThongKeFrm extends JFrame {
    private JButton btnThongKeKhaGioi;
    private JPanel panelThongKe;
    private JButton btnTrangChu;
    private JFrame currentFrame;

    public ThongKeFrm() {
        this.setContentPane(this.panelThongKe);
        this.setTitle("Thống kê");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        currentFrame = this;
        btnThongKeKhaGioi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.setVisible(false);

                ThongKeKhaGioiFrm TKKGF = new ThongKeKhaGioiFrm();
                TKKGF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThongKeFrm.this.processWindowEvent(new java.awt.event.WindowEvent(ThongKeFrm.this, java.awt.event.WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
