class LayananTransaksi {

    public static void topUp(Pelanggan pelanggan, double jumlah) {
        pelanggan.tambahSaldo(jumlah);
        System.out.println("Top up berhasil. Saldo sekarang: " + pelanggan.getSaldo());
    }

    public static void pembelian(Pelanggan pelanggan, double jumlah) {
        if (pelanggan.isDiblokir()) {
            System.out.println("Akun diblokir!");
            return;
        }

        double cashback = hitungCashback(pelanggan, jumlah);

        if (!pelanggan.kurangiSaldo(jumlah)) {
            System.out.println("Transaksi gagal! Saldo tidak mencukupi.");
            return;
        }

        pelanggan.tambahSaldo(cashback);

        System.out.println("Transaksi berhasil!");
        System.out.println("Cashback: " + cashback);
        System.out.println("Saldo akhir: " + pelanggan.getSaldo());
    }

    private static double hitungCashback(Pelanggan pelanggan, double jumlah) {
        JenisRekening jenis = pelanggan.getJenisRekening();

        switch (jenis) {
            case SILVER:
                return (jumlah > 1_000_000) ? jumlah * 0.05 : 0;

            case GOLD:
                if (jumlah > 1_000_000) return jumlah * 0.07;
                return jumlah * 0.02;

            case PLATINUM:
                if (jumlah > 1_000_000) return jumlah * 0.10;
                return jumlah * 0.05;

            default:
                return 0;
        }
    }
}