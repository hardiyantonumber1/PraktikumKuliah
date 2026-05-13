import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TFrameTugas extends Frame {

    // Label
    Label lbJudul, lbPilihMatkul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil, lbSemua;

    // TextField
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    // TextArea
    TextArea taHasil;

    // Button
    Button btnHitung, btnTampilSemua;

    // Radio Button (CheckboxGroup)
    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;

    // Objek MataKuliah (OOP)
    MataKuliah pemlan    = new Pemlan();
    MataKuliah asd       = new ASD();
    MataKuliah matkomlan = new Matkomlan();
    MataKuliah probstat  = new Probstat();

    // Simpan nilai akhir tiap matkul (null = belum dihitung)
    Map<String, Double> nilaiTersimpan = new HashMap<>();

    // Referensi ke matkul yang sedang aktif
    MataKuliah matkulAktif;

    public TFrameTugas() {
        setLayout(null);

        // Judul 
        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(110, 15, 180, 50);

        // Label pilih matkul 
        lbPilihMatkul = new Label("Pilih Mata Kuliah:");
        add(lbPilihMatkul);
        lbPilihMatkul.setBounds(10, 45, 120, 20);

        // Radio Buttons 
        cbg         = new CheckboxGroup();
        cbPemlan    = new Checkbox("Pemlan",    cbg, true);
        cbASD       = new Checkbox("ASD",       cbg, false);
        cbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        cbProbstat  = new Checkbox("Probstat",  cbg, false);

        add(cbPemlan);    cbPemlan.setBounds(10,  65, 80, 20);
        add(cbASD);       cbASD.setBounds(95,  65, 65, 20);
        add(cbMatkomlan); cbMatkomlan.setBounds(165, 65, 90, 20);
        add(cbProbstat);  cbProbstat.setBounds(260, 65, 80, 20);

        ItemListener radioListener = new RadioListener();
        cbPemlan.addItemListener(radioListener);
        cbASD.addItemListener(radioListener);
        cbMatkomlan.addItemListener(radioListener);
        cbProbstat.addItemListener(radioListener);

        // Label & TextField Nilai 
        lbTugas = new Label("Tugas :");
        add(lbTugas);
        lbTugas.setBounds(90, 100, 70, 20);

        txtTugas = new TextField("0");
        add(txtTugas);
        txtTugas.setBounds(200, 100, 80, 20);

        lbKuis = new Label("Kuis :");
        add(lbKuis);
        lbKuis.setBounds(90, 130, 70, 20);

        txtKuis = new TextField("0");
        add(txtKuis);
        txtKuis.setBounds(200, 130, 80, 20);

        lbUTS = new Label("UTS :");
        add(lbUTS);
        lbUTS.setBounds(90, 160, 70, 20);

        txtUTS = new TextField("0");
        add(txtUTS);
        txtUTS.setBounds(200, 160, 80, 20);

        lbUAS = new Label("UAS :");
        add(lbUAS);
        lbUAS.setBounds(90, 190, 70, 20);

        txtUAS = new TextField("0");
        add(txtUAS);
        txtUAS.setBounds(200, 190, 80, 20);

        lbHasil = new Label("Hasil :");
        add(lbHasil);
        lbHasil.setBounds(90, 220, 70, 20);

        txtHasil = new TextField("0");
        txtHasil.setEditable(false);
        add(txtHasil);
        txtHasil.setBounds(200, 220, 80, 20);

        // Tombol Hitung 
        btnHitung = new Button("Hitung");
        add(btnHitung);
        btnHitung.setBounds(140, 250, 100, 25);
        btnHitung.addActionListener(new HitungAction());

        // Label & TextArea Hasil Semua 
        lbSemua = new Label("HASIL NILAI SEMUA MATA KULIAH");
        add(lbSemua);
        lbSemua.setBounds(10, 285, 360, 20);

        taHasil = new TextArea("", 5, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        taHasil.setEditable(false);
        add(taHasil);
        taHasil.setBounds(10, 308, 360, 100);

        // Tombol Tampilkan Semua 
        btnTampilSemua = new Button("Tampilkan nilai semua matkul");
        add(btnTampilSemua);
        btnTampilSemua.setBounds(80, 420, 220, 25);
        btnTampilSemua.addActionListener(new TampilSemuaAction());

        // Set default matkul aktif
        matkulAktif = pemlan;
    }

    // Ambil MataKuliah yang sedang dipilih radio button
    private MataKuliah getMatkul(Checkbox cb) {
        if (cb == cbASD)       return asd;
        if (cb == cbMatkomlan) return matkomlan;
        if (cb == cbProbstat)  return probstat;
        return pemlan; // default Pemlan
    }

    // Kosongkan field input nilai
    private void kosongkanField() {
        txtTugas.setText("0");
        txtKuis.setText("0");
        txtUTS.setText("0");
        txtUAS.setText("0");
        txtHasil.setText("0");
    }

    // Listener Radio Button
    class RadioListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Checkbox dipilih = (Checkbox) e.getItemSelectable();
                matkulAktif = getMatkul(dipilih);
                kosongkanField();
            }
        }
    }

    // Listener Tombol Hitung
    class HitungAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double tugas = Double.parseDouble(txtTugas.getText().trim());
                double kuis  = Double.parseDouble(txtKuis.getText().trim());
                double uts   = Double.parseDouble(txtUTS.getText().trim());
                double uas   = Double.parseDouble(txtUAS.getText().trim());

                matkulAktif.setNilai(tugas, kuis, uts, uas);
                double nilaiAkhir = matkulAktif.hitungNilaiAkhir();

                // Tampilkan di TextField Hasil
                txtHasil.setText(String.format("%.1f", nilaiAkhir));

                // Simpan nilai akhir
                nilaiTersimpan.put(matkulAktif.getNama(), nilaiAkhir);

            } catch (NumberFormatException ex) {
                txtHasil.setText("Error");
            }
        }
    }

    // Listener Tombol Tampilkan Semua
    class TampilSemuaAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            String[] urutan = {"Pemlan", "ASD", "Matkomlan", "Probstat"};
            for (String nama : urutan) {
                if (nilaiTersimpan.containsKey(nama)) {
                    sb.append(String.format("%-10s : %.1f%n", nama, nilaiTersimpan.get(nama)));
                } else {
                    sb.append(String.format("%-10s : (belum dihitung)%n", nama));
                }
            }
            taHasil.setText(sb.toString());
        }
    }
}
