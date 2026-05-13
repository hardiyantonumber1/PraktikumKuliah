public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return harga * berat;
    }

    @Override
    public String toString() {
        return String.format("%-13s | %-22s | Harga/gram: Rp%-10s | Berat: %.1f gram  | Harga Akhir: Rp%s",
                "[KuePesanan]",
                nama,
                String.format("%,.0f", harga),
                berat * 1000,
                String.format("%,.0f", hitungHarga()));
    }
}