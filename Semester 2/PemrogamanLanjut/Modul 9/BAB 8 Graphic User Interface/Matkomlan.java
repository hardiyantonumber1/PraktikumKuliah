//  Matkomlan
//  Rumus: Tugas 10% + Kuis 20% + UTS 35% + UAS 35%
public class Matkomlan extends MataKuliah {

    public Matkomlan() {
        super("Matkomlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (tugas * 0.10) + (kuis * 0.20) + (uts * 0.35) + (uas * 0.35);
    }
}
