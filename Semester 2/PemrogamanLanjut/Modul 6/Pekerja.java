import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int year, int month, int day, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(year, month, day);
        this.jumlahAnak = 0;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = Period.between(tahunMasuk, LocalDate.now()).getYears();

        if (lamaKerja <= 5) return 0.05 * gaji;
        else if (lamaKerja <= 10) return 0.1 * gaji;
        else return 0.15 * gaji;
    }

    public double getTunjanganAnak() {
        return jumlahAnak * 20;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + gaji + getBonus() + getTunjanganAnak();
    }

    public double getGaji() {
        return gaji;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ntahun masuk   : " + tahunMasuk.getDayOfMonth() + " "
                + tahunMasuk.getMonthValue() + " " + tahunMasuk.getYear() +
                "\njumlah anak   : " + jumlahAnak +
                "\ngaji          : " + gaji;
    }
}