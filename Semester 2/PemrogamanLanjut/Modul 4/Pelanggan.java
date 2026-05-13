class Pelanggan {
    private final String nomorPelanggan;
    private final String nama;
    private final String pin;
    private double saldo;
    private int jumlahSalah;
    private boolean diblokir;

    public Pelanggan(String nomorPelanggan, String nama, String pin, double saldo) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
        this.jumlahSalah = 0;
        this.diblokir = false;
    }

    public String getNomorPelanggan() { return nomorPelanggan; }
    public String getNama() { return nama; }
    public double getSaldo() { return saldo; }
    public boolean isDiblokir() { return diblokir; }

    public JenisRekening getJenisRekening() {
        return JenisRekening.dariKode(nomorPelanggan.substring(0, 2));
    }

    public boolean login(String inputPin) {
        if (diblokir) return false;

        if (this.pin.equals(inputPin)) {
            jumlahSalah = 0;
            return true;
        } else {
            jumlahSalah++;
            if (jumlahSalah >= 3) {
                diblokir = true;
                System.out.println("Akun diblokir karena 3x kesalahan PIN.");
            }
            return false;
        }
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
    }

    public boolean kurangiSaldo(double jumlah) {
        if (saldo - jumlah < 10000) return false;
        saldo -= jumlah;
        return true;
    }
}