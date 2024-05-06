import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuQuanLy extends JFrame {
    private JPanel Menu;
    private JButton btnThongKe;

    private JFrame currentFrame;

    public MenuQuanLy() {
        this.setContentPane(this.Menu);
        this.setTitle("Menu Quản lý");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        currentFrame = this;

        btnThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.setVisible(false);

                ThongKeFrm TKF = new ThongKeFrm();
                TKF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
    }
}
