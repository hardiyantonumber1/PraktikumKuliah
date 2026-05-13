public class Main {

    public static void main(String[] args) {

        Perpustakaan perpus = new Perpustakaan("Perpustakaan Hardi");

        Penulis p1 = new Penulis("Hardiyanto");
        Penulis p2 = new Penulis("Fiil Maulana");
        Penulis p3 = new Penulis("Samec");
        Penulis p4 = new Penulis("Rafi Rahman");
        Penulis p5 = new Penulis("Naressuan");

        Penulis[] daftarPenulis = {p1, p2, p3, p4, p5};

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

            for (int j = 1; j <= 5; j++) {

                Buku buku = new Buku(
                        "Buku " + kategori[i] + " " + j,
                        kategori[i]
                );

                buku.tambahPenulis(daftarPenulis[j - 1]);

                perpus.tambahBuku(buku);
            }
        }

        perpus.tampilkanSemuaBuku();
    }
}