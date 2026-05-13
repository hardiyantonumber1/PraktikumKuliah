import java.util.ArrayList;

public class Buku {

    private String judul;
    private String kategori;
    private String sinopsis;
    private ArrayList<Penulis> penulis;

    public Buku(String judul, String kategori, String sinopsis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = new ArrayList<>();
    }

    public void tambahPenulis(Penulis p) {
        penulis.add(p);
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int hitungJumlahKataSinopsis() {
        String[] kata = sinopsis.split(" ");
        return kata.length;
    }

    public int cekKesamaan(Buku bukuLain) {

        int sama = 0;
        int total = 3;

        if (this.judul.equalsIgnoreCase(bukuLain.judul)) {
            sama++;
        }

        if (this.kategori.equalsIgnoreCase(bukuLain.kategori)) {
            sama++;
        }

        if (this.sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) {
            sama++;
        }

        return (sama * 100) / total;
    }

    public Buku copy() {

        Buku bukuBaru = new Buku(this.judul, this.kategori, this.sinopsis);

        for (Penulis p : penulis) {
            bukuBaru.tambahPenulis(p);
        }

        return bukuBaru;
    }

    public void tampilkanInfo() {

        System.out.println("Judul Buku : " + judul);
        System.out.println("Kategori   : " + kategori);
        System.out.println("Sinopsis   : " + sinopsis);
        System.out.println("Jumlah kata sinopsis : " + hitungJumlahKataSinopsis());

        System.out.print("Penulis    : ");

        for (int i = 0; i < penulis.size(); i++) {

            System.out.print(penulis.get(i).getNamaPenulis());

            if (i < penulis.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n----------------------------------");
    }

}