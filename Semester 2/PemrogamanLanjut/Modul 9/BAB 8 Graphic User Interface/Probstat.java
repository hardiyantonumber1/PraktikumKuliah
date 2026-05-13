//  Mata Kuliah: Probabilitas dan Statistika (Probstat)
//  Rumus: Tugas 25% + Kuis 15% + UTS 30% + UAS 30%
public class Probstat extends MataKuliah {

    public Probstat() {
        super("Probstat");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (tugas * 0.25) + (kuis * 0.15) + (uts * 0.30) + (uas * 0.30);
    }
}
