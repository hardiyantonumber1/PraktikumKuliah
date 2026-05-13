import java.util.ArrayList;

public class Buku {

    private String judul;
    private String kategori;
    private ArrayList<Penulis> penulis;

    public Buku(String judul, String kategori) {
        this.judul = judul;
        this.kategori = kategori;
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

    public ArrayList<Penulis> getPenulis() {
        return penulis;
    }

    public void tampilkanInfo() {

        System.out.println("Judul Buku : " + judul);
        System.out.println("Kategori   : " + kategori);
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