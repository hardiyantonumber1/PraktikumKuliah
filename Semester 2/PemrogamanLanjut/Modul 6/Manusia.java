public class Manusia {
    private String nama;
    private boolean jenisKelamin; // true = laki-laki
    private String nik;
    private boolean menikah;

    public Manusia(String nama, String nik, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }

    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) return 25;
            else return 20;
        }
        return 15;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    public String getJenisKelamin() {
        return jenisKelamin ? "Laki-laki" : "Perempuan";
    }

    @Override
    public String toString() {
        return "nama          : " + nama +
                "\nnik           : " + nik +
                "\njenisKelamin  : " + getJenisKelamin() +
                "\npendapatan    : " + getPendapatan();
    }
}