import java.awt.*;
import java.awt.event.*;

public class mainFrameTugas {
    public static void main(String[] args) {

        TFrameTugas window = new TFrameTugas();

        window.setTitle("Hitung Nilai Akhir dengan GUI java.awt");
        window.setSize(400, 470);

        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (layar.width - window.getWidth()) / 2;
        int y = (layar.height - window.getHeight()) / 2;

        window.setLocation(x, y);

        window.setVisible(true);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}