public class Main {
    public static void main(String[] args) {

        // 1. Array yang terdiri dari 20 kue
        Kue[] daftarKue = new Kue[20];

        // 2. Isi 20 objek kue dengan berbagai jenis (KuePesanan dan KueJadi)
        daftarKue[0]  = new KuePesanan("Lapis Legit",      50000, 0.5);
        daftarKue[1]  = new KuePesanan("Bolu Kukus",       30000, 0.3);
        daftarKue[2]  = new KuePesanan("Brownies Coklat",  45000, 0.4);
        daftarKue[3]  = new KuePesanan("Kue Pelangi",      60000, 0.6);
        daftarKue[4]  = new KuePesanan("Nastar Keju",      80000, 0.5);
        daftarKue[5]  = new KuePesanan("Bolu Pandan",      35000, 0.4);
        daftarKue[6]  = new KuePesanan("Kue Marmer",       40000, 0.5);
        daftarKue[7]  = new KuePesanan("Cheesecake",       90000, 0.7);
        daftarKue[8]  = new KuePesanan("Bika Ambon",       55000, 0.4);
        daftarKue[9]  = new KuePesanan("Kue Lumpur",       25000, 0.3);
        daftarKue[10] = new KueJadi("Donat Coklat",         8000, 10);
        daftarKue[11] = new KueJadi("Croissant",            15000,  5);
        daftarKue[12] = new KueJadi("Muffin Blueberry",     12000,  8);
        daftarKue[13] = new KueJadi("Eclair",               10000,  6);
        daftarKue[14] = new KueJadi("Sus Vla",               7000, 12);
        daftarKue[15] = new KueJadi("Kue Cubit",             5000, 20);
        daftarKue[16] = new KueJadi("Onde Onde",             4000, 15);
        daftarKue[17] = new KueJadi("Putu Ayu",              6000, 10);
        daftarKue[18] = new KueJadi("Klepon",                3000, 18);
        daftarKue[19] = new KueJadi("Risoles Mayo",          9000,  7);

        String garis = "=".repeat(116);
        String garisT = "-".repeat(116);
        System.out.println(garis);
        System.out.printf("%55s%n", "DAFTAR SEMUA KUE");
        System.out.println(garis);
        System.out.printf("%-4s %-12s | %-22s | %-24s | %-18s | %s%n",
                "No.", "Jenis", "Nama Kue", "Satuan Harga", "Qty", "Harga Akhir");
        System.out.println(garisT);
        for (int i = 0; i < daftarKue.length; i++) {
            System.out.printf("%2d. %s%n", (i + 1), daftarKue[i]);
        }
        System.out.println(garis);

        double totalHargaSemua = 0;
        for (int i = 0; i < daftarKue.length; i++) {
            totalHargaSemua += daftarKue[i].hitungHarga();
        }
        System.out.printf("  %-40s : Rp%,.0f%n", "Total Harga Semua Kue", totalHargaSemua);

        // ── 3c. Total harga & total berat KuePesanan ────────────────────────
        double totalHargaPesanan = 0;
        double totalBerat        = 0;
        for (int i = 0; i < daftarKue.length; i++) {
            if (daftarKue[i] instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) daftarKue[i];
                totalHargaPesanan += kp.hitungHarga();
                totalBerat        += kp.getBerat();
            }
        }
        System.out.println(garisT);
        System.out.println("  Ringkasan KuePesanan:");
        System.out.printf("  %-40s : %.0f gram%n",  "Total Berat", totalBerat * 1000);
        System.out.printf("  %-40s : Rp%,.0f%n",    "Total Harga KuePesanan", totalHargaPesanan);

        // ── 3d. Total harga & total jumlah KueJadi ──────────────────────────
        double totalHargaJadi = 0;
        double totalJumlah    = 0;
        for (int i = 0; i < daftarKue.length; i++) {
            if (daftarKue[i] instanceof KueJadi) {
                KueJadi kj = (KueJadi) daftarKue[i];
                totalHargaJadi += kj.hitungHarga();
                totalJumlah    += kj.getJumlah();
            }
        }
        System.out.println(garisT);
        System.out.println("  Ringkasan KueJadi:");
        System.out.printf("  %-40s : %.0f pcs%n",   "Total Jumlah", totalJumlah);
        System.out.printf("  %-40s : Rp%,.0f%n",    "Total Harga KueJadi", totalHargaJadi);

        // ── 3e. Kue dengan harga akhir terbesar ─────────────────────────────
        Kue kueTermahal = daftarKue[0];
        for (int i = 1; i < daftarKue.length; i++) {
            if (daftarKue[i].hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = daftarKue[i];
            }
        }
        System.out.println(garisT);
        System.out.println("  Kue dengan Harga Akhir Terbesar:");
        System.out.println("  " + kueTermahal);
        System.out.println(garis);
    }
}