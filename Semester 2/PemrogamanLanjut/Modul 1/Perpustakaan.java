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

        System.out.println("Nama  : HARDIYANTO JAYA PRANATA");
        System.out.println("Nim   : 255150701111015");
        System.out.println("Kelas : TI - B");
        System.out.println();
        System.out.println("Perpustakaan : " + namaPerpustakaan);
        System.out.println("====================================");

        String[] kategori = {
                "Teknologi",
                "Filsafat",
                "Sejarah",
                "Agama",
                "Psikologi",
                "Politik",
                "Fiksi"
        };

        for (int i = 0; i < kategori.length; i++) {

            System.out.println("\n===== KATEGORI " + kategori[i].toUpperCase() + " =====");

            for (Buku b : daftarBuku) {

                if (b.getKategori().equals(kategori[i])) {
                    b.tampilkanInfo();
                }
            }
        }
    }
}