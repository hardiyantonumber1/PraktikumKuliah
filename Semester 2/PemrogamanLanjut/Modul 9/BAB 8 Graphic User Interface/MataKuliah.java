public abstract class MataKuliah {
    protected String nama;
    protected double tugas;
    protected double kuis;
    protected double uts;
    protected double uas;

    public MataKuliah(String nama) {
        this.nama = nama;
    }

    public void setNilai(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis  = kuis;
        this.uts   = uts;
        this.uas   = uas;
    }

    public abstract double hitungNilaiAkhir();

    public String getNama() {
        return nama;
    }
}
