import java.util.ArrayList;

public class Perpustakaan {

    private String namaPerpustakaan;
    private ArrayList<Buku> daftarBuku;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanSemuaBuku() {

        String[] kategori = {
                "Teknologi",
                "Filsafat",
                "Sejarah",
                "Agama",
                "Psikologi",
                "Politik",
                "Fiksi"
        };

        System.out.println("Perpustakaan : " + namaPerpustakaan);
        System.out.println("====================================");

        for (String k : kategori) {

            System.out.println("\n===== KATEGORI " + k.toUpperCase() + " =====");

            for (Buku b : daftarBuku) {

                if (b.getKategori().equalsIgnoreCase(k)) {
                    b.tampilkanInfo();
                }

            }

        }
    }
}