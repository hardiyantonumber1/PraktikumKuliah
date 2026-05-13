/**
 * Mata Kuliah: Algoritma dan Struktur Data (ASD)
 * Rumus: Tugas 15% + Kuis 25% + UTS 30% + UAS 30%
 */
public class ASD extends MataKuliah {

    public ASD() {
        super("ASD");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (tugas * 0.15) + (kuis * 0.25) + (uts * 0.30) + (uas * 0.30);
    }
}
