import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPendaftaran extends JFrame implements ActionListener {

    JLabel title = new JLabel("FORM DAFTAR ULANG MAHASISWA BARU");

    JLabel lblNama = new JLabel("Nama Lengkap");
    JLabel lblTgl = new JLabel("Tanggal Lahir");
    JLabel lblNo = new JLabel("Nomor Pendaftaran");
    JLabel lblTelp = new JLabel("No. Telp");
    JLabel lblAlamat = new JLabel("Alamat");
    JLabel lblEmail = new JLabel("E-mail");

    JTextField txtNama = new JTextField();
    JTextField txtTgl = new JTextField();
    JTextField txtNo = new JTextField();
    JTextField txtTelp = new JTextField();
    JTextArea txtAlamat = new JTextArea();
    JTextField txtEmail = new JTextField();

    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");

    JScrollPane scrollAlamat = new JScrollPane(txtAlamat);

    public FormPendaftaran() {

        setTitle("Daftar Ulang Mahasiswa");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(230, 240, 255));

        title.setBounds(70, 20, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        lblNama.setBounds(50, 80, 150, 25);
        txtNama.setBounds(220, 80, 200, 25);

        lblTgl.setBounds(50, 120, 150, 25);
        txtTgl.setBounds(220, 120, 200, 25);

        lblNo.setBounds(50, 160, 150, 25);
        txtNo.setBounds(220, 160, 200, 25);

        lblTelp.setBounds(50, 200, 150, 25);
        txtTelp.setBounds(220, 200, 200, 25);

        lblAlamat.setBounds(50, 240, 150, 25);
        scrollAlamat.setBounds(220, 240, 200, 70);

        lblEmail.setBounds(50, 330, 150, 25);
        txtEmail.setBounds(220, 330, 200, 25);

        btnSubmit.setBounds(120, 390, 100, 35);
        btnReset.setBounds(260, 390, 100, 35);

        btnSubmit.addActionListener(this);

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtTgl.setText("");
                txtNo.setText("");
                txtTelp.setText("");
                txtAlamat.setText("");
                txtEmail.setText("");
            }
        });

        add(title);

        add(lblNama);
        add(txtNama);

        add(lblTgl);
        add(txtTgl);

        add(lblNo);
        add(txtNo);

        add(lblTelp);
        add(txtTelp);

        add(lblAlamat);
        add(scrollAlamat);

        add(lblEmail);
        add(txtEmail);

        add(btnSubmit);
        add(btnReset);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (txtNama.getText().isEmpty() ||
                txtTgl.getText().isEmpty() ||
                txtNo.getText().isEmpty() ||
                txtTelp.getText().isEmpty() ||
                txtAlamat.getText().isEmpty() ||
                txtEmail.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Semua kolom harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);

        } else {

            int konfirmasi = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah anda yakin data yang Anda isi sudah benar?",
                    "Konfirmasi",
                    JOptionPane.OK_CANCEL_OPTION);

            if (konfirmasi == JOptionPane.OK_OPTION) {

                new HasilData(
                        txtNama.getText(),
                        txtTgl.getText(),
                        txtNo.getText(),
                        txtTelp.getText(),
                        txtAlamat.getText(),
                        txtEmail.getText()
                );
            }
        }
    }
}