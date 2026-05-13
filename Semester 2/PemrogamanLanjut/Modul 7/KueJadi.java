public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    @Override
    public String toString() {
        return String.format("%-13s | %-22s | Harga/pcs:  Rp%-10s | Jumlah: %-6d pcs | Harga Akhir: Rp%s",
                "[KueJadi]",
                nama,
                String.format("%,.0f", harga),
                (int) jumlah,
                String.format("%,.0f", hitungHarga()));
    }
}