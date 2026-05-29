import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[INFO] Belum ada kendaraan dalam daftar.");
            return;
        }
        System.out.println("\n=== DAFTAR ARMADA GODRIVE ===");
        int no = 1;
        for (Kendaraan k : daftarKendaraan) {
            System.out.print(no + ". ");
            k.tampilInfo();
            no++;
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean isVIP) throws KendaraanTidakTersediaException {
        Kendaraan target = null;
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                target = k;
                break;
            }
        }

        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                "Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!"
            );
        }

        // Hitung biaya
        double biayaDasar = target.hitungBiayaDasar(lamaSewa);

        // Pisahkan biaya tambahan dari biaya dasar murni
        double biayaHarian = lamaSewa * target.getHargaSewaPerHari();
        double biayaTambahan = 0;
        String keteranganTambahan = "";

        if (target instanceof Mobil) {
            Mobil m = (Mobil) target;
            if (m.getJumlahKursi() > 5) {
                biayaTambahan = 50000;
                keteranganTambahan = "Tambahan Kursi (>5): Rp 50,000";
            }
        } else if (target instanceof Motor) {
            Motor mo = (Motor) target;
            if (mo.getJenisTransmisi().equalsIgnoreCase("Matik")) {
                biayaTambahan = 10000 * lamaSewa;
                keteranganTambahan = "Tambahan Asuransi Matik: Rp " + String.format("%,.0f", biayaTambahan);
            }
        }

        // Diskon VIP Member (10%)
        double diskonVIP = 0;
        if (isVIP) {
            diskonVIP = biayaDasar * 0.10;
        }

        // Diskon sewa > 7 hari (5%)
        double diskonLama = 0;
        if (lamaSewa > 7) {
            diskonLama = biayaDasar * 0.05;
        }

        double totalAkhir = biayaDasar - diskonVIP - diskonLama;

        // Ubah status kendaraan
        target.setTersedia(false);

        // Tampilkan transaksi
        System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("Unit         : %s (%s)%n", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("Lama Sewa    : %d hari%n", lamaSewa);
        System.out.printf("Biaya Dasar Harian : Rp %,.0f%n", biayaHarian);

        if (!keteranganTambahan.isEmpty()) {
            System.out.println(keteranganTambahan);
        }
        if (isVIP) {
            System.out.printf("Diskon Member VIP (10%%): -Rp %,.0f%n", diskonVIP);
        }
        if (lamaSewa > 7) {
            System.out.printf("Diskon Sewa > 7 Hari (5%%): -Rp %,.0f%n", diskonLama);
        }

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL BIAYA AKHIR: Rp %,.0f%n", totalAkhir);
    }

    public void kembalikanKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                if (k.isTersedia()) {
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + kode + ") tidak sedang disewa.");
                } else {
                    k.setTersedia(true);
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
                }
                return;
            }
        }
        System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
    }
}
