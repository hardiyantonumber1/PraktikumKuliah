import javax.swing.*;
import java.awt.*;

public class HasilData extends JFrame {

    JTextArea area = new JTextArea();

    public HasilData(String nama,
                     String tgl,
                     String no,
                     String telp,
                     String alamat,
                     String email) {

        setTitle("Data Mahasiswa");
        setSize(450, 350);
        setLocationRelativeTo(null);

        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        area.setText(
                "=========== DATA MAHASISWA ===========\n\n" +
                "Nama Lengkap      : " + nama + "\n" +
                "Tanggal Lahir     : " + tgl + "\n" +
                "No. Pendaftaran   : " + no + "\n" +
                "No. Telp          : " + telp + "\n" +
                "Alamat            : " + alamat + "\n" +
                "E-mail            : " + email
        );

        add(area);

        setVisible(true);
    }
}