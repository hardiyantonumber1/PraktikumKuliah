import javax.swing.*;
import java.awt.event.*;

public class FormPendaftaran extends JFrame implements ActionListener {

    JLabel lbnama = new JLabel("Nama Lengkap");
    JLabel lbtgl = new JLabel("Tanggal Lahir");
    JLabel lbno = new JLabel("Nomor Pendaftaran");
    JLabel lbtelp = new JLabel("No. Telp");
    JLabel lbalamat = new JLabel("Alamat");
    JLabel lbemail = new JLabel("E-mail");

    JTextField tfnama = new JTextField();
    JTextField tftgl = new JTextField();
    JTextField tfno = new JTextField();
    JTextField tftelp = new JTextField();
    JTextArea taalamat = new JTextArea();
    JTextField tfemail = new JTextField();

    JButton submit = new JButton("submit");

    FormPendaftaran() {

        setTitle("Form Daftar Ulang");
        setSize(350, 380);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbnama.setBounds(20, 20, 120, 20);
        tfnama.setBounds(150, 20, 150, 20);

        lbtgl.setBounds(20, 60, 120, 20);
        tftgl.setBounds(150, 60, 150, 20);

        lbno.setBounds(20, 100, 120, 20);
        tfno.setBounds(150, 100, 150, 20);

        lbtelp.setBounds(20, 140, 120, 20);
        tftelp.setBounds(150, 140, 150, 20);

        lbalamat.setBounds(20, 180, 120, 20);
        taalamat.setBounds(150, 180, 150, 50);

        lbemail.setBounds(20, 250, 120, 20);
        tfemail.setBounds(150, 250, 150, 20);

        submit.setBounds(220, 300, 80, 25);

        add(lbnama);
        add(tfnama);

        add(lbtgl);
        add(tftgl);

        add(lbno);
        add(tfno);

        add(lbtelp);
        add(tftelp);

        add(lbalamat);
        add(taalamat);

        add(lbemail);
        add(tfemail);

        add(submit);

        submit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (
            tfnama.getText().equals("") ||
            tftgl.getText().equals("") ||
            tfno.getText().equals("") ||
            tftelp.getText().equals("") ||
            taalamat.getText().equals("") ||
            tfemail.getText().equals("")
        ) {

            JOptionPane.showMessageDialog(
                null,
                "Semua kolom harus diisi!"
            );

        } else {

            int jawab = JOptionPane.showConfirmDialog(
                null,
                "Apakah anda yakin data yang Anda isi sudah benar?"
            );

            if (jawab == JOptionPane.OK_OPTION) {

                new HasilData(
                    tfnama.getText(),
                    tftgl.getText(),
                    tfno.getText(),
                    tftelp.getText(),
                    taalamat.getText(),
                    tfemail.getText()
                );

            }
        }
    }
}